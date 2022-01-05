package TJCore.common.metatileentities;

import TJCore.TJValues;
import gregtech.api.GTValues;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;

public class TJMetaTileEntities {

    public static final SimpleMachineMetaTileEntity[] MICROWAVE = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static void init() {
        MetaTileEntities.registerSimpleMetaTileEntity(MICROWAVE, -1, "Microwave", RecipeMaps.CENTRIFUGE_RECIPES, Textures.ARC_FURNACE_OVERLAY, false, s -> tjcoreID(s), GTUtility.defaultTankSizeFunction);
    }

    private static ResourceLocation tjcoreID(String name) {
        return new ResourceLocation(TJValues.MODID, name);
    }

}
