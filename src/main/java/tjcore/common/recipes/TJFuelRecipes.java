package tjcore.common.recipes;

import static gregtech.api.GTValues.LV;
import static gregtech.api.GTValues.V;
import static gregtech.api.unification.material.Materials.DistilledWater;
import static gregtech.api.unification.material.Materials.Steam;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.MODULAR_STEAM_TURBINE_RECIPES;

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
