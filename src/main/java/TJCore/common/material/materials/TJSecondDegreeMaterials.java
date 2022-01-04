package TJCore.common.material.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import static TJCore.common.material.TJMaterials.*;


import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_PLATE;

public class TJSecondDegreeMaterials {
    public static void register(){

        BT6 = new  Material.Builder(32001, "bt6")
                .ingot()
                .colorAverage().iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE)
                .components(Iron,3, Carbon,1, Vanadium, 5, Titanium, 40, Aluminium, 6)
                .blastTemp(3400)
                .build();
    }

}
