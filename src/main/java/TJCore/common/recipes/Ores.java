package TJCore.common.recipes;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
//import scala.actors.threadpool.Arrays; // FUCK YOU SCALA

import java.util.Arrays;

import static gregtech.api.recipes.MatchingMode.IGNORE_FLUIDS;
import static gregtech.api.unification.material.Materials.*;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class Ores {

    public static void RegisterOres() {
        removeTinyAndReplaceWithChance(0, Magnetite, Gold);
    }


    private static void removeTinyAndReplaceWithChance(long voltage, Material mainDust, Material secondaryDust) {
        Recipe result = MACERATOR_RECIPES.findRecipe(voltage, Arrays.asList(OreDictUnifier.get(crushed, mainDust)), null, 0, IGNORE_FLUIDS);
        if(result != null)
            MACERATOR_RECIPES.removeRecipe(result);

        //GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(dust, mainDust), OreDictUnifier.get(dust, secondaryDust));


    }


}
