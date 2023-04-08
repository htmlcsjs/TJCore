package gregicality.science.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraftforge.fluids.FluidStack;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.MOLECULAR_BEAM_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SpintronicCircuits {

    //TODO additional magnets as needed: YbPtBi - antiferromagnetic, GaMnAs - ferromagnetic semiconductor
    public static void init() {
        topologicalIsolators();
    }

    private static void topologicalIsolators() {
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .input(dust, Antimony)
                .input(dust, Tellurium, 2)
                .input(dust, Sulfur)
                .notConsumable(plate, CadmiumSulfide)
                .output(dust, BismuthChalcogenide, 5)
                .duration(80).EUt(VA[UV]).buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Tellurium, 2)
                .fluidInputs(Mercury.getFluid(2000))
                .output(dust, MercuryCadmiumTelluride, 5)
                .notConsumable(new IntCircuitIngredient(1))
                .duration(400).EUt(VA[UHV]).buildAndRegister();
    }
}
