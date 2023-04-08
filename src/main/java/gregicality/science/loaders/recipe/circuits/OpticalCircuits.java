package gregicality.science.loaders.recipe.circuits;

import gregicality.science.api.unification.ore.GCYSOrePrefix;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.items.MetaItems;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT;
import static gregtech.common.items.MetaItems.NOR_MEMORY_CHIP;

public class OpticalCircuits {

    public static void init() {
        opticalFiber();
    }

    private static void opticalFiber() {

        //TODO Low Gravity
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 5)
                .input(dust, Barium, 2)
                .input(dust, Lanthanum)
                .input(dust, Aluminium)
                .input(dust, Sodium, 2)
                .fluidInputs(Fluorine.getFluid(6200))
                .notConsumable(new IntCircuitIngredient(5))
                .fluidOutputs(ZBLANGlass.getFluid(L * 11))
                .blastFurnaceTemp(1073)
                .duration(1800).EUt(VA[HV]).buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Erbium)
                .output(ingot, ErbiumDopedZBLANGlass, 2)
                .duration(200).EUt(VA[HV]).buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Praseodymium)
                .output(ingot, PraseodymiumDopedZBLANGlass, 2)
                .duration(200).EUt(VA[HV]).buildAndRegister();

    }
}
