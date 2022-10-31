package TJCore.api;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.CraftingComponent;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static TJCore.api.material.TJMaterials.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.Taranium;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import gregtech.loaders.recipe.CraftingComponent.*;

public class TJComponents {
    public static void init() {
        CraftingComponent.ROTOR.appendIngredients(Stream.of(new Object[][]{
                {0, new UnificationEntry(rotor, Bronze)},
                {1, new UnificationEntry(rotor, GalvanizedSteel)},
                {2, new UnificationEntry(rotor, Aluminium)},
                {3, new UnificationEntry(rotor, StainlessSteel)},
                {4, new UnificationEntry(rotor, Titanium)},
                {5, new UnificationEntry(rotor, TungstenSteel)},
                {6, new UnificationEntry(rotor, RhodiumPlatedPalladium)},
                {7, new UnificationEntry(rotor, NaquadahAlloy)},
                {8, new UnificationEntry(rotor, Darmstadtium)},
                {9, new UnificationEntry(rotor, Orichalcum)},
                {10, new UnificationEntry(rotor, Adamantium)},
                {11, new UnificationEntry(rotor, Vibranium)},
                {12, new UnificationEntry(rotor, Taranium)},
                {13, new UnificationEntry(rotor, SuperheavyH)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
