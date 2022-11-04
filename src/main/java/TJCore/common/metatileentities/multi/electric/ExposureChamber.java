package TJCore.common.metatileentities.multi.electric;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

import static gregtech.api.unification.material.Materials.*;

public class ExposureChamber extends RecipeMapMultiblockController {
    public ExposureChamber(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.EXPOSURE_CHAMBER_RECIPES);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                        "HHHHH",
                        "HCCCH",
                        "HCCCH",
                        "HCCCH",
                        "HHsHH")
                .aisle(
                        "ACGCA",
                        "C~~~C",
                        "G~F~G",
                        "C~~~C",
                        "ACGCA")
                .aisle(
                        "ACGCA",
                        "C~~~C",
                        "G~~~G",
                        "C~~~C",
                        "ACGCA")
                .aisle(
                        "ACGCA",
                        "C~~~C",
                        "G~F~G",
                        "C~~~C",
                        "ACGCA")
                .aisle(
                        "CCCCC",
                        "CVVVC",
                        "CVTVC",
                        "CVVVC",
                        "CCCCC")
                .where('s', selfPredicate())
                .where('A', TraceabilityPredicate.ANY)
                .where('~',TraceabilityPredicate.AIR)
                .where('C', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING)))
                .where('H', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING))
                        .or(autoAbilities().setMinGlobalLimited(1, 1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY, MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1, 1)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS)))
                .where('F', states(MetaBlocks.FRAMES.get(GCYMMaterials.HSLASteel).getBlock(GCYMMaterials.HSLASteel)))
                .where('V', states(MetaBlocks.MULTIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('T', states(GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT)))
                .build();
    }


    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.ENGRAVER_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntityID) {
        return new ExposureChamber(this.metaTileEntityId);
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
