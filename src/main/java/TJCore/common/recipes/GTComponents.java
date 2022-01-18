package TJCore.common.recipes;

import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;

import gregtech.api.items.metaitem.MetaItem;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;

import static gregtech.api.unification.material.MarkerMaterials.*;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTLog;
import org.apache.logging.log4j.Level;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.common.items.MetaItems.*;

public class GTComponents {

    public static void registerComponents() {

        //ArrayList<IItemStack> rods = new ArrayList<IItemStack>(5);
        GTLog.logger.log(Level.ERROR, "motor man, make the recipe. FATAL");

        // remove motors
        ModHandler.removeRecipeByName("gregtech:electric_motor_lv_steel");
        ModHandler.removeRecipeByName("gregtech:electric_motor_lv_iron");
        ModHandler.removeRecipeByName("gregtech:electric_motor_mv");
        ModHandler.removeRecipeByName("gregtech:electric_motor_hv");
        ModHandler.removeRecipeByName("gregtech:electric_motor_ev");
        ModHandler.removeRecipeByName("gregtech:electric_motor_iv");
        ModHandler.removeRecipeByName("gregtech:electric_piston_lv");
        ModHandler.removeRecipeByName("gregtech:electric_piston_mv");
        ModHandler.removeRecipeByName("gregtech:electric_piston_hv");
        ModHandler.removeRecipeByName("gregtech:electric_piston_ev");
        ModHandler.removeRecipeByName("gregtech:electric_piston_iv");
        ModHandler.removeRecipeByName("gregtech:robot_arm_lv");
        ModHandler.removeRecipeByName("gregtech:robot_arm_mv");
        ModHandler.removeRecipeByName("gregtech:robot_arm_hv");
        ModHandler.removeRecipeByName("gregtech:robot_arm_ev");
        ModHandler.removeRecipeByName("gregtech:robot_arm_iv");
        ModHandler.removeRecipeByName("gregtech:electric_pump_lv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_lv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_lv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_mv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_hv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_ev_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_iv_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_iv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:electric_pump_iv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_lv_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_lv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_lv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_mv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_hv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_ev_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_iv_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_iv_silicone_rubber");
        ModHandler.removeRecipeByName("gregtech:conveyor_module_iv_styrene_butadiene_rubber");
        ModHandler.removeRecipeByName("gregtech:emitter_lv");
        ModHandler.removeRecipeByName("gregtech:emitter_mv");
        ModHandler.removeRecipeByName("gregtech:emitter_hv");
        ModHandler.removeRecipeByName("gregtech:emitter_ev");
        ModHandler.removeRecipeByName("gregtech:emitter_iv");
        ModHandler.removeRecipeByName("gregtech:sensor_lv");
        ModHandler.removeRecipeByName("gregtech:sensor_mv");
        ModHandler.removeRecipeByName("gregtech:sensor_hv");
        ModHandler.removeRecipeByName("gregtech:sensor_ev");
        ModHandler.removeRecipeByName("gregtech:sensor_iv");


        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Iron, 2), OreDictUnifier.get(stick, IronMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 2),
                OreDictUnifier.get(stick, Aluminium, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtDouble, Cupronickel, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Silver, 2),
                OreDictUnifier.get(stick, StainlessSteel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtDouble, Electrum, 4));
        //GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Aluminium, 2),
        //        OreDictUnifier.get(stick, Titanium, 2), OreDictUnifier.get(stick, NeodymiumMagnetic), OreDictUnifier.get(wireGtDouble, Graphene, 4));

        MetaItem.MetaValueItem[] motor = {ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV};
        MetaItem.MetaValueItem[] piston = {ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV};
        MetaItem.MetaValueItem[] robot_arm = {ROBOT_ARM_LV, ROBOT_ARM_MV, ROBOT_ARM_HV, ROBOT_ARM_EV, ROBOT_ARM_IV};
        MetaItem.MetaValueItem[] pump = {ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV};
        MetaItem.MetaValueItem[] emitter = {EMITTER_LV, EMITTER_MV, EMITTER_HV, EMITTER_EV, EMITTER_IV};
        MetaItem.MetaValueItem[] sensor = {SENSOR_LV, SENSOR_MV, SENSOR_HV, SENSOR_EV, SENSOR_IV};
        MetaItem.MetaValueItem[] conveyor = {CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV};

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(plate, Steel, 3), OreDictUnifier.get(gearSmall, Steel), motor[0].getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Copper, 2),
                OreDictUnifier.get(stick, Aluminium, 2), OreDictUnifier.get(plate, Aluminium, 3), OreDictUnifier.get(gearSmall, Aluminium), motor[1].getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Gold, 2),
                OreDictUnifier.get(stick, StainlessSteel, 2), OreDictUnifier.get(plate, StainlessSteel, 3), OreDictUnifier.get(gearSmall, StainlessSteel), motor[2].getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Aluminium, 2),
                OreDictUnifier.get(stick, Titanium, 2), OreDictUnifier.get(plate, Titanium, 3), OreDictUnifier.get(gearSmall, Titanium), motor[3].getStackForm());
        //GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Platinum, 2),
        //        OreDictUnifier.get(stick, TungstenSteel, 2), OreDictUnifier.get(plate, TungstenSteel, 3), OreDictUnifier.get(gearSmall, TungstenSteel), motor[4].getStackForm());
        //GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
        //        OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));

        /*
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        */

        Material[] Materials = {Steel, Birmabright, BlueSteel, BT6, TungstenSteel};
        Material[] materialRubber = {Rubber, Rubber, SiliconeRubber, StyreneButadieneRubber, StyreneButadieneRubber};
        Material[] MagMaterials = {SteelMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic};
        OrePrefix[] cableThickness = {cableGtSingle, cableGtSingle, cableGtSingle, cableGtDouble, cableGtDouble};
        Material[] cableMaterial = {Tin, Copper, Silver, Aluminium, Platinum};
        OrePrefix[] wireThickness = {wireGtSingle, wireGtSingle, wireGtDouble, wireGtDouble, wireGtQuadruple};
        Material[] wireMaterial = {Copper, AnnealedCopper, Gold, BlueSteel, Graphene};
        Material[] pipeMaterial = {Bronze, Birmabright, BlueSteel, BT6, TungstenSteel};
        Material[] gemMaterial = {NetherQuartz, Ruby, Diamond, EnderEye, NetherStar};
        OrePrefix[] gemShape = {gem, gemExquisite, gemFlawless, gem, gem};
        Material[] sensorMaterial = {Brass, CobaltBrass, BlueSteel, StainlessSteel, TungstenCarbide};
        Material[] sensorMaterial2 = {Steel, Electrum, RedSteel, BlueAlloy, BT6};


        Material[] fluid = {Lubricant, Lubricant, Lubricant, TriphenylPhosphine, TriphenylPhosphine};
        int[] fluidAmount = {1000, 250, 500, 750, 1000};
        int[] fluidAmount2 = {500, 500, 500, 500, 500};

        Material[] circuits = {Tier.Basic, Tier.Good, Tier.Advanced, Tier.Extreme, Tier.Elite};




        for(int i = 0; i < 5; i++) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(stick, Materials[i], 2)
                    .input(stick, MagMaterials[i])
                    .input(wireThickness[i], wireMaterial[i], 4)
                    .input(cableThickness[i], cableMaterial[i], 2)
                    .fluidInputs(fluid[i].getFluid(fluidAmount[i]))
                    .output(motor[i])
                    .EUt(30 * (int)Math.pow(4, i))
                    .duration(300)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(motor[i])
                    .input(stick, Materials[i], 2)
                    .input(gearSmall, Materials[i])
                    .input(plate, Materials[i], 3)
                    .input(cableThickness[i], cableMaterial[i], 2)
                    .fluidInputs(fluid[i].getFluid(fluidAmount[i]))
                    .output(piston[i])
                    .EUt(30 * (int)Math.pow(4, i))
                    .duration(300)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(motor[i], 2)
                    .input(piston[i])
                    .input(stick, Materials[i], 2)
                    .input(OrePrefix.circuit, circuits[i])
                    .input(cableThickness[i], cableMaterial[i], 2)
                    .fluidInputs(fluid[i].getFluid(fluidAmount[i]))
                    .output(robot_arm[i])
                    .EUt(30 * (int)Math.pow(4, i))
                    .duration(300)
                    .buildAndRegister();




            for( int j = 4; j >= i; j--) {
                COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                        .input(motor[i], 2)
                        .input(wireThickness[i], wireMaterial[i])
                        .input(plate, materialRubber[j], 6)
                        .fluidInputs(fluid[j].getFluid(fluidAmount2[i]))
                        .output(conveyor[i])
                        .EUt(30 * (int)Math.pow(4, i))
                        .duration(300)
                        .buildAndRegister();

                COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                        .input(motor[i])
                        .input(rotor, Materials[i])
                        .input(screw, Materials[i])
                        .input(cableThickness[i], cableMaterial[i], 2)
                        .input(pipeNormalFluid, pipeMaterial[i])
                        .fluidInputs(materialRubber[j].getFluid(500))
                        .output(pump[i])
                        .EUt(30 * (int) Math.pow(4, i))
                        .duration(300)
                        .buildAndRegister();
            }

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(plate, sensorMaterial2[i], 4)
                    .input(stick, sensorMaterial[i])
                    .input(gemShape[i], gemMaterial[i])
                    .input(OrePrefix.circuit, circuits[i])
                    .output(sensor[i])
                    .EUt(30 * (int)Math.pow(4, i))
                    .duration(300)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(stick, sensorMaterial[i], 4)
                    .input(cableThickness[i], cableMaterial[i], 2)
                    .input(gemShape[i], gemMaterial[i])
                    .input(OrePrefix.circuit, circuits[i], 2)
                    .output(emitter[i])
                    .EUt(30 * (int)Math.pow(4, i))
                    .duration(300)
                    .buildAndRegister();
        }

        //steam stuff
        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Materials[0], 2)
                .input(stick, Materials[0])
                .input(wireThickness[0], wireMaterial[0], 4)
                .input(cableThickness[0], cableMaterial[0], 2)
                .output(motor[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(motor[0])
                .input(stick, Materials[0], 2)
                .input(gearSmall, Materials[0])
                .input(plate, Materials[0], 3)
                .input(cableThickness[0], cableMaterial[0], 2)
                .output(piston[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(motor[0], 2)
                .input(piston[0])
                .input(stick, Materials[0], 2)
                .input(OrePrefix.circuit, circuits[0])
                .input(cableThickness[0], cableMaterial[0], 2)
                .output(robot_arm[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(motor[0], 2)
                .input(wireThickness[0], wireMaterial[0])
                .input(plate, materialRubber[0], 6)
                .output(conveyor[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        STEAM_COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(motor[0])
                .input(rotor, Materials[0])
                .input(screw, Materials[0])
                .input(cableThickness[0], cableMaterial[0], 2)
                .input(pipeNormalFluid, pipeMaterial[0])
                .input(ring,Rubber,4)
                .output(pump[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, sensorMaterial2[0], 4)
                .input(stick, sensorMaterial[0])
                .input(gemShape[0], gemMaterial[0])
                .input(OrePrefix.circuit, circuits[0])
                .output(sensor[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, sensorMaterial[0], 4)
                .input(cableThickness[0], cableMaterial[0], 2)
                .input(gemShape[0], gemMaterial[0])
                .input(OrePrefix.circuit, circuits[0], 2)
                .output(emitter[0])
                .EUt(30)
                .duration(300)
                .buildAndRegister();
    }



}
