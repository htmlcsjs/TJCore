package TJCore.common.metatileentities.multi.electric.generator;

import TJCore.api.block.ITurbineBladeStats;
import gregtech.api.GTValues;
import TJCore.common.blocks.BlockBearing;
import TJCore.common.blocks.BlockTurbineBlades;
import TJCore.common.blocks.TJMetaBlocks;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.GTValues;
import gregtech.api.capability.impl.MultiblockFuelRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.BlockInfo;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import org.apache.commons.lang3.ArrayUtils;
import scala.Int;

import java.util.Arrays;
import java.util.List;

public class MetaTileEntityModularSteamTurbine extends FuelMultiblockController {

    private int turbineTier;
    private int bearingTier;

    public MetaTileEntityModularSteamTurbine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.STEAM_TURBINE_FUELS, 6);
        this.recipeMapWorkable = new ModularTurbineWorkableHandler(this, turbineTier, bearingTier);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {
            //textList.add(new TextComponentString("Blade Type: "));
            textList.add(new TextComponentString("Base Turbine Generation: " + GTValues.V[turbineTier + 2]));
            textList.add(new TextComponentString("Bearing Multiplier: " + (bearingTier + 1) * 0.5));
        }
        super.addDisplayText(textList);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type1 = context.get("BladesType");
        if (type1 instanceof ITurbineBladeStats) {
            this.turbineTier = ((ITurbineBladeStats) type1).getTier();
        } else {
            this.turbineTier = 0;
        }
        Object type2 = context.get("BearingType");
        if (type2 instanceof BlockBearing.BearingType) {
            this.bearingTier = ((BlockBearing.BearingType) type2).getTier();
        } else {
            this.bearingTier = 0;
        }
    }

    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.DOWN)
                .aisle(
                        "  EEE   ",
                        " CCCCC  ",
                        "  CCC   ")
                .aisle(
                        " EE EE  ",
                        "OPBBBC  ",
                        " CC CC  ")
                .aisle(
                        " E   E S",
                        " CBRBC S",
                        " C   C S")
                .aisle(
                        " EE EE S",
                        " CBBBPPP",
                        " CC CC T")
                .aisle(
                        "  EEE  S",
                        " CCCCC P",
                        "  CCC  S")
                .where(' ', TraceabilityPredicate.ANY)
                .where('~', TraceabilityPredicate.AIR)
                .where('E', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.STEAM_CASING))
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setMaxGlobalLimited(4).setMinGlobalLimited(1)))
                .where('O', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1)))
                .where('T', selfPredicate())
                .where('C', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.STEAM_CASING)))
                .where('S', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setMinGlobalLimited(1).setMaxGlobalLimited(1)))
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)))
                .where('R', bearings())
                .where('B', blades())
                .build();
    }

    public TraceabilityPredicate blades() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockTurbineBlades) {
                BlockTurbineBlades.TurbineBladesType bladesType = ((BlockTurbineBlades) block).getState(blockState);
                    Object currentBlades = blockWorldState.getMatchContext().getOrPut("BladesType", bladesType);
                return currentBlades.equals(bladesType);
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockTurbineBlades.TurbineBladesType.values())
                        .map(type -> new BlockInfo(TJMetaBlocks.TURBINE_BLADES.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

    public TraceabilityPredicate bearings() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockBearing) {
                BlockBearing.BearingType bearingType = ((BlockBearing) block).getState(blockState);
                Object currentBearing = blockWorldState.getMatchContext().getOrPut("BearingType", bearingType);
                return true;
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockBearing.BearingType.values())
                        .map(type -> new BlockInfo(TJMetaBlocks.BLOCK_BEARING.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityModularSteamTurbine(metaTileEntityId);
    }

    static class ModularTurbineWorkableHandler extends MultiblockFuelRecipeLogic {
        private final int tierBlade;
        private final int tierBearing;
        public ModularTurbineWorkableHandler(RecipeMapMultiblockController metaTileEntity, int tierBlade, int tierBearing) {
            super(metaTileEntity);
            this.tierBlade = tierBlade;
            this.tierBearing = tierBearing;
        }

        @Override
        public long getMaximumOverclockVoltage() {
            return GTValues.V[tierBlade + 2];
        }

        @Override
        protected long boostProduction(long production) {
            //this multiplies production without increasing consumption
           return (long) (production * (tierBearing + 1) * 0.5);
        }
    }
}
