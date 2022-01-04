package TJCore.common.material.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

import static TJCore.common.material.TJMaterials.*;


import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class TJSecondDegreeMaterials {
    public static void register(){
        BT6 = new Material.Builder(25000, "bt6")
                .ingot().fluid(Material.FluidType.FLUID)
                .colorAverage().iconSet(MaterialIconSet.SHINY)
                .flags(EXT2_METAL)
                .components(Iron,3, Carbon,1, Vanadium, 5, Titanium, 40, Aluminium, 6)
                .blastTemp(3400)
                .build();

        Birmabright = new Material.Builder(25001, "birmabright")
                .ingot().fluid(Material.FluidType.FLUID)
                .color(1755371).iconSet(MaterialIconSet.DULL)
                .flags(EXT2_METAL)
                .components(Aluminium, 5, Magnesium, 1, Manganese, 1)
                .build();
    }



}
