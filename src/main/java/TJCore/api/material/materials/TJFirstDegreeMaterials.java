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
                .setFormula("MoS2", true);


        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());

        PhenylmagnesiumBromide = new Material.Builder(25005,"phenylmagnesiumbromide")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 5, Magnesium, 1, Bromine, 1)
                .build()
                .setFormula("C6H5MgBr", true);

        Bromobenzene = new Material.Builder(25006,"bromobenzene")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 4, Bromine, 1)
                .build()
                .setFormula("C6H5Br",true);

        Draconium = new Material.Builder(25007, "draconium")
                .ingot().fluid()
                .color(0x573d85).iconSet(MaterialIconSet.DULL)
                .flags(SetMaterialFlags(STANDARDPLATE, STANDARDCASING))
                .build();

        SilicaCeramic = new Material.Builder(25008,"silicaceramic")
                .ingot()
                .blastTemp(1000)
                .color(0x8c7a50).iconSet(MaterialIconSet.SHINY)
                .flags(SetMaterialFlags(STANDARDPLATE,STANDARDROD,STANDARDFOIL,STANDARDROUND))
                .build();

        NickelPlatedTin = new Material.Builder(25009, "nickelplatedtin")
                .ingot()
                .color(0x8fb7c4).iconSet(MaterialIconSet.DULL)
                .flags(SetMaterialFlags(STANDARDFOIL))
                .build();

        ZBLAN = new Material.Builder(25010, "zblan")
                .ingot()
                .blastTemp(3600)
                .color(0x0e0e0).iconSet(MaterialIconSet.SHINY)
                .flags(SetMaterialFlags(STANDARDLENS,STANDARDFOIL,STANDARDWIREFINE))
                .build();

        //TODO: CARBON make the formula for ladder poly-p-phenylene
        Ladder_Poly_P_Phenylene = new Material.Builder(25011, "polypphenylene")
                .fluid()
                .ingot()
                .color(0xbfb393)
                .flags(SetMaterialFlags(STANDARDWIREFINE,STANDARDFOIL))
                .build();

        HydrogenSilsesquioxane = new Material.Builder(25012, "hydrogensilsesquioxane")
                .fluid()
                .color(0x471525)
                .build()
                .setFormula(" [HSiO3/2]", true);

        //TODO: CARBON make the formula for SU-8 Photoresist
        SU8_Photoresist = new Material.Builder(25013, "su_photoresist")
                .fluid()
                .color(0x0e242b)
                .build();
        Fiberglass = new Material.Builder(25014, "fiberglass")
                .ingot()
                .color(0x99c0cf)
                .build();

        LuminescentSiliconNanocrystals = new Material.Builder(25015,"luminescentsiliconnanocrystals")
                .dust()
                .color(0x363636)
                .build();

        SeleniumMonobromide = new Material.Builder(25016, "seleniummonobromide")
                .fluid()
                .color(0x472a1a)
                .build();

        DiamondCVDSolution = new Material.Builder(25017, "diamondcvdsolution")
                .fluid()
                .color(0x65b1fc)
                .build();

        Kapton_K = new Material.Builder(25018,"kaptonk")
                .fluid()
                .ingot()
                .iconSet(MaterialIconSet.DULL)
                .color(0xb7c474)
                .build();

        Starlight = new Material.Builder(25019, "starlight")
                .fluid()
                .color(0xebfafc)
                .iconSet(MaterialIconSet.SHINY)
                .build();

    }

    public static void registerProperties() {

        Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty());

        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false, true, false, false);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);

        FluidPipeProperties silicaCeramicFluidPipeProps = new FluidPipeProperties(1000, 18, false, false, false, false);
        SilicaCeramic.setProperty(PropertyKey.FLUID_PIPE, silicaCeramicFluidPipeProps);

        FluidPipeProperties bt6FluidPipeProps = new FluidPipeProperties(1500, 36, false, true, false, false);
        BT6.setProperty(PropertyKey.FLUID_PIPE, bt6FluidPipeProps);

        WireProperties BlueSteelWireProps = new WireProperties(512, 2, 6);
        BlueSteel.setProperty(PropertyKey.WIRE, BlueSteelWireProps);
        FluidPipeProperties bluesteelFluidPipeProps = new FluidPipeProperties(1500, 30, false, true, false, false);
        BlueSteel.setProperty(PropertyKey.FLUID_PIPE, bluesteelFluidPipeProps);

        // Glass + Ceramics
        Fiberglass.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FOIL);

        // Polymers
        Polybenzimidazole.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        PolyphenyleneSulfide.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Polytetrafluoroethylene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        PolyvinylChloride.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Polyethylene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        ReinforcedEpoxyResin.addFlags(MaterialFlags.GENERATE_FOIL);
        Kapton_K.addFlags(MaterialFlags.GENERATE_FOIL);

        // Metals
        TinAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);

        // becuase of techs foolishness and thinking graphenes are a foil
        Graphene.addFlags(MaterialFlags.GENERATE_FOIL);

    }

}
