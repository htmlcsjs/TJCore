package tjcore.common.metatileentities.multi.electric;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockGCYSMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;
import tjcore.common.recipes.recipemaps.TJRecipeMaps;

import javax.annotation.Nonnull;

public class Loom extends RecipeMapMultiblockController {
    public Loom(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.LOOM_RECIPES);
    }
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                        "AAAAA",
                        "AsssA",
                        "AsssA",
                        "AsssA",
                        "AAAAA")
                .aisle(
                        "FHHHF",
                        "H   H",
                        "H   H",
                        "H   H",
                        "FHcHF")
                .aisle(
                        "FGGGF",
                        "G   G",
                        "G   G",
                        "G   G",
                        "FGGGF")
                .aisle(
                        "FSSSF",
                        "S F S",
                        "SF FS",
                        "S F S",
                        "FSSSF")
                .aisle(
                        "AAAAA",
                        "AGGGA",
                        "AGGGA",
                        "AGGGA",
                        "AAAAA")

                .where('c', selfPredicate())
                .where(' ',TraceabilityPredicate.AIR)
                .where('S', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING)))
                .where('H', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING))
                        .or(autoAbilities().setMinGlobalLimited(1, 1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY, MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1, 1)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS)))
                .where('A', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ASSEMBLING_CASING)))
                .where('s', states(GCYSMetaBlocks.MULTIBLOCK_CASING.getState(BlockGCYSMultiblockCasing.CasingType.SUBSTRATE)))
                .where('F', states(MetaBlocks.FRAMES.get(Materials.Polytetrafluoroethylene).getBlock(Materials.Polytetrafluoroethylene)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.INERT_PTFE_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntityID) {
        return new Loom(this.metaTileEntityId);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.MULTIBLOCK_WORKABLE_OVERLAY;
    }
}
