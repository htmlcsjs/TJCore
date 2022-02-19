package TJCore.common.metatileentities.multi.electric;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;

public class CubicPrinter extends RecipeMapMultiblockController {


    public CubicPrinter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.PRINTER_RECIPES);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return null;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return null;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new CubicPrinter(metaTileEntityId);
    }
}
