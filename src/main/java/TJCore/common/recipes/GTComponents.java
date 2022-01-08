package TJCore.common.recipes;

import crafttweaker.api.item.IItemStack;
import gregtech.api.GTValues;

import java.util.ArrayList;

import static TJCore.common.material.TJMaterials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.CountableIngredient;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterial.*;
import static gregtech.api.unification.material.MarkerMaterials.*;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTLog;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.apache.logging.log4j.Level;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

import gregtech.api.recipes.crafttweaker.*;

public class GTComponents {

    public static void registerComponents() {

        //ArrayList<IItemStack> rods = new ArrayList<IItemStack>(5);
        GTLog.logger.log(Level.ERROR, "motor man, make the recipe. FATAL");

        // remove motors
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Iron, 2), OreDictUnifier.get(stick, IronMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));
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

        Material[] Materials = {Iron, Birmabright, BlueSteel, BT6, TungstenSteel};
        Material[] materialRubber = {Rubber, Rubber, SiliconeRubber, StyreneButadieneRubber, StyreneButadieneRubber};
        Material[] MagMaterials = {IronMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic};
        OrePrefix[] cableThickness = {cableGtSingle, cableGtSingle, cableGtSingle, cableGtDouble, cableGtDouble};
        Material[] cableMaterial = {Tin, Copper, Silver, Aluminium, Platinum};
        OrePrefix[] wireThickness = {wireGtSingle, wireGtSingle, wireGtDouble, wireGtDouble, wireGtQuadruple};
        Material[] wireMaterial = {Copper, AnnealedCopper, Gold, BlueSteel, Tungsten};
        Material[] pipeMaterial = {Bronze, Birmabright, BlueSteel, BT6, TungstenSteel};
        Material[] gemMaterial = {NetherQuartz, Ruby, Diamond, EnderEye, NetherStar};
        OrePrefix[] gemShape = {gem, gemExquisite, gemFlawless, gem, gem};
        Material[] sensorMaterial = {Brass, CobaltBrass, BlueSteel, StainlessSteel, TungstenCarbide};
        Material[] sensorMaterial2 = {Steel, Electrum, RedSteel, BlueAlloy, BT6};


        Material[] fluid = {Steam, Lubricant, Lubricant, Lubricant, Lubricant};
        int[] fluidAmount = {1000, 250, 500, 750, 1000};
        int[] fluidAmount2 = {500, 500, 500, 500, 500};

        Material[] circuits = {Tier.Basic, Tier.Good, Tier.Advanced, Tier.Extreme, Tier.Elite};

        MetaItem.MetaValueItem[] motor = {ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV};
        MetaItem.MetaValueItem[] piston = {ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV};
        MetaItem.MetaValueItem[] robot_arm = {ROBOT_ARM_LV, ROBOT_ARM_MV, ROBOT_ARM_HV, ROBOT_ARM_EV, ROBOT_ARM_IV};
        MetaItem.MetaValueItem[] pump = {ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV};
        MetaItem.MetaValueItem[] emitter = {EMITTER_LV, EMITTER_MV, EMITTER_HV, EMITTER_EV, EMITTER_IV};
        MetaItem.MetaValueItem[] sensor = {SENSOR_LV, SENSOR_MV, SENSOR_HV, SENSOR_EV, SENSOR_IV};
        MetaItem.MetaValueItem[] conveyor = {CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV};


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
    }



}
