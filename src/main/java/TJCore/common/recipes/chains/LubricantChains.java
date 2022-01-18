package TJCore.common.recipes.chains;

//import crafttweaker.api.item.IItemStack;
//import gregtech.api.unification.OreDictUnifier;

import static TJCore.api.material.TJMaterials.*;
import static gregtech.api.unification.material.Materials.*;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class LubricantChains {

    public static void loadRecipes() {


        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(3000))
                .input(dust, Phosphorus)
                .fluidOutputs(PhosphorusTrichloride.getFluid(1000))
                .EUt(120)
                .duration(600)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000), Chlorobenzene.getFluid(3000))
                .input(dust, Sodium, 6)
                .output(dust, Salt, 6)
                .fluidOutputs(TriphenylPhosphine.getFluid(1000))
                .EUt(120)
                .duration(600)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                //.fluidInputs(CalciumCarbide.getFluid(1000))
                .fluidOutputs(Acetylene.getFluid(1000))
                //.fluidOutputs(CalciumHydroxide.getFluid(1000))
                .EUt(120)
                .duration(600)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(Difluoroethane.getFluid(1000))
                .EUt(480)
                .duration(900)
                .buildAndRegister();

    }

}
