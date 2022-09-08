package TJCore.common.metatileentities.multi.electric;

import TJCore.common.TJTextures;
import TJCore.common.blocks.DraconicCasings;
import TJCore.common.blocks.TJMetaBlocks;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
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
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class ArmorInfuser extends RecipeMapMultiblockController {
    
    public ArmorInfuser(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.ARMOR_INFUSER_RECIPES);
    }
    
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                "HHHHH",
                "HCCCH",
                "HCCCH",
                "HCCCH",
                "HHSHH")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "AAAAA",
                        "A~F~A",
                        "AFGFA",
                        "A~F~A",
                        "AAAAA")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "AAAAA",
                        "A~F~A",
                        "AFGFA",
                        "A~F~A",
                        "AAAAA")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "~~~~~",
                        "~~F~~",
                        "~FGF~",
                        "~~F~~",
                        "~~~~~")
                .aisle(
                        "CCCCC",
                        "CCCCC",
                        "CCCCC",
                        "CCCCC",
                        "CCCCC")
                .where('S', selfPredicate())
                .where('~', TraceabilityPredicate.ANY)
                .where('C', states(TJMetaBlocks.DRACONIC_CASING.getState(DraconicCasings.CasingType.DRACONIUM_CASING)).setMinGlobalLimited(5))
                .where('H', states(TJMetaBlocks.DRACONIC_CASING.getState(DraconicCasings.CasingType.DRACONIUM_CASING)).or((autoAbilities().setMinGlobalLimited(1,1))).or(abilities(MultiblockAbility.INPUT_ENERGY, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1,1)))
                .where('F', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_CASING_MK2)))
                .where('G', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL)))
                .where('A', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.DRACONIC_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new ArmorInfuser(metaTileEntityId);
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
