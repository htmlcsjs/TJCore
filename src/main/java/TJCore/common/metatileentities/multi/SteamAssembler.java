package TJCore.common.metatileentities.multi;

import TJCore.TJSounds;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.metatileentity.sound.ISoundCreator;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;

public class SteamAssembler extends RecipeMapMultiblockController implements ISoundCreator {



    public SteamAssembler(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPES);
    }

    @Override
    protected void updateFormedValid() {

    }

    @Override
    public TraceabilityPredicate autoAbilities() {
        return super.autoAbilities();
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
                .where('B', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS)).or(abilities(MultiblockAbility.INPUT_ENERGY))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)))

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
        return TJCore.common.Textures.STEAM_ASSEMBLER_OVERLAY;
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (!playerIn.isSneaking() && playerIn.getHeldItem(hand).isEmpty()){
            GTLog.logger.printf(Level.INFO, "SUS MODE ACTIVATED");
            getWorld().playSound(playerIn, getPos(), TJSounds.AMONG_US, SoundCategory.BLOCKS, 0.5F, 1.0F);
        }

        return super.onRightClick(playerIn, hand, facing, hitResult);
    }

}
