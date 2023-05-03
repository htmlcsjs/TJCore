package tjcore.common.metatileentities.multi.pipeline;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import tjcore.api.TJLog;
import tjcore.api.pipeline.IPipeline;

import java.util.List;

import static gregtech.api.metatileentity.multiblock.MultiblockAbility.*;
import static gregtech.api.unification.material.Materials.PolyvinylChloride;
import static gregtech.api.unification.material.Materials.Steel;
import static tjcore.api.pipeline.PipelineManager.PIPELINE.FLUID;
import static tjcore.api.pipeline.PipelineManager.PIPELINE.ITEM;
import static tjcore.common.CommonProxy.PipelineManager;

public class MetaTileEntityItemPipeline extends MultiblockWithDisplayBase implements IPipeline {

    boolean isSource;
    boolean isConnected = false;
    boolean connectionValid = false;
    Boolean initialSync = true;
    Integer frequency;
    int prevFreq = Integer.MIN_VALUE;

    ItemHandlerList inputs;
    ItemHandlerList outputs;
    int pipelikeTotal;
    int pipelikeRequirement = -1;
    NotifiableItemStackHandler pipelikeInput = new NotifiableItemStackHandler(1, this, false);
    MetaTileEntityItemPipeline connection;

    public MetaTileEntityItemPipeline(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public void setConnection(IPipeline pipeline) {
        if (pipeline == null) {
            this.connection = null;
            this.isConnected = false;
            return;
        }
        if (pipeline.getType() == getType()) {
            this.connection = (MetaTileEntityItemPipeline) pipeline;
            isConnected = true;
            this.writeCustomData(43, (buf) -> {buf.writeBoolean(isConnected);});
            computePipelikeRequirement();
            setIsSource(!pipeline.getIsSource());
        } else {
            TJLog.logger.debug("Invalid Pipeline Pairing");
        }
    }

    @Override
    public void disconnect(boolean recyclePipes) {
        this.connection = null;
        this.isConnected = false;
        this.connectionValid = false;
        if (recyclePipes) {
            pipelikeInput.insertItem(0, OreDictUnifier.get(OrePrefix.pipeNormalItem, PolyvinylChloride, Math.min(Math.min(pipelikeTotal, pipelikeRequirement), 64)), false);
        }
        this.pipelikeRequirement = -1;
        handleNetworkUpdate();
    }

    private void computePipelikeRequirement() {
        int distance = (int) Math.floor(connection.getPos().getDistance(getPos().getX(), getPos().getY(), getPos().getZ()));
        if (pipelikeRequirement < 0) {
            pipelikeRequirement =  (distance / 10) + 5;
            pipelikeTotal = pipelikeRequirement;
        }
    }

    private void toggleSource() {
        if (connection!=null) {
            connection.setIsSource(isSource);
        }
        setIsSource(!isSource);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        inputs = new ItemHandlerList(getAbilities(IMPORT_ITEMS));
        outputs = new ItemHandlerList(getAbilities(EXPORT_ITEMS));
    }

    @Override
    public void onRemoval() {
        PipelineManager.disconnect(frequency, this);
        super.onRemoval();
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            String connectionString = connectionValid ?
                    ("Connected to " + (isSource ? "output " : "input ") + "at\nX: " + connection.getPos().getX() + " Y: " + connection.getPos().getY() + " Z: " + connection.getPos().getZ())
                    : (connection != null ? "Connected, Needs Pipes" : "No Available Matching Frequency");
            textList.add(new TextComponentString(connectionString));
        }
        super.addDisplayText(textList);
    }

    @Override
    protected ModularUI.Builder createUITemplate(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 268);
        builder.image(7, 10, 162, 181, GuiTextures.DISPLAY);
        builder.label(11, 15, this.getMetaFullName(), 16777215);
        builder.widget((new AdvancedTextWidget(11, 29, this::addDisplayText, 16777215)).setMaxWidthLimit(156).setClickHandler(this::handleDisplayClick));
        builder.label(11, 51, "Frequency");
        builder.widget(new ImageWidget(9, 60, 158, 20, GuiTextures.DISPLAY));
        builder.widget(new TextFieldWidget2(14, 66, 148, 16, () -> frequency == null ? "" : String.valueOf(frequency), value -> {if(value != ""){setFrequency(value);}}).setNumbersOnly(Integer.MIN_VALUE, Integer.MAX_VALUE).setMaxLength(8));
        builder.widget(new CycleButtonWidget(15, 83, 50, 20, () -> isSource, value -> toggleSource(), "Output", "Input"));
        builder.widget(new ImageWidget(14, 140, 20, 20, GuiTextures.SLOT).setPredicate(() -> isConnected));
        builder.widget(new SlotWidget(pipelikeInput, 0, 15, 141));
        builder.widget(new SimpleTextWidget(15, 128, "", () -> isConnected ? (pipelikeRequirement > 0 ? "Pipe Requirement: " + pipelikeRequirement : "Requirement Satisfied") : "").setCenter(false));

        builder.bindPlayerInventory(entityPlayer.inventory, 184);
        return builder;
    }

    private void setFrequency(String value) {
        if (!getWorld().isRemote) {
            setFrequency(Integer.parseInt(value));
        }
    }

    private void setFrequency(int freq) {
        connectionValid = false;
        initialSync = false;
        if (!getWorld().isRemote) {
            if (frequency == null) {
                prevFreq = freq;
                frequency = freq;
                PipelineManager.tryConnect(freq, this);
            } else {
                prevFreq = frequency;
                if (prevFreq != freq) {
                    frequency = freq;
                    PipelineManager.disconnect(prevFreq, this);
                    PipelineManager.tryConnect(freq, this);
                }
            }
        }
    }



    @Override
    protected void updateFormedValid() {
        if (getOffsetTimer() % 20 == 0 && this.isSource && connectionValid && connection != null) {
            GTTransferUtils.moveInventoryItems(inputs, connection.outputs);
        }
        if (!connectionValid && connection != null) {
            if (getOffsetTimer() % 5 == 0 && !pipelikeInput.getStackInSlot(0).isEmpty() && pipelikeRequirement > 0) {
                ItemStack stack = pipelikeInput.extractItem(0, pipelikeInput.getStackInSlot(0).getCount(), true);
                if (stack.isItemEqual(OreDictUnifier.get(OrePrefix.pipeNormalItem, PolyvinylChloride))) {
                    ItemStack extracted = pipelikeInput.extractItem(0, Math.min(pipelikeInput.getStackInSlot(0).getCount(), pipelikeRequirement), false);
                    pipelikeRequirement -= extracted.getCount();
                    connection.pipelikeRequirement = pipelikeRequirement;
                    connection.handleNetworkUpdate();
                    this.handleNetworkUpdate();
                }
            }
            if (pipelikeRequirement <= 0) {
                pipelikeRequirement = 0;
                connectionValid = true;
            }
        }
        if (initialSync && frequency != null) {
            initialSync = false;
            PipelineManager.tryConnect(frequency, this);
            handleNetworkUpdate();
        }
    }

    public void handleNetworkUpdate() {
        this.writeCustomData(42, (buf) -> {
            buf.writeBoolean(isSource);
            buf.writeBoolean(isConnected);
            buf.writeInt(pipelikeRequirement);
        });
        this.markDirty();
    }

    public void receiveCustomData(int id, PacketBuffer buf) {
        super.receiveCustomData(id, buf);
        if (id == 42) {
            this.isSource = buf.readBoolean();
            this.isConnected = buf.readBoolean();
            this.pipelikeRequirement = buf.readInt();
        } else if (id == 43) {
            boolean test = buf.readBoolean();
            this.isConnected = test;
        }
    }

    public tjcore.api.pipeline.PipelineManager.PIPELINE getType() {
        return ITEM;
    }

    public void setIsSource(boolean source) {
        isSource = source;
    }

    public boolean getIsSource() {
        return isSource;
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle( "F#F",
                        "#P#",
                        "F#F")
                .aisle( "SSS",
                        "SFS",
                        "SsS")
                .where('F', states(MetaBlocks.FRAMES.get(Steel).getBlock(Steel)))
                .where('#', any())
                .where('s', selfPredicate())
                .where('S', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)).setMinGlobalLimited(5)
                        .or(abilities(IMPORT_ITEMS))
                        .or(abilities(EXPORT_ITEMS)))
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.HATCH_OVERLAY;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), true, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityItemPipeline(metaTileEntityId);
    }


    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        buf.writeBoolean(isSource);
        buf.writeInt(pipelikeRequirement);
        super.writeInitialSyncData(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        if (isSource != (buf.readBoolean())) {
            toggleSource();
        }
        pipelikeRequirement = buf.readInt();
        super.receiveInitialSyncData(buf);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        if (data.hasKey("freq")) {
            frequency = data.getInteger("freq");
        }

        pipelikeRequirement = data.getInteger("req");
        if (isSource != (data.getBoolean("out"))) {
            toggleSource();
        }
        super.readFromNBT(data);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setBoolean("out", isSource);
        data.setInteger("req", pipelikeRequirement);
        if (frequency != null) {
            data.setInteger("freq", frequency);
        }
        return super.writeToNBT(data);
    }
}
