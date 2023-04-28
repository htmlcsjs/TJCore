package tjcore.common.metatileentities.multi.electric;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.Predicates;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;
import tjcore.common.TJTextures;
import tjcore.common.recipes.recipemaps.TJRecipeMaps;

import javax.annotation.Nonnull;

import static gregtech.api.pattern.TraceabilityPredicate.HEATING_COILS;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.ROASTING_RECIPES;

public class Roaster extends RecipeMapMultiblockController {
    public Roaster(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, ROASTING_RECIPES);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                        "F#F",
                        "#C#",
                        "F#F")
                .aisle(
                        "FCF",
                        "COC",
                        "FSF")
                .aisle(
                        "HHH",
                        "H H",
                        "HHH")
                .aisle(
                        "#C#",
                        "C C",
                        "#C#")
                .aisle(
                        "#C#",
                        "CMC",
                        "#C#")
                .where('S', selfPredicate())
                .where('#', TraceabilityPredicate.ANY)
                .where(' ',TraceabilityPredicate.AIR)
                .where('O', HEATING_COILS.get())
                .where('C', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF)))
                .where('H', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF))
                        .or(autoAbilities()))
                .where('F', states(MetaBlocks.FRAMES.get(Materials.Invar).getBlock(Materials.Invar)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .build();
    }


    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.HEAT_PROOF_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntityID) {
        return new Roaster(this.metaTileEntityId);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return TJTextures.ROASTER_OVERLAY;
    }
}
