package TJCore.common.recipes;

import crafttweaker.api.item.IItemStack;
import gregtech.api.GTValues;

import java.util.ArrayList;

import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;

import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.util.GTLog;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Level;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

import static gregtech.api.recipes.RecipeMaps.*;

import gregtech.api.recipes.crafttweaker.*;

public class GTComponents {

    public static void registerComponents() {

        //ArrayList<IItemStack> rods = new ArrayList<IItemStack>(5);
        GTLog.logger.log(Level.ERROR, "motor man, make the recipe. FATAL");


        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtSingle, Tin, 2),
                OreDictUnifier.get(stick, Steel, 2), OreDictUnifier.get(stick, SteelMagnetic), OreDictUnifier.get(wireGtSingle, Copper, 4));


        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Steel, 2)
                .input(stick, SteelMagnetic)
                .input(wireGtSingle, Copper, 4)
                .input(cableGtSingle, Tin, 2)
                .outputs(ELECTRIC_MOTOR_LV.getStackForm())
                .EUt(30)
                .duration(1)
                .buildAndRegister();


    }



}
