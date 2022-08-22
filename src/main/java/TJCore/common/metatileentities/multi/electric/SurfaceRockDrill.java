package TJCore.common.metatileentities.multi.electric;

import TJCore.common.TJTextures;
import gregicality.multiblocks.GregicalityMultiblocks.*;
import TJCore.common.blocks.DraconicCasings;
import TJCore.common.blocks.TJMetaBlocks;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
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

import static gregtech.api.unification.material.Materials.Titanium;


public class SurfaceRockDrill extends RecipeMapMultiblockController {
    public SurfaceRockDrill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.SURFACE_ROCK_DRILL_RECIPES);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                        "HHHHH",
                        "HGCGH",
                        "HC~CH",
                        "HGCGH",
                        "HHsHH")
                .aisle(
                        "~CPC~",
                        "CGFGC",
                        "PF~FP",
                        "CGFGC",
                        "~CPC~")
                .aisle(
                        "~CPC~",
                        "CGFGC",
                        "PF~FP",
                        "CGFGC",
                        "~CPC~")
                .aisle(
                        "SSSSS",
                        "S~~~S",
                        "S~~~S",
                        "S~~~S",
                        "SSSSS")
                .where('s', selfPredicate())
                .where('~', TraceabilityPredicate.ANY)
                .where('H', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)).or((autoAbilities().setMinGlobalLimited(1,1))).or(abilities(MultiblockAbility.INPUT_ENERGY, MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1,1)))
                .where('S', states(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.STRESS_PROOF_CASING)))
                .where('C', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .where('P', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)))
                .where('G', states(MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.TITANIUM_GEARBOX)))
                .where('F', states(MetaBlocks.FRAMES.get(Titanium).getBlock(Titanium)))
                .build();
    }



    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntityID) {
        return new SurfaceRockDrill(this.metaTileEntityId);
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
