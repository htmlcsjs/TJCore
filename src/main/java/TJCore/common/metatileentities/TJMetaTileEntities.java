package TJCore.common.metatileentities;

import TJCore.TJValues;
import TJCore.common.metatileentities.multi.electric.ArmorInfuser;
import TJCore.common.metatileentities.multi.steam.SteamAssembler;
import TJCore.common.metatileentities.multi.electric.TreeFarmer;
import TJCore.common.metatileentities.multi.fusion.MegaFusion;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import static gregtech.common.metatileentities.MetaTileEntities.*;

import java.util.function.Function;

public class TJMetaTileEntities {

    // MACHINE ID 12000-12599

    public static  SimpleMachineMetaTileEntity[] COMPONENT_ASSEMBLER = new SimpleMachineMetaTileEntity[GTValues.LuV];
    public static  SimpleMachineMetaTileEntity[] PRINTER = new SimpleMachineMetaTileEntity[3];
    public static  SteamAssembler STEAM_ASSEMBLER = new SteamAssembler(tjcoreID("steam_assembler"));

    public static TreeFarmer TREE_FARMER = new TreeFarmer(tjcoreID("tree_farmer"));
    public static MegaFusion MEGA_FUSION = new MegaFusion(tjcoreID("mega_fusion"));
    public static ArmorInfuser ARMOR_INFUSER = new ArmorInfuser(tjcoreID("armor_infuser"));

    public static void init() {
        registerSimpleMetaTileEntity(COMPONENT_ASSEMBLER, 12001, "component_assembler", TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, true);
        registerSimpleMetaTileEntity(PRINTER, 12008, "printer", TJRecipeMaps.PRINTER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, true);
        registerMetaTileEntity(12010, STEAM_ASSEMBLER);
        registerMetaTileEntity(12030, ARMOR_INFUSER);
       registerMetaTileEntity(12020, TREE_FARMER);
       registerMetaTileEntity(12050, MEGA_FUSION);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, s -> tjcoreID(s), tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction);
    }

    private static ResourceLocation tjcoreID(String name) {
        return new ResourceLocation(TJValues.MODID, name);

    }

}
