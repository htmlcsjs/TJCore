package tjcore.common.metatileentities.axle;

import net.minecraft.nbt.NBTTagCompound;
import tjcore.api.axle.IRotationConsumer;
import tjcore.api.axle.IRotationProvider;
import tjcore.api.axle.ISpinnable;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import tjcore.common.pipelike.rotation.AxleWhole;
import tjcore.common.pipelike.rotation.TileEntityRotationAxle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gregtech.api.unification.ore.OrePrefix.gear;
import static tjcore.common.TJTextures.*;

public class MetaTileEntityGearbox extends MetaTileEntity implements IRotationProvider, IRotationConsumer {

    private List<ISpinnable> inputFaces = new ArrayList<>();
    private List<ISpinnable> outputFaces= new ArrayList<>();

    private Map<EnumFacing, AxleWhole> axleWholeList = new HashMap<>();

    private Map<EnumFacing, Boolean> isOutput = new HashMap<>();

    private float rps;
    private float torque;

    public MetaTileEntityGearbox(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        for(EnumFacing face : EnumFacing.VALUES) {
            isOutput.put(face, false);
        }
    }


    @Override
    public void consume() {
        torque = 0;
        float[] torques = new float[inputFaces.size()];
        float[] rpsArray = new float[inputFaces.size()];
        float max = 0;
        for(int i = 0; i< inputFaces.size(); i++) {
            torques[i] = inputFaces.get(i).pullTorque();
            rpsArray[i] = Math.abs(inputFaces.get(i).getRPS());
            if(max < rpsArray[i])
                max = rpsArray[i];
        }
        for (int i = 0; i < inputFaces.size(); i++) {
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
            scheduleRenderUpdate();
            markDirty();
        }
        return super.onRightClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public boolean onCrowbarClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (isOutput.get(facing)) {
            isOutput.put(facing, false);
            playerIn.addItemStackToInventory(OreDictUnifier.get(gear, Materials.Steel));
            scheduleRenderUpdate();
            markDirty();
            return true;
        } else return false;
    }

    @Override
    public float getRotation() {
        return rps;
    }

    @Override
    public void setAxleWhole(AxleWhole axle) {}

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityGearbox(this.metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        for (EnumFacing f : EnumFacing.VALUES) {
            GEARBOX.renderSided(f, renderState, translation, pipeline);
            if (isOutput.get(f)) {
                ROTATION_OUT.renderOrientedState(renderState, translation, pipeline, f, true, true);
            }
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

    @Override
    public void readFromNBT(NBTTagCompound data) {
        for (EnumFacing f : EnumFacing.VALUES) {
            isOutput.put(f, data.getBoolean(f.toString()));
        }
        super.readFromNBT(data);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        for (EnumFacing f : EnumFacing.VALUES) {
            data.setBoolean(f.toString(), isOutput.get(f));
        }
        return super.writeToNBT(data);
    }
}
