package tjcore.common.recipes;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static tjcore.api.material.TJMaterials.*;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.*;

public class LogisiticsRecipes {
    public static void init() {
        longDistance();
    }



    private static void longDistance() {
        Material[] conductors = new Material[]{Tin, Copper, Gold, Aluminium, Platinum};
        for (int i = 0; i < longDistanceWireMaterials.length; i++) {
            LAMINATOR_RECIPES.recipeBuilder()
                    .EUt(VA[1 + i])
                    .duration(45)
                    .input(ring, SilicaCeramic, 2)
                    .input(foil, i < 2 ? Rubber : SiliconeRubber, 4)
                    .input(wireGtSingle, conductors[i], 4)
                    .fluidInputs(i < 3 ? Polyethylene.getFluid(144) : i == 3 ? Polytetrafluoroethylene.getFluid(144) : Polycaprolactam.getFluid(144))
                    .output(cableGtQuadruple, longDistanceWireMaterials[i])
                    .buildAndRegister();
        }
    }
}
