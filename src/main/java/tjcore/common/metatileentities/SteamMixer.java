//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tjcore.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.NotifiableItemStackHandler;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ProgressWidget.MoveType;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.texture.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandlerModifiable;

import static gregtech.api.recipes.ModHandler.getSteam;

public class SteamMixer extends SteamMetaTileEntity {

    protected FluidTankList fluidTanks;

    public SteamMixer(ResourceLocation metaTileEntityId, boolean isHighPressure) {
        super(metaTileEntityId, RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, isHighPressure);
    }

    @Override
    protected void initializeInventory() {

        FluidTank[] fluidsHandlers = new FluidTank[2];

        fluidsHandlers[0] = new FilteredFluidHandler(32000).setFillPredicate(this::isNotSteam);
        fluidsHandlers[1] = new FilteredFluidHandler(32000).setFillPredicate(this::isNotSteam);
        this.fluidTanks = new FluidTankList(false, fluidsHandlers);
        super.initializeInventory();
    }

    public boolean isNotSteam(FluidStack fluid) {
        return !getSteam(1).isFluidEqual(fluid);
    }

    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new SteamMixer(this.metaTileEntityId, this.isHighPressure);
    }

    protected IItemHandlerModifiable createImportItemHandler() {
        return new NotifiableItemStackHandler(4, this, false);
    }

    @Override
    public FluidTankList createImportFluidHandler() {
        this.steamFluidTank = (new FilteredFluidHandler(32000)).setFillPredicate(ModHandler::isSteam);
        return new FluidTankList(false, this.steamFluidTank, fluidTanks.getTankAt(0), fluidTanks.getTankAt(1));
    }

    protected IItemHandlerModifiable createExportItemHandler() {
        return new NotifiableItemStackHandler(1, this, true);
    }

    public ModularUI createUI(EntityPlayer player) {

        return this.createUITemplate(player)
                .slot(this.importItems, 0, 50+19, 25, GuiTextures.SLOT_STEAM.get(this.isHighPressure), GuiTextures.DUST_OVERLAY_STEAM.get(this.isHighPressure))
        .slot(this.importItems, 1, 32+19, 25, GuiTextures.SLOT_STEAM.get(this.isHighPressure), GuiTextures.DUST_OVERLAY_STEAM.get(this.isHighPressure))
        .slot(this.importItems, 2, 50+19, 43, GuiTextures.SLOT_STEAM.get(this.isHighPressure), GuiTextures.DUST_OVERLAY_STEAM.get(this.isHighPressure))
        .slot(this.importItems, 3, 32+19, 43, GuiTextures.SLOT_STEAM.get(this.isHighPressure), GuiTextures.DUST_OVERLAY_STEAM.get(this.isHighPressure))
        .widget((new TankWidget(this.fluidTanks.getTankAt(0), 14+19, 25, 18,18)).setBackgroundTexture(GuiTextures.FLUID_SLOT).setContainerClicking(true, true).setAlwaysShowFull(true))
        .widget((new TankWidget(this.fluidTanks.getTankAt(1), 14+19, 43, 18,18)).setBackgroundTexture(GuiTextures.FLUID_SLOT).setContainerClicking(true, true).setAlwaysShowFull(true))
        .progressBar(this.workableHandler::getProgressPercent, 79+16, 35, 20, 20, GuiTextures.PROGRESS_BAR_MIXER, MoveType.CIRCULAR, this.workableHandler.getRecipeMap())
        .slot(this.exportItems, 0, 110+13, 35, true, false, GuiTextures.SLOT_STEAM.get(this.isHighPressure))
        .build(this.getHolder(), player);
    }

    public int getItemOutputLimit() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick() {
        if (this.isActive()) {
            BlockPos pos = this.getPos();
            float horizontalOffset = GTValues.RNG.nextFloat() * 0.6F - 0.3F;
            this.getWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)((float)pos.getX() + horizontalOffset), (double)((float)pos.getY() + 0.52F), (double)((float)pos.getZ() + horizontalOffset), (double)(GTValues.RNG.nextFloat() * 0.125F), (double)(GTValues.RNG.nextFloat() * 0.375F), (double)(GTValues.RNG.nextFloat() * 0.125F));
        }
    }
}
