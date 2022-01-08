package TJCore.common.material.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;

import static TJCore.common.material.TJMaterials.*;


import static gregtech.api.unification.material.Materials.*;

public class TJFirstDegreeMaterials {

    /* for fluidpipeproperties, throughput is in ticks


    */


    public static void register(){
        Birmabright = new Material.Builder(25000, "birmabright")
                .ingot().fluid(Material.FluidType.FLUID)
                .color(1755371).iconSet(MaterialIconSet.DULL)
                .flags(SetMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING, STANDARDCASING))
                .components(Aluminium, 5, Magnesium, 1, Manganese, 1)
                .build();

        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);

        BT6 = new Material.Builder(25001, "bt6")
                .ingot().fluid(Material.FluidType.FLUID)
                .colorAverage().iconSet(MaterialIconSet.SHINY)
                .flags(SetMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING))
                .components(Iron,3, Carbon,1, Vanadium, 5, Titanium, 40, Aluminium, 6)
                .blastTemp(3400)
                .build();

        FluidPipeProperties bt6FluidPipeProps = new FluidPipeProperties(1500, 36, false);
        BT6.setProperty(PropertyKey.FLUID_PIPE, bt6FluidPipeProps);

        WireProperties BlueSteelWireProps = new WireProperties(512, 2, 6);
        BlueSteel.setProperty(PropertyKey.WIRE, BlueSteelWireProps);
        FluidPipeProperties bluesteelFluidPipeProps = new FluidPipeProperties(1500, 30, false);
        BlueSteel.setProperty(PropertyKey.FLUID_PIPE, bluesteelFluidPipeProps);

    }



}
