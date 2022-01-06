package TJCore.common.metatileentities;

import TJCore.TJValues;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;

import java.util.function.Function;

public class TJMetaTileEntities {

    // MACHINE ID 12000-12599

    public static final SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static void init() {
        registerSimpleMetaTileEntity(COMPONENT_ASSEMBLER, 12001, "Component Assembler", TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPES, Textures.ARC_FURNACE_OVERLAY, false);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, s -> tjcoreID(s), tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction);
    }

    private static <T extends MetaTileEntity> T register(int id, T t) {
        GregTechAPI.MTE_REGISTRY.register(id, t.metaTileEntityId, t);

        return t;

    }

    private static ResourceLocation tjcoreID(String name) {
        return new ResourceLocation(TJValues.MODID, name);
    }

}
