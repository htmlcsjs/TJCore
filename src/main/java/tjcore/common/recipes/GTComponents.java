package tjcore.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraft.item.ItemStack;
import scala.tools.nsc.transform.patmat.Logic;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.ModHandler.removeRecipeByName;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static tjcore.api.TJOreDictionaryLoader.nanofoil;
import static tjcore.api.TJOreDictionaryLoader.nanowire;
import static tjcore.api.material.TJMaterials.*;
import static tjcore.common.metaitem.TJMetaItems.*;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPES;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.STEAM_COMPONENT_ASSEMBLER_RECIPES;

//import static gregtech.loaders.recipe.CraftingComponent.*;


public class GTComponents {

    // Static Array Area :desolate:
    public static Material[] tierCircuitNames = new Material[]{MarkerMaterials.Tier.ULV, MarkerMaterials.Tier.LV, MarkerMaterials.Tier.MV, MarkerMaterials.Tier.HV, MarkerMaterials.Tier.EV, MarkerMaterials.Tier.IV, MarkerMaterials.Tier.LuV, MarkerMaterials.Tier.ZPM, MarkerMaterials.Tier.UV, MarkerMaterials.Tier.UHV, MarkerMaterials.Tier.UEV, MarkerMaterials.Tier.UIV, MarkerMaterials.Tier.UXV, MarkerMaterials.Tier.OpV, MarkerMaterials.Tier.MAX};
    public static MetaItem<?>.MetaValueItem[] motors = new MetaItem<?>.MetaValueItem[]{ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV, ELECTRIC_MOTOR_LuV, ELECTRIC_MOTOR_ZPM, ELECTRIC_MOTOR_UV, ELECTRIC_MOTOR_UHV, ELECTRIC_MOTOR_UEV, ELECTRIC_MOTOR_UIV, ELECTRIC_MOTOR_UXV, ELECTRIC_MOTOR_OpV};
    public static MetaItem<?>.MetaValueItem[] pistons = new MetaItem<?>.MetaValueItem[]{ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV, ELECTRIC_PISTON_LUV, ELECTRIC_PISTON_ZPM, ELECTRIC_PISTON_UV, ELECTRIC_PISTON_UHV, ELECTRIC_PISTON_UEV, ELECTRIC_PISTON_UIV, ELECTRIC_PISTON_UXV, ELECTRIC_PISTON_OpV};
    public static MetaItem<?>.MetaValueItem[] pump = new MetaItem<?>.MetaValueItem[]{ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV, ELECTRIC_PUMP_LuV, ELECTRIC_PUMP_ZPM, ELECTRIC_PUMP_UV, ELECTRIC_PUMP_UHV, ELECTRIC_PUMP_UEV, ELECTRIC_PUMP_UIV,ELECTRIC_PUMP_UXV, ELECTRIC_PUMP_OpV};
    public static MetaItem<?>.MetaValueItem[] conveyor = new MetaItem<?>.MetaValueItem[]{CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV, CONVEYOR_MODULE_LuV, CONVEYOR_MODULE_ZPM, CONVEYOR_MODULE_UV, CONVEYOR_MODULE_UHV, CONVEYOR_MODULE_UEV, CONVEYOR_MODULE_UIV, CONVEYOR_MODULE_UXV, CONVEYOR_MODULE_OpV};
    public static MetaItem<?>.MetaValueItem[] roboArm = new MetaItem<?>.MetaValueItem[]{ROBOT_ARM_LV, ROBOT_ARM_MV, ROBOT_ARM_HV, ROBOT_ARM_EV, ROBOT_ARM_IV, ROBOT_ARM_LuV, ROBOT_ARM_ZPM, ROBOT_ARM_UV, ROBOT_ARM_UHV, ROBOT_ARM_UEV, ROBOT_ARM_UIV, ROBOT_ARM_UXV, ROBOT_ARM_OpV};
    public static MetaItem<?>.MetaValueItem[] feildGen = new MetaItem<?>.MetaValueItem[]{FIELD_GENERATOR_LV, FIELD_GENERATOR_MV, FIELD_GENERATOR_HV, FIELD_GENERATOR_EV, FIELD_GENERATOR_IV, FIELD_GENERATOR_LuV, FIELD_GENERATOR_ZPM, FIELD_GENERATOR_UV, FIELD_GENERATOR_UHV, FIELD_GENERATOR_UEV, FIELD_GENERATOR_UIV, FIELD_GENERATOR_UXV, FIELD_GENERATOR_OpV};
    public static MetaItem<?>.MetaValueItem[] emitter = new MetaItem<?>.MetaValueItem[]{EMITTER_LV, EMITTER_MV, EMITTER_HV, EMITTER_EV, EMITTER_IV, EMITTER_LuV, EMITTER_ZPM, EMITTER_UV, EMITTER_UHV, EMITTER_UEV, EMITTER_UIV, EMITTER_UXV, EMITTER_OpV};
    public static MetaItem<?>.MetaValueItem[] sensor = new MetaItem<?>.MetaValueItem[]{SENSOR_LV, SENSOR_MV, SENSOR_HV, SENSOR_EV, SENSOR_IV, SENSOR_LuV, SENSOR_ZPM, SENSOR_UV, SENSOR_UHV, SENSOR_UEV, SENSOR_UIV, SENSOR_UXV, SENSOR_OpV};
    private static final Material[] hullPlate = new Material[]{GalvanizedSteel, Aluminium, StainlessSteel, Titanium, TungstenSteel, LutetiumTantalate, Iridrhodruthenium, Tritanium, Bohrium, Adamantium, Vibranium, ProgrammableMatter, HeavyQuarkDegenerate};
    private static final Material[] motorWires = new Material[]{Copper, AnnealedCopper, Electrum, Nichrome, Tungsten, AnnealedCopper, Platinum, YttriumBariumCuprate, Pikyonium, Gold, Ruthenium, Fermium, Trinium};
    private static final Material[] magneticRod = new Material[]{IronMagnetic, SteelMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic, SamariumMagnetic, SamariumMagnetic, ChromiumGermaniumTellurideMagnetic, ChromiumGermaniumTellurideMagnetic, NeptuniumAluminide, NeptuniumAluminide, PlutoniumPhosphide};
    private static final Material[] cableElectric = new Material[]{Tin, Copper, Gold, Aluminium, Platinum, NiobiumTitanium, VanadiumGallium, YttriumBariumCuprate, Pikyonium, PedotTMA, NihoniumTriiodide, Taranium, OganessonTetraTennesside};
    private static final Material[] compMain = new Material[]{Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, VanadiumSteel, HSSE, Tritanium, EnrichedNaqAlloy, HDCS_1, HDCS_2, HDCS_3, SuperheavyL};
    private static final Material[] bearingRound = new Material[]{SilicaCeramic, SilicaCeramic, SilicaCeramic, SilicaCeramic, SilicaCeramic, HSSG, HEA_1, HEA_2, HEA_3, Adamantium, Vibranium, TriniumSteel, HeavyQuarkDegenerate};
    private static final Material[] lube = new Material[]{Lubricant, Lubricant, Lubricant, Lubricant, Lubricant, TriphenylPhosphine, TriphenylPhosphine, TriphenylPhosphine, TriphenylPhosphine, SuspendedPGQD, SuspendedPGQD, SuspendedPGQD, SuspendedPGQD, Leptons};
    private static final Material[] rubbers = new Material[]{Rubber, SiliconeRubber, StyreneButadieneRubber};
    public static final Material[] fluidPipes = new Material[]{SilicaCeramic, Potin, Polyethylene, Chrome, Polytetrafluoroethylene, Iridium, Polybenzimidazole, NiobiumTitanium, Duranium, HDCS_1, HDCS_2, HDCS_3, TantalumHafniumSeaborgiumCarboNitride};
    public static final ItemStack[] emitterGem = new ItemStack[]{OreDictUnifier.get(gem, Quartzite),OreDictUnifier.get(gem, NetherQuartz),OreDictUnifier.get(gemFlawless, CertusQuartz),OreDictUnifier.get(gemFlawless, Diamond),OreDictUnifier.get(gemExquisite, Diamond),OreDictUnifier.get(foil, Platinum,64),OreDictUnifier.get(foil, Osmiridium, 64),OreDictUnifier.get(foil, Phosphorene, 64),OreDictUnifier.get(foil, Graphene, 64),OreDictUnifier.get(nanofoil, Chrome, 64),OreDictUnifier.get(nanofoil, Palladium, 64),OreDictUnifier.get(nanofoil, NaquadahEnriched, 64),OreDictUnifier.get(nanofoil, Trinium, 64)};
    public static final ItemStack[] sensorGem = new ItemStack[]{OreDictUnifier.get(gem, Olivine),OreDictUnifier.get(gem, Emerald),OreDictUnifier.get(gem, Ruby),OreDictUnifier.get(gem, Sapphire),OreDictUnifier.get(gem, Opal),OreDictUnifier.get(foil, Electrum, 64),OreDictUnifier.get(foil, Ruthenium, 64),OreDictUnifier.get(foil, Naquadah, 64),OreDictUnifier.get(foil, Rutherfordium, 64),OreDictUnifier.get(nanofoil, Germanium, 64),OreDictUnifier.get(nanofoil, Americium, 64),OreDictUnifier.get(nanofoil, Seaborgium, 64),OreDictUnifier.get(nanofoil, Vibranium, 64)};
    public static final Material[] emitterMaterial = new Material[]{Brass, Electrum, Silicon, Chrome, Thulium, Palladium, Rhenium, Fermium, NaquadahEnriched, Tritanium, Trinium, Nihonium, Taranium};
    //public static final Material[] a = new Material[]{};
    //public static final Material[] a = new Material[]{};
    //public static final Material[] a = new Material[]{};


    public static void init(){
        removeOldComponents();
        registerComponents();
        registerHullsCasings();
    }

    // Register recipes for standard GT components
    private static void registerComponents() {

        // Steam Components

        ModHandler.addShapedRecipe("steam_pump", STEAM_PUMP.getStackForm(),
                "SPS", "GIG", "PMP",
                'I', OreDictUnifier.get(pipeNormalFluid, Bronze),
                'S', OreDictUnifier.get(plate, Bronze),
                'M', STEAM_MOTOR.getStackForm(),
                'P', OreDictUnifier.get(screw, Iron),
                'G', OreDictUnifier.get(gearSmall, Iron));

        ModHandler.addShapedRecipe("steam_piston", STEAM_PISTON.getStackForm(),
                "DDD", "GPG", "SRS",
                'D', OreDictUnifier.get(plate, Iron),
                'G', OreDictUnifier.get(gearSmall, Iron),
                'S', OreDictUnifier.get(stick, Iron),
                'P', OreDictUnifier.get(plate, Bronze),
                'R', OreDictUnifier.get(ring, Bronze));
        ModHandler.addShapedRecipe("steam_motor", STEAM_MOTOR.getStackForm(),
                "PSP", "IRI", "PSP",
                'P', OreDictUnifier.get(plate, Bronze),
                'S', OreDictUnifier.get(stick, Iron),
                'I', OreDictUnifier.get(plate, Iron),
                'R', OreDictUnifier.get(rotor, Bronze));

        // Specialized Motor Crafting Recipes

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[0])
                .duration(80)
                .input(wireFine, Copper, 8)
                .input(cableGtSingle, Tin, 2)
                .input(stick, Steel, 2)
                .input(stick, IronMagnetic)
                .output(ELECTRIC_MOTOR_LV)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[0])
                .duration(80)
                .input(stick, Steel, 2)
                .input(plate, Steel, 2)
                .input(gear, Steel)
                .input(ELECTRIC_MOTOR_LV)
                .input(cableGtSingle, Tin)
                .output(ELECTRIC_PISTON_LV)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[0])
                .duration(80)
                .input(cableGtSingle, Tin, 2)
                .input(gearSmall, Steel, 2)
                .input(stickLong, Steel, 2)
                .input(ELECTRIC_PISTON_LV)
                .input(ELECTRIC_MOTOR_LV)
                .input(circuit, tierCircuitNames[0])
                .output(ROBOT_ARM_LV)
                .buildAndRegister();

        for (Material rubber : rubbers) {
            STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[0])
                    .duration(80)
                    .input(ring, rubber, 2)
                    .input(screw, compMain[0], 2)
                    .input(rotor, compMain[0])
                    .input(pipeLargeFluid, fluidPipes[0])
                    .input(motors[0])
                    .input(cableGtSingle, cableElectric[0])
                    .output(pump[0])
                    .buildAndRegister();

            STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[0])
                    .duration(80)
                    .input(plate, rubber, 6)
                    .input(gearSmall, compMain[0], 2)
                    .input(motors[0], 2)
                    .input(cableGtSingle, cableElectric[0], 2)
                    .output(conveyor[0])
                    .buildAndRegister();
        }

        // LV-IV Loop
        for (int i = 0; i < 5; i++) {
            //Component Assembler Recipes -
            //Motor

            OreDictUnifier.registerOre(motors[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(motorWires[i], M*2),
                    new MaterialStack(magneticRod[i], i > HV ? M : M/2),
                    new MaterialStack(compMain[i], M),
                    new MaterialStack(cableElectric[i], i > 2 ? 2 : 1)
            ));

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[i])
                    .duration((i+1)*20)
                    .input(wireGtSingle, motorWires[i], 4)
                    .input(stick, magneticRod[i], i > HV ? 2 : 1)
                    .input(stick, compMain[i], 2)
                    .input(i > 2 ? cableGtDouble : cableGtSingle, cableElectric[i], 2)
                    .fluidInputs(lube[i].getFluid(50*(i+1)))
                    .output(motors[i])
                    .buildAndRegister();

            OreDictUnifier.registerOre(pistons[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(motorWires[i], M*2),
                    new MaterialStack(magneticRod[i], i > HV ? M : M/2),
                    new MaterialStack(compMain[i], M*4),
                    new MaterialStack(cableElectric[i], i > 2 ? M*5/2 : M*3/2)
            ));

            //Piston
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[i])
                    .duration((i+1)*20)
                    .input(stick, compMain[i], 2)
                    .input(plate, compMain[i], 2)
                    .input(gearSmall, compMain[i])
                    .input(motors[i])
                    .input(cableGtSingle, cableElectric[i])
                    .fluidInputs(lube[i].getFluid(50*(i+1)))
                    .output(pistons[i])
                    .buildAndRegister();

            OreDictUnifier.registerOre(roboArm[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(motorWires[i], M*2),
                    new MaterialStack(magneticRod[i], i > HV ? M : M/2),
                    new MaterialStack(compMain[i], M*8),
                    new MaterialStack(cableElectric[i], i > 2 ? 4 : 3)
            ));

            //Robot Arm
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[i])
                    .duration((i+1)*20)
                    .input(cableGtSingle, cableElectric[i], 2)
                    .input(gearSmall, compMain[i], 2)
                    .input(stickLong, compMain[i], 2)
                    .input(pistons[i])
                    .input(motors[i])
                    .input(circuit, tierCircuitNames[i])
                    .fluidInputs(lube[i].getFluid(50*(i+1)))
                    .output(roboArm[i])
                    .buildAndRegister();


            OreDictUnifier.registerOre(sensor[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(emitterMaterial[i], M*2),
                    new MaterialStack(compMain[i], M*5)
            ));

            //Sensor
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[i])
                    .duration((i+1)*20)
                    .input(stick, emitterMaterial[i], 4)
                    .input(plate, compMain[i], 4)
                    .input(bolt, compMain[i], 8)
                    .input(circuit, tierCircuitNames[i + 1])
                    .inputs(emitterGem[i])
                    .fluidInputs(SolderingAlloy.getFluid(144))
                    .output(emitter[i])
                    .buildAndRegister();

            OreDictUnifier.registerOre(emitter[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(emitterMaterial[i], M*2),
                    new MaterialStack(compMain[i], M*4)
            ));

            //Emitter
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .EUt(VA[i])
                    .duration((i+1)*20)
                    .input(stickLong, compMain[i], 2)
                    .input(foil, emitterMaterial[i], 8)
                    .input(screw, compMain[i], 16)
                    .input(circuit, tierCircuitNames[i + 1])
                    .inputs(sensorGem[i])
                    .fluidInputs(SolderingAlloy.getFluid(144))
                    .output(sensor[i])
                    .buildAndRegister();

            OreDictUnifier.registerOre(pump[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(Ash, M/2),
                    new MaterialStack(compMain[i], M*5),
                    new MaterialStack(fluidPipes[i], M*6),
                    new MaterialStack(motorWires[i], M*2)
            ));

            OreDictUnifier.registerOre(conveyor[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(Ash, M*4),
                    new MaterialStack(compMain[i], M*4),
                    new MaterialStack(cableElectric[i], M*3),
                    new MaterialStack(motorWires[i], M*4)
            ));

            for (Material rubber : rubbers) {
                //Pump
                COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                        .EUt(VA[i])
                        .duration((i + 1) * 20)
                        .input(ring, rubber, 2)
                        .input(screw, compMain[i], 2)
                        .input(rotor, compMain[i])
                        .input(pipeLargeFluid, fluidPipes[i])
                        .input(motors[i])
                        .input(cableGtSingle, cableElectric[i])
                        .fluidInputs(lube[i].getFluid(50 * (i + 1)))
                        .output(pump[i])
                        .buildAndRegister();
                //Conveyor
                COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                        .EUt(VA[i])
                        .duration((i + 1) * 20)
                        .input(plate, rubber, 6)
                        .input(gearSmall, compMain[i], 2)
                        .input(motors[i], 2)
                        .input(cableGtSingle, cableElectric[i], 2)
                        .fluidInputs(lube[i].getFluid(50 * (i + 1)))
                        .output(conveyor[i])
                        .buildAndRegister();

                COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                        .EUt(VA[i])
                        .duration((i + 1) * 20)
                        .input(gearSmall, compMain[i], 2)
                        .input(motors[i], 2)
                        .input(cableGtSingle, cableElectric[i], 2)
                        .fluidInputs(rubber.getFluid(576))
                        .fluidInputs(lube[i].getFluid(50 * (i + 1)))
                        .output(conveyor[i])
                        .buildAndRegister();
            }
        }

        // LuV-UHV Loop



        for (int i = 5; i < 9; i++) {

            OreDictUnifier.registerOre(motors[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(magneticRod[i], i > 6 ? M*32 : M*16),
                    new MaterialStack(compMain[i], i > 6 ? M*20 : M*6),
                    new MaterialStack(cableElectric[i], i > 6 ? M*4 : M*2),
                    new MaterialStack(motorWires[i], (i-4)*16*M)
            ));

            //Motor
            RecipeBuilder builder = ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .EUt(VA[i+1])
                    .duration((i+1)*20)
                    .input(stick, magneticRod[i], i > 6 ? 64 : 32)
                    .input(stick, compMain[i], i > 6 ? 16 : 8)
                    .input(stickLong, compMain[i], i > 6 ? 4 : 2)
                    .input(round, bearingRound[i], i > 6 ? 32 : 16)
                    .input(cableGtDouble, cableElectric[i], i > 6 ? 4 : 2)
                    .fluidInputs(lube[i].getFluid((i-4)*250))
                    .output(motors[i]);
            for (int j = i-4; j > 0; j--) {
                builder.input(wireFine, motorWires[i], 64);
            }
            builder.buildAndRegister();

            //Piston

            //Robot Arm
            //Pump
            //Sensor
            //Emitter
            //Field Generator
        }



        //UEV-OpV Loop
        for (int i = 9; i < OpV; i++) {

            OreDictUnifier.registerOre(motors[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(magneticRod[i], i > 10 ? i == 12 ? M * 64 : M*48 : M*32),
                    new MaterialStack(compMain[i], i > 10 ? M*40 : M*20),
                    new MaterialStack(cableElectric[i], M*16),
                    new MaterialStack(motorWires[i], (4*M/9)*(i-8))
            ));

            // Motor
            RecipeBuilder builder = ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .EUt(VA[i+1])
                    .duration((i+1)*20)
                    .input(stick, magneticRod[i], 64)
                    .fluidInputs(lube[i].getFluid((i-8)*250))
                    .output(motors[i]);

            if (i > 10) {
                builder.input(stick, magneticRod[i], i == 11 ? 32 : 64);
            }

            builder.input(stick, compMain[i], i > 10 ? 64 : 32);
            builder.input(stickLong, compMain[i], i > 10 ? 8 : 4);
            builder.input(round, bearingRound[i], i > 10 ? 64 : 32);
            builder.input(cableGtQuadruple, cableElectric[i], 8);

            for (int j = i-8; j > 0; j--) {
                builder.input(nanowire, motorWires[i], 64);
                builder.input(nanowire, motorWires[i], 64);
            }
            builder.buildAndRegister();

            //Piston

            //Robot Arm
            //Pump
            //Sensor
            //Emitter
            //Field Generator
        }
    }

    // Register recipes for machine casings and hulls
    private static void registerHullsCasings() {

        for (int i = LV; i < LuV; i++) {

        }
    }

    // Remove recipes for all GT components
    private static void removeOldComponents() {

        //TODO: Remove decomp recipes for components
        //this doesnt work
        //GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, motors[0].getStackForm());

        // remove motors
        removeRecipeByName("gregtech:electric_motor_lv_steel");
        removeRecipeByName("gregtech:electric_motor_lv_iron");
        removeRecipeByName("gregtech:electric_motor_mv");
        removeRecipeByName("gregtech:electric_motor_hv");
        removeRecipeByName("gregtech:electric_motor_ev");
        removeRecipeByName("gregtech:electric_motor_iv");
        removeRecipeByName("gregtech:electric_piston_lv");
        removeRecipeByName("gregtech:electric_piston_mv");
        removeRecipeByName("gregtech:electric_piston_hv");
        removeRecipeByName("gregtech:electric_piston_ev");
        removeRecipeByName("gregtech:electric_piston_iv");
        removeRecipeByName("gregtech:robot_arm_lv");
        removeRecipeByName("gregtech:robot_arm_mv");
        removeRecipeByName("gregtech:robot_arm_hv");
        removeRecipeByName("gregtech:robot_arm_ev");
        removeRecipeByName("gregtech:robot_arm_iv");
        removeRecipeByName("gregtech:electric_pump_lv_rubber");
        removeRecipeByName("gregtech:electric_pump_lv_silicone_rubber");
        removeRecipeByName("gregtech:electric_pump_lv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:electric_pump_mv_rubber");
        removeRecipeByName("gregtech:electric_pump_mv_silicone_rubber");
        removeRecipeByName("gregtech:electric_pump_mv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:electric_pump_hv_rubber");
        removeRecipeByName("gregtech:electric_pump_hv_silicone_rubber");
        removeRecipeByName("gregtech:electric_pump_hv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:electric_pump_ev_rubber");
        removeRecipeByName("gregtech:electric_pump_ev_silicone_rubber");
        removeRecipeByName("gregtech:electric_pump_ev_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:electric_pump_iv_rubber");
        removeRecipeByName("gregtech:electric_pump_iv_silicone_rubber");
        removeRecipeByName("gregtech:electric_pump_iv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:conveyor_module_lv_rubber");
        removeRecipeByName("gregtech:conveyor_module_lv_silicone_rubber");
        removeRecipeByName("gregtech:conveyor_module_lv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:conveyor_module_mv_rubber");
        removeRecipeByName("gregtech:conveyor_module_mv_silicone_rubber");
        removeRecipeByName("gregtech:conveyor_module_mv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:conveyor_module_hv_rubber");
        removeRecipeByName("gregtech:conveyor_module_hv_silicone_rubber");
        removeRecipeByName("gregtech:conveyor_module_hv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:conveyor_module_ev_rubber");
        removeRecipeByName("gregtech:conveyor_module_ev_silicone_rubber");
        removeRecipeByName("gregtech:conveyor_module_ev_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:conveyor_module_iv_rubber");
        removeRecipeByName("gregtech:conveyor_module_iv_silicone_rubber");
        removeRecipeByName("gregtech:conveyor_module_iv_styrene_butadiene_rubber");
        removeRecipeByName("gregtech:emitter_lv");
        removeRecipeByName("gregtech:emitter_mv");
        removeRecipeByName("gregtech:emitter_hv");
        removeRecipeByName("gregtech:emitter_ev");
        removeRecipeByName("gregtech:emitter_iv");
        removeRecipeByName("gregtech:field_generator_lv");
        removeRecipeByName("gregtech:field_generator_mv");
        removeRecipeByName("gregtech:field_generator_hv");
        removeRecipeByName("gregtech:field_generator_ev");
        removeRecipeByName("gregtech:field_generator_iv");
        removeRecipeByName("gregtech:sensor_lv");
        removeRecipeByName("gregtech:sensor_mv");
        removeRecipeByName("gregtech:sensor_hv");
        removeRecipeByName("gregtech:sensor_ev");
        removeRecipeByName("gregtech:sensor_iv");

        Material[] cables = new Material[]{Tin, Copper, Gold, Aluminium, Tungsten};
        Material[] cablesMotor = new Material[]{Tin, Copper, Silver, Aluminium, Tungsten};
        Material[] materials = new Material[]{Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel};
        Material[] motorRodsMagnetic = new Material[]{SteelMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic};
        Material[] motorWires = new Material[]{Copper, Cupronickel, Electrum, Kanthal, Graphene};
        Material[] pumpScrew = new Material[]{Tin, Bronze, Steel, StainlessSteel, TungstenSteel};
        Material[] pumpPipe = new Material[]{Bronze, Steel, StainlessSteel, Titanium, TungstenSteel};
        ItemStack[] fgGem = new ItemStack[]{OreDictUnifier.get(gem, EnderPearl), OreDictUnifier.get(gem, EnderEye), QUANTUM_EYE.getStackForm(), OreDictUnifier.get(gem, NetherStar), QUANTUM_STAR.getStackForm()};
        Material[] superCons = new Material[]{ManganesePhosphide, MagnesiumDiboride, MercuryBariumCalciumCuprate, UraniumTriplatinum, SamariumIronArsenicOxide};
        Material[] emitterRod = new Material[]{Brass, Electrum, Chrome, Platinum, Iridium};
        ItemStack[] emitterGem = new ItemStack[]{OreDictUnifier.get(gem, Quartzite), OreDictUnifier.get(gemFlawless, Emerald), OreDictUnifier.get(gem, EnderEye), QUANTUM_EYE.getStackForm(), QUANTUM_STAR.getStackForm()};


        ///*
        for (int i = 0; i < 5; i++) {
            // Motors
            if (i == 0) {
                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    OreDictUnifier.get(cableGtSingle, cablesMotor[i], 2),
                    OreDictUnifier.get(stick, materials[i], 2),
                    OreDictUnifier.get(stick, motorRodsMagnetic[i]),
                    OreDictUnifier.get(wireGtSingle, motorWires[i], 4));
                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    OreDictUnifier.get(cableGtSingle, cablesMotor[i], 2),
                    OreDictUnifier.get(stick, Iron, 2),
                    OreDictUnifier.get(stick, IronMagnetic),
                    OreDictUnifier.get(wireGtSingle, motorWires[i], 4));
            } else if (i == 1) {
                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    OreDictUnifier.get(cableGtSingle, cablesMotor[i], 2),
                    OreDictUnifier.get(stick, materials[i], 2),
                    OreDictUnifier.get(stick, motorRodsMagnetic[i]),
                    OreDictUnifier.get(wireGtDouble, motorWires[i], 4));
            } else {
                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    OreDictUnifier.get(cableGtDouble, cablesMotor[i], 2),
                    OreDictUnifier.get(stick, materials[i], 2),
                    OreDictUnifier.get(stick, motorRodsMagnetic[i]),
                    OreDictUnifier.get(wireGtDouble, motorWires[i], 4));
            }

            // Pistons
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                OreDictUnifier.get(stick,materials[i], 2),
                OreDictUnifier.get(cableGtSingle, cables[i], 2),
                OreDictUnifier.get(plate, materials[i], 3),
                OreDictUnifier.get(gearSmall, materials[i], 1),
                motors[i].getStackForm(1));

            // Robot Arms
            //TODO these cannot be removed
//            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                OreDictUnifier.get(cableGtSingle, cables[i], 3),
//                OreDictUnifier.get(stick, materials[i], 2),
//                motors[i].getStackForm(2),
//                pistons[i].getStackForm(1),
//                OreDictUnifier.get(circuit, tierCircuitNames[i+1]));

            // Pumps & Conveyors
            for (int j = 0; j < 3; j++) {
                if (!(i == 4 && j == 0)) {
                    GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                         OreDictUnifier.get(cableGtSingle, cables[i]),
                         OreDictUnifier.get(pipeNormalFluid, pumpPipe[i]),
                         OreDictUnifier.get(screw, pumpScrew[i]),
                         OreDictUnifier.get(rotor, pumpScrew[i]),
                         OreDictUnifier.get(ring, rubbers[j], 2),
                         motors[i].getStackForm());

                    //TODO these cannot be removed
//                    GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                         OreDictUnifier.get(cableGtSingle, cables[i]),
//                         OreDictUnifier.get(plate, rubbers[j], 6),
//                            IntCircuitIngredient.getIntegratedCircuit(1),
//                         motors[i].getStackForm(2));
                }
            }

            // Field Gens
            if (i < 3) {
                //TODO these cannot be removed
//                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                     fgGem[i],
//                     OreDictUnifier.get(plate, materials[i], 2),
//                     OreDictUnifier.get(circuit, tierCircuitNames[i+1], 2),
//                     OreDictUnifier.get(wireGtQuadruple, superCons[i], 4));
            } else {
                //TODO these cannot be removed
//                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                     fgGem[i],
//                     OreDictUnifier.get(plateDouble, materials[i], 2),
//                     OreDictUnifier.get(circuit, tierCircuitNames[i+1], 2),
//                     OreDictUnifier.get(wireGtQuadruple, superCons[i], 4));
            }

            // Emitters
            //TODO these cannot be removed
//            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                OreDictUnifier.get(stick, emitterRod[i], 4),
//                OreDictUnifier.get(cableGtSingle, cables[i], 2),
//                OreDictUnifier.get(circuit, tierCircuitNames[i+1], 2),
//                IntCircuitIngredient.getIntegratedCircuit(1),
//                emitterGem[i]);

            // Sensors
            //TODO these cannot be removed
//            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                OreDictUnifier.get(stick, emitterRod[i]),
//                OreDictUnifier.get(plate, materials[i], 4),
//                OreDictUnifier.get(circuit, tierCircuitNames[i+1]),
//                emitterGem[i]);

            // Fluid Regulators
            //TODO these cannot be removed
//            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
//                IntCircuitIngredient.getIntegratedCircuit(1),
//                OreDictUnifier.get(circuit, tierCircuitNames[i+1], 2),
//                pump[i].getStackForm());
        }
        //*/
    }
}
