package tjcore.common.metatileentities.axle;

import tjcore.TJValues;
import tjcore.api.axle.IRotationConsumer;
import tjcore.api.axle.IRotationProvider;
import tjcore.common.TJTextures;
import tjcore.common.pipelike.rotation.AxleWhole;
import tjcore.common.pipelike.rotation.TileEntityRotationAxle;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.CycleButtonWidget;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.TextFieldWidget2;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

public class MetaTileEntityCreativeRotation extends MetaTileEntity implements IRotationProvider, IRotationConsumer {

    private AxleWhole axle;

    private boolean source = false;
    private float rotationSpeed;
    private float torque;

    public MetaTileEntityCreativeRotation() {
        super(new ResourceLocation(TJValues.MODID, "creative_rotation"));
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        IVertexOperation[] renderPipeline = ArrayUtils.add(pipeline, new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        Textures.VOLTAGE_CASINGS[14].render(renderState, translation, renderPipeline, Cuboid6.full);
        for (EnumFacing face : EnumFacing.VALUES) {
            TJTextures.ROTATION_OVERLAY.renderSided(face, renderState, translation, pipeline);
        }
    }

    @Override
    public void onNeighborChanged() {
        joinNet();
    }

    public void pushRotation(float rotationSpeed, float torque) {
        axle.pushRotation(rotationSpeed, torque);
    }

    public void consume() {
        torque = axle.pullTorque();
        rotationSpeed = axle.revolutionsPerSecond;
    }

    public void joinNet() {
        for(int[] vec : TJValues.adjacentIntArr) {
            TileEntity te = getWorld().getTileEntity(getPos().add(vec[0],vec[1],vec[2]));
            if (te instanceof TileEntityRotationAxle) {
                axle = ((TileEntityRotationAxle) te).getAxleWhole();
                break;
            }
        }
    }

    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.defaultBuilder();
        builder.label(7, 32, "Speed");
        builder.widget(new ImageWidget(7, 44, 156, 20, GuiTextures.DISPLAY));
        builder.widget(new TextFieldWidget2(9, 50, 152, 16, () -> String.valueOf(rotationSpeed), value -> {
            if (!value.isEmpty()) {
                rotationSpeed = Float.parseFloat(value);
            }
        }));

        builder.label(7, 74, "Torque");
        //builder.widget(new ClickButtonWidget(7, 87, 20, 20, "-", data -> amps = --amps == -1 ? 0 : amps));
        builder.widget(new ImageWidget(29, 87, 118, 20, GuiTextures.DISPLAY));
        builder.widget(new TextFieldWidget2(31, 93, 114, 16, () -> String.valueOf(torque), value -> {
            if (!value.isEmpty()) {
                torque = Float.parseFloat(value);
            }
        }));

        //builder.dynamicLabel(7, 110, () -> "Energy I/O per sec: " + (source ? lastEnergyOutputPerSec : lastEnergyInputPerSec), 0x232323);

        //builder.widget(new CycleButtonWidget(7, 139, 77, 20, () -> active, value -> active = value, "gregtech.creative.activity.off", "gregtech.creative.activity.on"));
        builder.widget(new CycleButtonWidget(85, 139, 77, 20, () -> source, value -> {
            source = value;
        }, "Sink", "Source")); //TODO: localisation

        return builder.build(getHolder(), entityPlayer);
    }


    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityCreativeRotation();
    }
    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote){
            if (axle == null) {
                joinNet();
            } else {
                if (source) {
                    pushRotation(rotationSpeed, torque);
                } else {
                    consume();
                }
            }
        }
    }

    public float getRotation() {
        return rotationSpeed;
    }

    public void setAxleWhole(AxleWhole axleNew) {
        this.axle = axleNew;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setFloat("Speed", rotationSpeed);
        data.setFloat("Torque", torque);
        data.setBoolean("Source", source);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        rotationSpeed = data.getFloat("Speed");
        torque = data.getFloat("Torque");
        source = data.getBoolean("Source");
        super.readFromNBT(data);
    }
}
