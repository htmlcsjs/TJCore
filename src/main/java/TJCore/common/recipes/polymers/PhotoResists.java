package TJCore.common.recipes.polymers;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static TJCore.api.material.TJMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PhotoResists {
    public static void registerPhotoresists() {
        registerHsq();
    }

    private static void registerHsq() {
        CHEMICAL_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[LV])
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Chloromethane.getFluid(1000))
                .input(dust, Silicon)
                .notConsumable(dust, Copper)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Methyltrichlorosilane.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(60)
                .EUt(VA[LV])
                .fluidInputs(Methanol.getFluid(3000))
                .fluidInputs(Methyltrichlorosilane.getFluid(1000))
                .fluidOutputs(Methyltrimethoxysilane.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[LV])
                .fluidInputs(Methyltrimethoxysilane.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Polymethylsilesquioxane.getFluid(1000))
                .fluidOutputs(Methanol.getFluid(3000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(15)
                .EUt(VA[MV])
                .fluidInputs(Polymethylsilesquioxane.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidOutputs(HydrogenSilsesquioxane.getFluid(1000))
                .buildAndRegister();

    }
}
