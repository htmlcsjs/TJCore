package TJCore.common.metatileentities.multi;

import TJCore.TJSounds;
import TJCore.TJValues;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import gregtech.api.capability.impl.SteamMultiWorkable;
import gregtech.api.capability.impl.SteamMultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.metatileentity.multiblock.RecipeMapSteamMultiblockController;
import gregtech.api.metatileentity.sound.ISoundCreator;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.sound.GTSounds;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;

public class SteamAssembler extends RecipeMapSteamMultiblockController implements ISoundCreator {

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
                .aisle("BBB", "BBB", "BBB") // used to have controller here (pointed towards 'A' in aisle below it)
                .aisle("BBB", "BAB", "BBB") // further away from the controller
                .aisle("BBB", "BAB", "BBB") // center slice of structure
                .aisle("BBB", "BAB", "BBB") // closer to the controller
                .aisle("BBB", "BCB", "BBB") // now controller is here (pointed towards nothing in aisle below it)
                .where('C', selfPredicate())
                .where('B', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS)).or((autoAbilities()).setMaxGlobalLimited(4)))
                .where('A', any())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.FROST_PROOF_CASING;
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

    @Override
    public void onAttached(Object... data) {
        super.onAttached(data);
        if (getWorld() != null && getWorld().isRemote) {
            this.setupSound(this.recipeMap.getSound(), this.getPos());
        }
    }

}
