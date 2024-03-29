package gregicality.science.loaders.recipe.chain;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;

public class AcetyleneChain {

    public static void init() {
        // CaO + 3C -> CaC2 + CO

        // CaC2 + 2H2O -> Ca(OH)2 + C2H2
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumCarbide, 3)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CalciumHydroxide, 5)
                .fluidOutputs(Acetylene.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();

        // Ca(OH)2 + CO2 -> CaCO3 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(Water.getFluid(1000))
                .duration(80).EUt(VA[LV]).buildAndRegister();
    }
}
