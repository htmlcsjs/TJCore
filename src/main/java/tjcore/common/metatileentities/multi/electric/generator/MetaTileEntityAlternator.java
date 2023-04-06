package tjcore.common.metatileentities.multi.electric.generator;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tjcore.api.axle.IRotationConsumer;
import tjcore.common.blocks.BlockBearing;
import tjcore.common.blocks.BlockGeneratorCoil;
import tjcore.common.blocks.BlockTurbineBlades;
import tjcore.common.blocks.TJMetaBlocks;
import tjcore.common.pipelike.rotation.AxleWhole;
import tjcore.common.pipelike.rotation.BlockRotationAxle;
import tjcore.common.pipelike.rotation.TileEntityRotationAxle;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

import static gregtech.api.GTValues.V;
import static gregtech.api.unification.material.Materials.Steel;
import static gregtech.api.unification.material.Materials.SteelMagnetic;
import static gregtech.api.unification.ore.OrePrefix.block;

public class MetaTileEntityAlternator extends MultiblockWithDisplayBase implements IRotationConsumer {

    private int coilTier;
    private BlockPos bearingPos;

    private AxleWhole axleWhole;

    private IEnergyContainer energyOut;

    float outputCap;

    private float rps;
    private float torque;

    private float euOut;

    public MetaTileEntityAlternator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    public TraceabilityPredicate coils() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockGeneratorCoil) {
                BlockGeneratorCoil.CoilType coilType = ((BlockGeneratorCoil) block).getState(blockState);
                Object currentBlades = blockWorldState.getMatchContext().getOrPut("CoilType", coilType);
                return currentBlades.equals(coilType);
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockGeneratorCoil.CoilType.values())
                        .map(type -> new BlockInfo(TJMetaBlocks.BLOCK_GENERATOR_COIL.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

    public TraceabilityPredicate bearings() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockBearing) {
                if (blockState == TJMetaBlocks.BLOCK_BEARING.getState(BlockBearing.BearingType.GALVANIZED_STEEL_BEARING)) {
                    bearingPos = blockWorldState.getPos();
                    return true;
                }
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockBearing.BearingType.values())
                        .map(type -> new BlockInfo(TJMetaBlocks.BLOCK_BEARING.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

    @Override
    protected void updateFormedValid() {
        outputCap = (float) V[coilTier + 2];
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle( "F#F",
                        "###",
                        "F#F")
                .aisle( "SSS",
                        "CCC",
                        "SSS")
                .aisle( "SSS",
                        "CMC",
                        "SBS")
                .aisle( "SSS",
                        "CCC",
                        "SSS")
                .aisle( "#O#",
                        "#S#",
                        "#T#")
                .where('F', states(MetaBlocks.FRAMES.get(Steel).getBlock(Steel)))
                .where('#', any())
                .where('T', selfPredicate())
                .where('S', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('C', coils())
                .where('B', bearings())
                .where('O', abilities(MultiblockAbility.OUTPUT_ENERGY))
                .where('M', states(MetaBlocks.COMPRESSED.get(SteelMagnetic).getBlock(SteelMagnetic)))
                .build();
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof BlockGeneratorCoil.CoilType) {
            this.coilTier = ((BlockGeneratorCoil.CoilType) type).getTier();
        }
        this.energyOut = getAbilities(MultiblockAbility.OUTPUT_ENERGY).get(0);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            textList.add(new TextComponentString("Coil Tier: " + (coilTier + 1)));
            if (axleWhole != null) {
                textList.add(new TextComponentString("Rotations Per Second: " + rps ));
                textList.add(new TextComponentString("Torque: " + torque ));
                textList.add(new TextComponentString("Maximum EU Output: " + outputCap));
                textList.add(new TextComponentString("Real EU Output: " + euOut));
            } else {
                textList.add(new TextComponentString("Axle Disconnected!"));
            }
        }
        super.addDisplayText(textList);
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public void joinNet() {
        if (bearingPos != null) {
            BlockPos[] posArr = new BlockPos[]{bearingPos.north(), bearingPos.south(), bearingPos.east(), bearingPos.west()};
            for (BlockPos pos : posArr) {
                if (getWorld().getBlockState(pos).getBlock() instanceof BlockRotationAxle) {
                    axleWhole = ((TileEntityRotationAxle) getWorld().getTileEntity(pos)).getAxleWhole();
                    axleWhole.addConsumer(this);
                }
            }
        }
    }

    @Override
    public void setAxleWhole(@Nullable AxleWhole axle) {
        this.axleWhole = axle;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.HATCH_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityAlternator(metaTileEntityId);
    }

    @Override
    public void consume() {
        torque = axleWhole.pullTorque();
        rps = axleWhole.getRPS();
        euOut = (torque * 64) * ((float) Math.sqrt(rps) + 1);
    }

    @Override
    public void update() {
        if (isStructureFormed()) {
            if (axleWhole == null && getOffsetTimer() % 20 == 0) {
                joinNet();
            } else if (axleWhole != null){
                consume();
                energyOut.addEnergy((long) euOut);
            }
        }
        super.update();
    }
}
