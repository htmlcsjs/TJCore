package TJCore.api;

import TJCore.common.metaitem.TJMetaItems;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
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
    public static Component SUBSTRATE;
    public static Component BUS_SPRING;
    public static Component POWER_IC;
    public static Component RING;

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

        SUBSTRATE = new Component(Stream.of(new Object[][]{

                {1, new UnificationEntry(plate, Polyethylene)},
                {2, new UnificationEntry(plate, Polyethylene)},
                {3, new UnificationEntry(plate, Polyethylene)},
                {4, new UnificationEntry(plate, Polyethylene)},
                {5, new UnificationEntry(plate, Polyethylene)},
                {6, new UnificationEntry(plate, Polytetrafluoroethylene)},
                {7, new UnificationEntry(plate, Polytetrafluoroethylene)},
                {8, new UnificationEntry(plate, Polytetrafluoroethylene)},
                {9, new UnificationEntry(plate, Polytetrafluoroethylene)},
                {10, TJMetaItems.CARBON_FIBER_PLATE},
                {11, TJMetaItems.CARBON_FIBER_PLATE},
                {12, TJMetaItems.CARBON_FIBER_PLATE},
                {13, TJMetaItems.CARBON_FIBER_PLATE},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        //TODO: Replace 9-13 with high tier batteries or similar.

        POWER_IC = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(springSmall, Lead)},
                {1, new UnificationEntry(springSmall, Tin)},
                {2, new UnificationEntry(springSmall, Copper)},
                {3, new UnificationEntry(springSmall, Gold)},
                {4, MetaItems.ULTRA_LOW_POWER_INTEGRATED_CIRCUIT},
                {5, MetaItems.LOW_POWER_INTEGRATED_CIRCUIT},
                {6, MetaItems.POWER_INTEGRATED_CIRCUIT},
                {7, MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT},
                {8, MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT},
                {9, TJMetaItems.CARBON_FIBER_PLATE},
                {10, TJMetaItems.CARBON_FIBER_PLATE},
                {11, TJMetaItems.CARBON_FIBER_PLATE},
                {12, TJMetaItems.CARBON_FIBER_PLATE},
                {13, TJMetaItems.CARBON_FIBER_PLATE},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        RING = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(ring, WroughtIron)},
                {1, new UnificationEntry(ring, GalvanizedSteel)},
                {2, new UnificationEntry(ring, Aluminium)},
                {3, new UnificationEntry(ring, StainlessSteel)},
                {4, new UnificationEntry(ring, Titanium)},
                {5, new UnificationEntry(ring, TungstenSteel)},
                {6, new UnificationEntry(ring, LutetiumTantalate)},
                {7, new UnificationEntry(ring, Iridrhodruthenium)},
                {8, new UnificationEntry(ring, Tritanium)},
                {9, new UnificationEntry(ring, EnrichedNaqAlloy)},
                {10, new UnificationEntry(ring, HDCS_1)},
                {11, new UnificationEntry(ring, HDCS_2)},
                {12, new UnificationEntry(ring, HDCS_3)},
                {13, new UnificationEntry(ring, SuperheavyL)},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CraftingComponent.HULL_PLATE.appendIngredients(Stream.of(new Object[][]{
                {0, new UnificationEntry(plate, WroughtIron)},
                {1, new UnificationEntry(plate, GalvanizedSteel)},
                {2, new UnificationEntry(plate, Aluminium)},
                {3, new UnificationEntry(plate, StainlessSteel)},
                {4, new UnificationEntry(plate, Titanium)},
                {5, new UnificationEntry(plate, TungstenSteel)},
                {6, new UnificationEntry(plate, LutetiumTantalate)},
                {7, new UnificationEntry(plate, Iridrhodruthenium)},
                {8, new UnificationEntry(plate, Tritanium)},
                {9, new UnificationEntry(plate, HEA_3)},
                {10, new UnificationEntry(plate, Adamantium)},
                {11, new UnificationEntry(plate, Vibranium)},
                {12, new UnificationEntry(plate, ProgrammableMatter)},
                {13, new UnificationEntry(plate, HeavyQuarkDegenerate)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CraftingComponent.CABLE.appendIngredients(Stream.of(new Object[][]{
                {0, new UnificationEntry(cableGtSingle, Lead)},
                {1, new UnificationEntry(cableGtSingle, Tin)},
                {2, new UnificationEntry(cableGtSingle, Copper)},
                {3, new UnificationEntry(cableGtSingle, Gold)},
                {4, new UnificationEntry(cableGtSingle, Aluminium)},
                {5, new UnificationEntry(cableGtSingle, Platinum)},
                {6, new UnificationEntry(cableGtSingle, NiobiumTitanium)},
                {7, new UnificationEntry(cableGtSingle, VanadiumGallium)},
                {8, new UnificationEntry(cableGtSingle, YttriumBariumCuprate)},
                {9, new UnificationEntry(cableGtSingle, Pikyonium)},
                {10, new UnificationEntry(cableGtSingle, PedotTMA)},
                {11, new UnificationEntry(cableGtSingle, NihoniumTriiodide)},
                {12, new UnificationEntry(cableGtSingle, Taranium)},
                {13, new UnificationEntry(cableGtSingle, OganessonTetraTennesside)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        BUS_SPRING = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(spring, Lead)},
                {1, new UnificationEntry(spring, Steel)},
                {2, new UnificationEntry(spring, Aluminium)},
                {3, new UnificationEntry(spring, StainlessSteel)},
                {4, new UnificationEntry(spring, Titanium)},
                {5, new UnificationEntry(spring, TungstenSteel)},
                {6, new UnificationEntry(spring, HSSG)},
                {7, new UnificationEntry(spring, HSSE)},
                {8, new UnificationEntry(spring, HSSS)},
                {9, new UnificationEntry(spring, NaquadahAlloy)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
