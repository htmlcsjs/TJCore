package tjcore.common.metatileentities;

import gregicality.science.client.render.GCYSTextures;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.util.ResourceLocation;
import tjcore.TJValues;
import tjcore.common.TJTextures;
import tjcore.common.metatileentities.axle.MetaTileEntityCreativeRotation;
import tjcore.common.metatileentities.multi.electric.*;
import tjcore.common.metatileentities.multi.electric.generator.MetaTileEntityAlternator;
import tjcore.common.metatileentities.multi.electric.generator.MetaTileEntityModularSteamTurbine;
import tjcore.common.metatileentities.multi.fusion.MegaFusion;
import tjcore.common.metatileentities.multi.pipeline.MetaTileEntityEnergyPipeline;
import tjcore.common.metatileentities.multi.pipeline.MetaTileEntityFluidPipeline;
import tjcore.common.metatileentities.multi.pipeline.MetaTileEntityItemPipeline;
import tjcore.common.metatileentities.multi.steam.PrimitiveRoaster;
import tjcore.common.metatileentities.multi.steam.PrimitiveTreeFarmer;
import tjcore.common.metatileentities.multi.steam.SteamAssembler;
import tjcore.common.metatileentities.axle.MetaTileEntityGearbox;
import tjcore.common.recipes.recipemaps.TJRecipeMaps;

import java.util.function.Function;

import static gregicality.science.api.recipes.GCYSRecipeMaps.DRYER_RECIPES;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class TJMetaTileEntities {

    // MACHINE ID 12000-12599

    public static SimpleMachineMetaTileEntity[] PRINTER = new SimpleMachineMetaTileEntity[6];
    public static SimpleMachineMetaTileEntity[] LAMINATOR = new SimpleMachineMetaTileEntity[GTValues.MAX];
    public static SimpleMachineMetaTileEntity[] SPINNING_MACHINE = new SimpleMachineMetaTileEntity[GTValues.LuV];
    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.LuV];
    public static SteamDryer STEAM_DRYER_BRONZE;
    public static SteamDryer STEAM_DRYER_STEEL;
    public static SteamMixer STEAM_MIXER_BRONZE;
    public static SteamMixer STEAM_MIXER_STEEL;
    public static SteamAssembler STEAM_ASSEMBLER;
    public static ArmorInfuser ARMOR_INFUSER;
    public static TreeFarmer TREE_FARMER;
    public static MegaFusion MEGA_FUSION;
    public static SurfaceRockDrill SURFACE_ROCK_DRILL;
    public static ExposureChamber EXPOSURE_CHAMBER;
    public static MetaTileEntityModularSteamTurbine MODULAR_TURBINE;
    public static PrimitiveTreeFarmer PRIMITIVE_TREE_FARMER;
    public static LargeAlloySmelter LARGE_ALLOY_SMELTER;

    public static MetaTileEntityCreativeRotation CREATIVE_ROTATION;
    public static MetaTileEntityGearbox GEARBOX;
    public static MetaTileEntityAlternator ALTERNATOR;
    public static Roaster ROASTER;
    public static PrimitiveRoaster PRIMITIVE_ROASTER;
    public static MetaTileEntityFluidPipeline FLUID_PIPELINE;
    public static MetaTileEntityItemPipeline ITEM_PIPELINE;
    public static MetaTileEntityEnergyPipeline ENERGY_PIPELINE;

    public static Loom LOOM;

    public static void init() {
        STEAM_ASSEMBLER = registerMetaTileEntity(12030, new SteamAssembler(tjcoreID("steam_assembler")));
        ARMOR_INFUSER = registerMetaTileEntity(12033, new ArmorInfuser(tjcoreID("armor_infuser")));
        TREE_FARMER = registerMetaTileEntity(12034, new TreeFarmer(tjcoreID("tree_farmer")));
        MEGA_FUSION = registerMetaTileEntity(12035, new MegaFusion(tjcoreID("mega_fusion")));
        SURFACE_ROCK_DRILL = registerMetaTileEntity(12036, new SurfaceRockDrill(tjcoreID("surface_rock_drill")));
        EXPOSURE_CHAMBER = registerMetaTileEntity(12037, new ExposureChamber(tjcoreID("exposure_chamber")));
        LOOM = registerMetaTileEntity(12038, new Loom(tjcoreID("loom")));
        STEAM_MIXER_BRONZE = registerMetaTileEntity(12039, new SteamMixer(tjcoreID("steam_mixer_bronze"), false));
        STEAM_MIXER_STEEL = registerMetaTileEntity(12040, new SteamMixer(tjcoreID("steam_mixer_steel"), true));
        STEAM_DRYER_BRONZE = registerMetaTileEntity(12041, new SteamDryer(tjcoreID("steam_dryer_bronze"), false));
        STEAM_DRYER_STEEL = registerMetaTileEntity(12042, new SteamDryer(tjcoreID("steam_dryer_steel"), true));
        MODULAR_TURBINE = registerMetaTileEntity(12043, new MetaTileEntityModularSteamTurbine(tjcoreID("modular_steam_turbine")));
        PRIMITIVE_TREE_FARMER = registerMetaTileEntity(12044, new PrimitiveTreeFarmer(tjcoreID("primitive_tree_farmer")));
        LARGE_ALLOY_SMELTER = registerMetaTileEntity(12050, new LargeAlloySmelter(tjcoreID("large_alloy_smelter")));
        ALTERNATOR = registerMetaTileEntity(12051, new MetaTileEntityAlternator(tjcoreID("alternator")));
        CREATIVE_ROTATION = registerMetaTileEntity(12052, new MetaTileEntityCreativeRotation());
        GEARBOX = registerMetaTileEntity(12053, new MetaTileEntityGearbox(tjcoreID("gearbox")));
        ROASTER = registerMetaTileEntity(12054, new Roaster(tjcoreID("roaster")));
        PRIMITIVE_ROASTER = registerMetaTileEntity(12055, new PrimitiveRoaster(tjcoreID("primitive_roaster")));
        FLUID_PIPELINE = registerMetaTileEntity(12056, new MetaTileEntityFluidPipeline(tjcoreID("fluid_pipeline")));
        ITEM_PIPELINE = registerMetaTileEntity(12057, new MetaTileEntityItemPipeline(tjcoreID("item_pipeline")));
        ENERGY_PIPELINE = registerMetaTileEntity(12058, new MetaTileEntityEnergyPipeline(tjcoreID("energy_pipeline")));
        registerSimpleMetaTileEntity(LAMINATOR, 12070, "laminator", TJRecipeMaps.LAMINATOR_RECIPES, Textures.BENDER_OVERLAY, true);
        registerSimpleMetaTileEntity(PRINTER, 12090, "printer", TJRecipeMaps.PRINTER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, true);
        registerSimpleMetaTileEntity(SPINNING_MACHINE, 12100, "spinning_machine", TJRecipeMaps.SPINNING_RECIPES, Textures.CENTRIFUGE_OVERLAY, true, GTUtility.hvCappedTankSizeFunction);
        registerSimpleMetaTileEntity(DRYER, 12110, "dryer", DRYER_RECIPES, TJTextures.ROASTER_OVERLAY, true);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, TJMetaTileEntities::tjcoreID, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction);
    }

    private static ResourceLocation tjcoreID(String name) {
        return new ResourceLocation(TJValues.MODID, name);
    }
}
