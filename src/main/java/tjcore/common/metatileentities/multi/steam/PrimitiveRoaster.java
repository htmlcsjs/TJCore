package tjcore.common.metatileentities.multi.steam;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.IGuiTexture;
import gregtech.api.gui.widgets.*;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapPrimitiveMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.api.util.RelativeDirection;
import gregtech.client.renderer.CubeRendererState;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.cclop.ColourOperation;
import gregtech.client.renderer.cclop.LightMapOperation;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.BloomEffectUtil;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import tjcore.common.TJTextures;
import tjcore.common.recipes.recipemaps.TJRecipeMaps;

import javax.annotation.Nonnull;

public class PrimitiveRoaster extends RecipeMapPrimitiveMultiblockController {

    public PrimitiveRoaster(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, TJRecipeMaps.PRIMITIVE_ROASTING_RECIPES);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                .aisle(
                        "F#F",
                        "#C#",
                        "F#F")
                .aisle(
                        "FCF",
                        "C C",
                        "FSF")
                .aisle(
                        "HHH",
                        "H H",
                        "HHH")
                .aisle(
                        "#C#",
                        "C C",
                        "#C#")
                .aisle(
                        "#C#",
                        "C C",
                        "#C#")
                .where('S', selfPredicate())
                .where('#', TraceabilityPredicate.ANY)
                .where(' ',TraceabilityPredicate.AIR)
                .where('C', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS)))
                .where('H', states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS))
                        .or(autoAbilities()))
                .where('F', states(MetaBlocks.FRAMES.get(Materials.Invar).getBlock(Materials.Invar)))
                .build();
    }

    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.PRIMITIVE_BRICKS;
    }

    protected ModularUI.Builder createUITemplate(EntityPlayer entityPlayer) {
        return ModularUI.builder(GuiTextures.PRIMITIVE_BACKGROUND, 176, 204).shouldColor(false)
                .widget(new TankWidget(this.importFluids.getTankAt(0), 22, 25, 20, 58)
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_LARGE_FLUID_TANK)
                        .setOverlayTexture(GuiTextures.PRIMITIVE_LARGE_FLUID_TANK_OVERLAY)
                        .setContainerClicking(true, true))
                .widget(new LabelWidget(5, 5, this.getMetaFullName(), new Object[0]))
                .widget((new SlotWidget(this.importItems, 0, 52, 25, true, true))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget((new SlotWidget(this.importItems, 1, 52, 45, true, true))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget((new SlotWidget(this.importItems, 2, 52, 65, true, true))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget(new RecipeProgressWidget(this.recipeMapWorkable::getProgressPercent, 76, 46, 20, 15, GuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR, ProgressWidget.MoveType.HORIZONTAL, TJRecipeMaps.PRIMITIVE_ROASTING_RECIPES))
                .widget((new SlotWidget(this.exportItems, 0, 103, 25, true, false))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget((new SlotWidget(this.exportItems, 1, 103, 45, true, false))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget((new SlotWidget(this.exportItems, 2, 103, 65, true, false))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT, GuiTextures.PRIMITIVE_FURNACE_OVERLAY))
                .widget((new TankWidget(this.exportFluids.getTankAt(0), 134, 25, 20, 58))
                        .setBackgroundTexture(GuiTextures.PRIMITIVE_LARGE_FLUID_TANK)
                        .setOverlayTexture(GuiTextures.PRIMITIVE_LARGE_FLUID_TANK_OVERLAY)
                        .setContainerClicking(true, false))
                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.PRIMITIVE_SLOT, 37);
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
        if (this.recipeMapWorkable.isActive() && this.isStructureFormed()) {
            EnumFacing back = this.getFrontFacing().getOpposite();
            Matrix4 offset = translation.copy().translate((double)back.getXOffset(), -0.3, (double)back.getZOffset());
            CubeRendererState op = (CubeRendererState)Textures.RENDER_STATE.get();
            Textures.RENDER_STATE.set(new CubeRendererState(op.layer, CubeRendererState.PASS_MASK, op.world));
            Textures.renderFace(renderState, offset, (IVertexOperation[]) ArrayUtils.addAll(pipeline, new IVertexOperation[]{new LightMapOperation(240, 240), new ColourOperation(-1)}), EnumFacing.UP, Cuboid6.full, TextureUtils.getBlockTexture("lava_still"), BloomEffectUtil.getRealBloomLayer());
            Textures.RENDER_STATE.set(op);
        }

    }

    @Nonnull
    protected ICubeRenderer getFrontOverlay() {
        return TJTextures.ROASTER_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new PrimitiveRoaster(this.metaTileEntityId);
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    public void update() {
        super.update();
        if (isActive()) {
            if (getWorld().isRemote) {
                pollutionParticles();
            } else {
                damageEntitiesAndBreakSnow();
            }
        }

    }

    private void damageEntitiesAndBreakSnow() {
        BlockPos middlePos = this.getPos();
        middlePos = middlePos.offset(this.getFrontFacing().getOpposite());
        this.getWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(middlePos)).forEach((entity) -> {
            entity.attackEntityFrom(DamageSource.LAVA, 3.0F);
        });
        if (this.getOffsetTimer() % 10L == 0L) {
            IBlockState state = this.getWorld().getBlockState(middlePos);
            GTUtility.tryBreakSnowLayer(this.getWorld(), middlePos, state, true);
        }

    }

    private void pollutionParticles() {
        BlockPos pos = this.getPos();
        EnumFacing facing = this.getFrontFacing().getOpposite();
        float xPos = (float)facing.getXOffset() * 0.76F + (float)pos.getX() + 0.5F;
        float yPos = (float)facing.getYOffset() * 0.76F + (float)pos.getY() + 0.25F;
        float zPos = (float)facing.getZOffset() * 0.76F + (float)pos.getZ() + 0.5F;
        float ySpd = (float)facing.getYOffset() * 0.1F + 0.2F + 0.1F * GTValues.RNG.nextFloat();
        this.runMufflerEffect(xPos, yPos, zPos, 0.0F, ySpd, 0.0F);
    }

    public void randomDisplayTick() {
        if (this.isActive()) {
            BlockPos pos = this.getPos();
            float x = (float)pos.getX() + 0.5F;
            float z = (float)pos.getZ() + 0.5F;
            EnumFacing facing = this.getFrontFacing();
            float horizontalOffset = GTValues.RNG.nextFloat() * 0.6F - 0.3F;
            float y = (float)pos.getY() + GTValues.RNG.nextFloat() * 0.375F + 0.3F;
            if (facing.getAxis() == EnumFacing.Axis.X) {
                if (facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                    x += 0.52F;
                } else {
                    x -= 0.52F;
                }

                z += horizontalOffset;
            } else if (facing.getAxis() == EnumFacing.Axis.Z) {
                if (facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                    z += 0.52F;
                } else {
                    z -= 0.52F;
                }

                x += horizontalOffset;
            }

            if (ConfigHolder.machines.machineSounds && GTValues.RNG.nextDouble() < 0.1) {
                this.getWorld().playSound((double)x, (double)y, (double)z, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            this.getWorld().spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)x, (double)y, (double)z, 0.0, 0.0, 0.0, new int[0]);
            this.getWorld().spawnParticle(EnumParticleTypes.FLAME, (double)x, (double)y, (double)z, 0.0, 0.0, 0.0, new int[0]);
        }

    }
}
