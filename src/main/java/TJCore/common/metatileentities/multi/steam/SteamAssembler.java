package TJCore.common.metatileentities.multi.steam;


import TJCore.common.TJTextures;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;

import gregtech.api.capability.impl.SteamMultiWorkable;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.util.*;

import javax.annotation.Nonnull;

public class SteamAssembler extends RecipeMapSteamMultiblockController {

    public SteamAssembler(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.STEAM_COMPONENT_ASSEMBLER_RECIPES,CONVERSION_RATE);
        this.recipeMapWorkable = new SteamMultiWorkable(this, CONVERSION_RATE);
    }

    @Override
    public TraceabilityPredicate autoAbilities() {
        return autoAbilities(true,false,true,true,false);
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("BBB", "BBB", "EEE", "ADA") // used to have controller here (pointed towards 'A' in aisle below it)
                .aisle("BBB", "BAB", "EEE", "DDD") // further away from the controller
                .aisle("BBB", "BCB", "EEE", "ADA") // now controller is here (pointed towards nothing in aisle below it)
                .where('A', any())
                .where('B', states(Blocks.BRICK_BLOCK.getDefaultState()).or((autoAbilities()).setMaxGlobalLimited(4)))
                .where('C', selfPredicate())
                .where('D', states(MetaBlocks.STEAM_CASING.getState(BlockSteamCasing.SteamCasingType.BRONZE_HULL)))
                .where('E', states(MetaBlocks.STEAM_CASING.getState(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL)))
                .build();
    }



    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return TJTextures.Brick;
    }


    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new SteamAssembler(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.MULTIBLOCK_WORKABLE_OVERLAY;
    }

}
