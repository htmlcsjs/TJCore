package TJCore.common.recipes;

import gregtech.api.recipes.RecipeMaps;

import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class TJFuelRecipes {
    public static void init() {
        steamRecipes();
    }
    private static void steamRecipes() {
        MODULAR_STEAM_TURBINE_RECIPES.recipeBuilder()
            .fluidInputs(Steam.getFluid(160))
            .fluidOutputs(DistilledWater.getFluid(1))
            .duration(10)
            .EUt((int) V[LV])
            .buildAndRegister();
    }
}
