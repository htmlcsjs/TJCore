package TJCore.common.metatileentities.multi.electric;

import TJCore.common.TJTextures;
import TJCore.common.blocks.DraconicCasings;
import TJCore.common.blocks.TJMetaBlocks;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.util.ResourceLocation;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
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
                .where('H', states(TJMetaBlocks.DRACONIC_CASING.getState(DraconicCasings.CasingType.DRACONIUM_CASING)).or((autoAbilities()).setMaxGlobalLimited(4)))
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
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new ArmorInfuser(metaTileEntityId);
    }
}
