package tjcore.common.pipelike.rotation;

import tjcore.api.axle.IRotationConsumer;
import tjcore.api.axle.IRotationProvider;
import tjcore.api.axle.ISpinnable;
import tjcore.common.TJTextures;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gregtech.api.unification.ore.OrePrefix.gear;
import static gregtech.api.unification.ore.OrePrefix.gearSmall;

public class TileEntityGearbox extends MetaTileEntity implements IRotationProvider, IRotationConsumer {

    private List<ISpinnable> inputFaces = new ArrayList<>();
    private List<ISpinnable> outputFaces= new ArrayList<>();

    private Map<EnumFacing, AxleWhole> axleWholeList = new HashMap<>();

    private Map<EnumFacing, Boolean> isOutput = new HashMap<>();

    private float rps;
    private float torque;

    public TileEntityGearbox(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);

        for(EnumFacing face : EnumFacing.VALUES) {
            isOutput.put(face, false);
        }
    }


    @Override
    public void consume() {
        float[] torques = new float[inputFaces.size()];
        float[] rpsArray = new float[inputFaces.size()];

        float max = 0;
        for(int i = 0; i< inputFaces.size(); i++) {
            torques[i] = inputFaces.get(i).pullTorque();
            rpsArray[i] = Math.abs(inputFaces.get(i).getRPS());
            if(max < rpsArray[i])
                max = rpsArray[i];
        }

        for(int i = 0; i< inputFaces.size(); i++) {
            torque += (torques[i] * (rpsArray[i] / max));
        }

        rps = max;
    }

    @Override
    public void pushRotation(float rotationSpeed, float torque) {
        for(ISpinnable face : outputFaces) {
            face.pushRotation(rotationSpeed, torque);
        }
    }

    @Override
    public void joinNet() {

        inputFaces.clear();
        outputFaces.clear();

        for(EnumFacing face : EnumFacing.VALUES) {
            TileEntity te = getWorld().getTileEntity(getPos().offset(face));
            if(te instanceof TileEntityRotationAxle) {
                AxleWhole axleWhole = ((TileEntityRotationAxle)te).getAxleWhole();
                if(axleWhole != null) {
                    axleWholeList.put(face, axleWhole);
                    if (isOutput.get(face)) {
                        outputFaces.add(((TileEntityRotationAxle) te).getAxleWhole());
                    } else {
                        inputFaces.add(((TileEntityRotationAxle) te).getAxleWhole());
                    }
                }
            }


        }
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if(playerIn.getHeldItem(hand).isItemEqual(OreDictUnifier.get(gear, Materials.Steel)) && !isOutput.get(facing)) {
            isOutput.put(facing, true);
            playerIn.getHeldItem(hand).shrink(1);
        }
        else if(playerIn.getHeldItem(hand).isItemEqual(OreDictUnifier.get(gearSmall, Materials.Steel)) && isOutput.get(facing)) {
            isOutput.put(facing, false);
            playerIn.getHeldItem(hand).shrink(1);
        }
        return super.onRightClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public float getRotation() {
        return rps;
    }

    @Override
    public void setAxleWhole(AxleWhole axle) {}

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new TileEntityGearbox(this.metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        IVertexOperation[] renderPipeline = ArrayUtils.add(pipeline, new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        Textures.WOOD_WALL.render(renderState, translation, renderPipeline, Cuboid6.full);
        for (EnumFacing face : EnumFacing.VALUES) {
            TJTextures.ROTATION_OVERLAY.renderSided(face, renderState, translation, pipeline);
        }
    }

    @Override
    public void update() {
        super.update();

        if (!getWorld().isRemote && getOffsetTimer() % 20 == 0) {
            joinNet();
        }

        consume();
        pushRotation(rps, torque / outputFaces.size());
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
}
