package TJCore.common.recipes.chains;

import TJCore.common.metaitem.TJMetaItems;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.items.MetaItems;
import gregtech.loaders.recipe.CraftingComponent;

import static TJCore.api.material.TJMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class MagicChains {

    public static void BaseMagicDust() {

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Naquadah)
                .input(dust, Rhodium, 2)
                .fluidInputs(Fluorine.getFluid(4000))
                //.fluidOutputs(NqRh2F4.getFluid(7000))
                .EUt(8000)
                .duration(80)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.EV, 4)
                .input(dust, NeodymiumMagnetic)
                .input(MetaItems.GLASS_TUBE) // TODO (Onion): replace with alumino silicate tube
                .input(MetaItems.ELECTRIC_MOTOR_EV)
                .input(cableGtSingle, Aluminium, 2)
                .input(rotor, Titanium)
                //.output(TJMetaItems.OSCILLATING_FERROMAGNETIC_CATALYZER)
                .EUt(2000)
                .duration(1200)
                .buildAndRegister();



    }
}
