package tjcore.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;
import tjcore.common.recipes.recipemaps.TJRecipeMaps;

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
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntityID) {
        return new CubicPrinter(this.metaTileEntityId);
    }
}
