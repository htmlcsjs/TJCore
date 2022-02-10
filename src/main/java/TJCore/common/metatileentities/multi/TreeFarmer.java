package TJCore.common.metatileentities.multi;

import TJCore.common.TJTextures;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.metatileentities.electric.MetaTileEntityHull;
import net.minecraft.util.ResourceLocation;

import javax.annotation.*;

public class TreeFarmer extends RecipeMapMultiblockController {

    public TreeFarmer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.TREE_FARMER_RECIPES);

    }

    @Override
    public TraceabilityPredicate autoAbilities() {
        return autoAbilities(true, true, true, true, false, false, true);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle()
                .build();
    }

    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) { return TJTextures.TreeFarmerController; }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new TreeFarmer(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.MULTIBLOCK_WORKABLE_OVERLAY;
    }
}
