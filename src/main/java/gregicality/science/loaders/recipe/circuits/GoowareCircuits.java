package gregicality.science.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class GoowareCircuits {

    public static void init() {

        // Processing Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(FLUID_CELL_LARGE_STAINLESS_STEEL.getStackForm())
                .input(plate, Naquadah, 4)
                .input(plate, Ruridit, 2)
                .input(bolt, Trinium, 12)
                .input(stick, SamariumMagnetic)
                .input(rotor, Iridium)
                .input(ELECTRIC_MOTOR_LuV)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(BZ_REACTION_CHAMBER.getStackForm())
                .duration(600).EUt(VA[UV]).buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .inputs(BZ_REACTION_CHAMBER.getStackForm())
                .fluidInputs(BZMedium.getFluid(500))
                .outputs(NONLINEAR_CHEMICAL_OSCILLATOR.getStackForm())
                .duration(60).EUt(VA[IV]).buildAndRegister();


    }
}
