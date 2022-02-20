package TJCore.api.material.materials;

import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;
import net.minecraftforge.fluids.Fluid;

import static TJCore.api.material.TJMaterials.*;


import static gregtech.api.unification.material.Materials.*;

public class TJFirstDegreeMaterials {

    /* for fluidpipeproperties, throughput is in ticks


    */


    public static void registerMaterials(){
        Birmabright = new Material.Builder(25000, "birmabright")
                .ingot().fluid()
                .color(1755371).iconSet(MaterialIconSet.DULL)
                .flags(SetMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING, STANDARDCASING))
                .components(Aluminium, 5, Magnesium, 1, Manganese, 1)
                .build();

        BT6 = new Material.Builder(25001, "bt_6")
                .ingot().fluid()
                .colorAverage().iconSet(MaterialIconSet.SHINY)
                .flags(SetMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING))
                .components(Iron, 3, Carbon, 1, Vanadium, 5, Titanium, 40, Aluminium, 6)
                .blastTemp(3400)
                .build();



        TriphenylPhosphine  = new Material.Builder(25002,"triphenylphosphine")
                .fluid()
                .colorAverage()
                .components(Phosphorus, 1, Carbon, 18, Hydrogen, 15)
                .build()
                .setFormula("P(C6H5)3", true);

        PhosphorusTrichloride = new Material.Builder(25003, "phosphorustrichloride")
                .fluid()
                .colorAverage()
                .components(Phosphorus, 1, Chlorine, 3)
                .build()
                .setFormula("PCl3", true);

        MolybdenumSulfide = new Material.Builder(25004, "molybdenumsulfide")
                .fluid()
                .colorAverage()
                .components(Molybdenum, 1, Sulfur, 2)
                .build()
                .setFormula("MoS2");



       Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());

        PhenylmagnesiumBromide = new Material.Builder(25005,"phenylmagnesiumbromide")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 5, Magnesium, 1, Bromine, 1)
                .build()
                .setFormula("C6H5MgBr");

        Bromobenzene = new Material.Builder(25006,"bromobenzene")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 4, Bromine, 1)
                .build()
                .setFormula("C6H5Br",true);




    }

    public static void registerProperties() {

        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);

        FluidPipeProperties bt6FluidPipeProps = new FluidPipeProperties(1500, 36, false);
        BT6.setProperty(PropertyKey.FLUID_PIPE, bt6FluidPipeProps);

        WireProperties BlueSteelWireProps = new WireProperties(512, 2, 6);
        BlueSteel.setProperty(PropertyKey.WIRE, BlueSteelWireProps);
        FluidPipeProperties bluesteelFluidPipeProps = new FluidPipeProperties(1500, 30, false);
        BlueSteel.setProperty(PropertyKey.FLUID_PIPE, bluesteelFluidPipeProps);

        Polyethylene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        TinAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);

        // becuase of techs foolishness and thinking graphenes are a foil
        Graphene.addFlags(MaterialFlags.GENERATE_FOIL);

    }





}
