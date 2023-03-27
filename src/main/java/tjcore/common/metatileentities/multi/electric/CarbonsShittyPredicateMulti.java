package tjcore.common.metatileentities.multi.electric;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.BlockInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class CarbonsShittyPredicateMulti extends RecipeMapMultiblockController {

    private int tier = 0;

    private int CoilTier = 0;
    private int PipeTier = 0;
    private int GlassTier = 0;

    public CarbonsShittyPredicateMulti(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);

        Object type = context.get("PipeType");
        if(type instanceof BlockBoilerCasing.BoilerCasingType) {
            this.PipeTier = ((BlockBoilerCasing.BoilerCasingType)type).ordinal();
        }
        else {
            this.PipeTier = 0;
        }

        type = context.get("GlassType");
        if(type instanceof BlockGlassCasing.CasingType) {
            this.GlassTier = ((BlockGlassCasing.CasingType)type).ordinal();
        }
        else
            this.GlassTier = 0;

        type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.CoilTier = ((IHeatingCoilBlockStats) type).getTier();
        } else {
            this.CoilTier = BlockWireCoil.CoilType.CUPRONICKEL.getTier();
        }
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return true;
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CAA", "AHM", "KPG")
                .where('C', selfPredicate())
                .where('A', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN)))
                .where('H', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('K', TraceabilityPredicate.HEATING_COILS.get())
                .where('P', pipez())
                .where('G', glazz())
                .build();
    }

    public TraceabilityPredicate pipez() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockBoilerCasing) {
                BlockBoilerCasing.BoilerCasingType pipeType = ((BlockBoilerCasing) blockState.getBlock()).getState(blockState);
                if (pipeType.equals(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE)) return false;

                Object currentPipe = blockWorldState.getMatchContext().getOrPut("PipeType", pipeType);
                return true;
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockBoilerCasing.BoilerCasingType.values())
                        .filter(type -> !type.equals(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE))
                        .map(type -> new BlockInfo(MetaBlocks.BOILER_CASING.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

    public TraceabilityPredicate glazz() {
        return new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockGlassCasing) {
                BlockGlassCasing.CasingType glassType = ((BlockGlassCasing) blockState.getBlock()).getState(blockState);


                Object currentGlass = blockWorldState.getMatchContext().getOrPut("GlassType", glassType);
                return true;
            }
            return false;
        }, () -> ArrayUtils.addAll(
                Arrays.stream(BlockGlassCasing.CasingType.values())
                        .filter(type -> !type.equals(BlockGlassCasing.CasingType.TEMPERED_GLASS))
                        .map(type -> new BlockInfo(MetaBlocks.TRANSPARENT_CASING.getState(type), null))
                        .toArray(BlockInfo[]::new)));
    }

        //return states(new IBlockState[]{
        //        MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE),
//                MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE),
//                MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE),
//                MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE)
//        });
    //}

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.BRONZE_PLATED_BRICKS;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return null;
    }
}
