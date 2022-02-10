package TJCore.common.metatileentities.multi;

import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.metatileentities.electric.MetaTileEntityHull;

public class TreeFarmer extends RecipeMapMultiblockController {

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle()
                .build();
    }

    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) { return ; }
}
