package TJCore.common.metatileentities.multi.steam;

import TJCore.common.TJTextures;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.wood.BlockGregPlanks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.items.IItemHandlerModifiable;


import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Stream;

public class PrimitiveTreeFarmer extends MultiblockControllerBase {

    private IItemHandlerModifiable logOut;
    private IItemHandlerModifiable saplingOut;
    private IItemHandlerModifiable itemIn;

    public PrimitiveTreeFarmer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        logOut = new NotifiableItemStackHandler(1, this, true);
        saplingOut = new NotifiableItemStackHandler(1, this, true);
        itemIn = new NotifiableItemStackHandler(1, this, true);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new PrimitiveTreeFarmer(metaTileEntityId);
    }

    @Override
    public void update() {
        super.update();
        if (!getWorld().isRemote && getOffsetTimer() % 80 == 0 && isStructureFormed() && itemIn.getStackInSlot(0).isItemEqual(new ItemStack(Blocks.SAPLING)) && logOut.getStackInSlot(0).isEmpty()) {
            int saplingsIn = itemIn.getStackInSlot(0).getCount();
            int numSaplingsInOutput = saplingOut.getStackInSlot(0).getCount();
            itemIn.setStackInSlot(0, new ItemStack(Blocks.AIR));
            logOut.setStackInSlot(0, new ItemStack(Blocks.LOG, saplingsIn));
            if (numSaplingsInOutput + saplingsIn <= 64) {
                saplingOut.insertItem(0, new ItemStack(Blocks.SAPLING, saplingsIn), false);
            } else {
                saplingOut.setStackInSlot(0, new ItemStack(Blocks.SAPLING, 64));
            }
        }
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }

    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }

    @Override
    protected void updateFormedValid() {

    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
    }

    private void initializeAbilities() {
        this.logOut = getAbilities(MultiblockAbility.EXPORT_ITEMS).get(0);
        this.saplingOut = getAbilities(MultiblockAbility.EXPORT_ITEMS).get(1);
        this.itemIn = getAbilities(MultiblockAbility.IMPORT_ITEMS).get(0);
    }

    //private void resetTileAbilities() {
    //    this.itemInv = new ItemStackHandler(0);
    //}

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)

                .aisle( "BBBBBBBBBBBB",
                        "BDDDDDDBBWBB",
                        "BDDDDDDBBWBB",
                        "BDDDDDDBBWBB",
                        "BBBBBBBBBSBB")

                .aisle( "            ",
                        "        IFO ",
                        "        I O ",
                        "        IFO ",
                        "            ")

                .aisle( "            ",
                        "        IFO ",
                        "        I O ",
                        "        IFO ",
                        "            ")

                .aisle( "       WWWWW",
                        "       WWWWW",
                        "       WWWWW",
                        "       WWWWW",
                        "       WWWWW")

                .where('S', selfPredicate())
                .where('B', states(Blocks.BRICK_BLOCK.getDefaultState()))
                .where('D', states(Blocks.DIRT.getDefaultState()))
                .where('W', states(MetaBlocks.PLANKS.getState(BlockGregPlanks.BlockType.TREATED_PLANK)))
                .where('F', states(MetaBlocks.FRAMES.get(Materials.TreatedWood).getBlock(Materials.TreatedWood)))
                .where('O', states(Blocks.BRICK_BLOCK.getDefaultState())
                        .or(metaTileEntities(MetaTileEntities.ITEM_EXPORT_BUS[0]).setMaxGlobalLimited(2).setMinGlobalLimited(2)))
                .where('I', states(Blocks.BRICK_BLOCK.getDefaultState())
                        .or(metaTileEntities(MetaTileEntities.ITEM_IMPORT_BUS[0]).setMaxGlobalLimited(1).setMinGlobalLimited(1)))
                .where(' ', any())
                .build();
    }
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return TJTextures.Brick;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.BLOWER_OVERLAY;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), true, true);
    }

    @Override
    public String[] getDescription() {
        return Stream.of(
                new String[]{I18n.format("gregtech.multiblock.primitive_water_pump.description")},
                I18n.format("gregtech.multiblock.primitive_water_pump.extra1").split("/n"),
                I18n.format("gregtech.multiblock.primitive_water_pump.extra2").split("/n")
        ).flatMap(Stream::of).toArray(String[]::new);
    }

}
