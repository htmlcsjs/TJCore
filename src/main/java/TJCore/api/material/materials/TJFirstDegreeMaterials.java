package TJCore.api.material.materials;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.unification.crafttweaker.CTMaterialBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;
import gregtech.loaders.recipe.handlers.WireCombiningHandler;
import net.minecraftforge.fluids.Fluid;
import org.apache.http.impl.conn.Wire;
import scala.sys.Prop;

import java.util.ArrayList;

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
                .dust()
                .fluid()
                .colorAverage()
                .components(Phosphorus, 1, Carbon, 18, Hydrogen, 15)
                .build()
                .setFormula("P(C6H5)3", true);

        MolybdenumSulfide = new Material.Builder(25004, "molybdenumsulfide")
                .fluid()
                .colorAverage()
                .components(Molybdenum, 1, Sulfur, 2)
                .build()
                .setFormula("MoS2", true);

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
                .fluid()
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
                .setFormula("[HSiO3/2]", true);

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

        Starlight = new Material.Builder(25019, "starlight")
                .fluid()
                .color(0xebfafc)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SilverLeadOxide = new Material.Builder(25020, "silverleadoxide")
                .dust()
                .colorAverage()
                .components(Silver, 1, Lead, 1, Oxygen, 1)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        PalladiumChloride = new Material.Builder(25021, "palladiumchloride")
                .dust()
                .colorAverage()
                .components(Palladium, 1, Chlorine, 2)
                .build()
                .setFormula("PdCl2",true);

        TetrakisPDCatalyst = new Material.Builder(25022, "tretrakispdcatalyst")
                .dust()
                .color(0x9bd1e8)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        HydraziniumChloride = new Material.Builder(25023, "hydraziniumchloride")
                .fluid()
                .colorAverage()
                .components(Nitrogen, 2, Hydrogen, 5, Chlorine, 1)
                .build()
                .setFormula("N2H4HCl", true);

        DibromoisophthalicAcid = new Material.Builder(25024, "dibromoisophthalicacid")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 5, Bromine, 1, Oxygen, 4)
                .build()
                .setFormula("C8H5BrO4",true);

        Dibromoterephthaloyldichloride = new Material.Builder(25025, "dibromoterephthaloyldichloride")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 2, Bromine, 2, Chlorine, 2, Oxygen, 2)
                .build()
                .setFormula("C8H2Br2Cl2O2",true);

        P1Solution = new Material.Builder(25026, "p_one_solution")
                .fluid()
                .color(0x6b0c05)
                .build();

        HafniumSilicate = new Material.Builder(25027, "hafnium_silicate")
                .dust()
                .colorAverage()
                .components(Hafnium, 1, Oxygen, 4, Silicon, 1)
                .build()
                .setFormula("HfO4Si", true);

        Cobalt60 = new Material.Builder(25028,"cobalt_sixty")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .color(Cobalt.getMaterialRGB())
                .build()
                .setFormula("Co-60", false);

        FritSolderMix = new Material.Builder(25035,"glass_frit_solder_mixture")
                .dust()
                .colorAverage()
                .components(Glass, 36, Yttrium, 1, Copper, 3)
                .build()
                .setFormula("(SiO2)36Cu3Y1", true);

        SolderVPrep = new Material.Builder(25036, "solder_v_prep")
                .dust()
                .colorAverage()
                .components(Tin, 2, Gold, 1, Bismuth, 1)
                .build()
                .setFormula("Sn2AuBi",true);

        SolderVPrepClean = new Material.Builder(25037, "solder_v_prep_clean")
                .dust()
                .colorAverage()
                .components(SolderVPrep, 1)
                .build()
                .setFormula("Sn2AuBi", true);

        SolderVStruct = new Material.Builder(25038, "solder_v_prestructure")
                .dust()
                .colorAverage()
                .components(SolderVPrepClean, 9, Lanthanum, 1, Cerium, 1)
                .build()
                .setFormula("(Sn2AuBi)9LaCe",true);

        IndiumRadium = new Material.Builder(25039, "indium_radium")
                .dust()
                .colorAverage()
                .components(Indium, 6, Radium, 2)
                .build()
                .setFormula("In6Ra4", true);

        IndiumRadiumRadon = new Material.Builder(25040, "indium_radium_radon")
                .dust()
                .colorAverage()
                .components(Indium, 6, Radium, 2, Radon, 2)
                .build()
                .setFormula("In6Ra2Rn2",true);

        PilledFoilMix = new Material.Builder(25041, "pilled_foil_mix")
                .dust()
                .colorAverage()
                .components(Ruthenium, 2, Gold, 2, Copper, 2, Lutetium, 2)
                .build()
                .setFormula("Ru2Au2Cu2Lu2", true);

        IrradiatingMix = new Material.Builder(25042, "irradiating_mixture")
                .dust()
                .colorAverage()
                .components(IndiumRadiumRadon, 2, PilledFoilMix, 2, Cobalt60, 3)
                .build();

        SolderVIPrep = new Material.Builder(25043, "solder_vi_prep")
                .dust()
                .colorAverage()
                .components(IrradiatingMix, 8, Tritanium, 1, Moscovium, 1)
                .build();


        Silane = new Material.Builder(25045, "silane")
                .fluid()
                .colorAverage()
                .components(Silicon, 1, Hydrogen, 4)
                .build()
                .setFormula("SiH4", true);

        ArgonSilane = new Material.Builder(25044, "argon_silane")
                .fluid()
                .plasma()
                .components(Argon, 1, Silane, 1)
                .color(0x24BB18)
                .build();

        SolderingAlloyI = new Material.Builder(25029, "soldering_alloy_i")
                .fluid()
                .ingot()
                .colorAverage()
                .components(Lead, 6, Tin, 4)
                .build()
                .setFormula("Pb4Sn4", true);
        SolderingAlloyII = new Material.Builder(25030, "soldering_alloy_ii")
                .fluid()
                .ingot()
                .colorAverage()
                .components(Tin,6,Silver,3,Antimony,1)
                .build()
                .setFormula("Sn6Ag3Sb", true);
        SolderingAlloyIII = new Material.Builder(25031, "soldering_alloy_iii")
                .fluid()
                .ingot()
                .colorAverage()
                .components(FritSolderMix, 9, Zinc, 1)
                .build()
                .setFormula("((SiO2)36Cu3Y1)9Zn", true);
        SolderingAlloyIV = new Material.Builder(25032, "soldering_alloy_iv")
                .fluid()
                .ingot()
                .colorAverage()
                .components(IndiumGalliumPhosphide, 6, Bismuth, 2, Tellurium, 1, Platinum, 1)
                .build()
                .setFormula("", true);
        SolderingAlloyV = new Material.Builder(25033, "soldering_alloy_v")
                .fluid()
                .ingot()
                .colorAverage()
                .iconSet(MaterialIconSet.BRIGHT)
                .components(SolderVStruct, 11, SiliconCarbide, 3, NiobiumTitanium, 2)
                .build()
                .setFormula("((Sn2AuBi)9LaCe)11(SiC)3(Nb3Ti)2", true);
        SolderingAlloyVI = new Material.Builder(25034, "soldering_alloy_vi")
                .fluid()
                .ingot()
                .colorAverage()
                .iconSet(MaterialIconSet.SHINY)
                .components(SolderVIPrep, 1, ArgonSilane, 4)
                .build();

        CarbonNanotubePolymer = new Material.Builder(25046, "carbon_nanotube_polymer")
                .dust()
                .ingot()
                .color(0x0d0d0d)
                .iconSet(MaterialIconSet.SHINY)
                .components(CarbonNanotube, 5, Kevlar, 2)
                .build();

        DegenerateRhenium = new Material.Builder(25047, "degenerate_rhenium")
                .dust()
                .ingot()
                .color(0xc9c9c9)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rhenium, 1)
                .build();

        NihoniumTriiodide = new Material.Builder(25048, "nihonium_triiodide")
                .dust()
                .ingot()
                .color(0x5986a8)
                .iconSet(MaterialIconSet.SHINY)
                .components(Nihonium, 1, Iodine, 3)
                .build();

        SuperheavyL = new Material.Builder(25049, "superheavy_l")
                .dust()
                .ingot()
                .colorAverage()
                .iconSet(MaterialIconSet.SHINY)
                .components(Nobelium, 1, Lawrencium, 1, Meitnerium, 1, Darmstadtium, 1, Roentgenium, 1, Copernicium, 1)
                .build();

        SuperheavyH = new Material.Builder(25050, "superheavy_h")
                .dust()
                .ingot()
                .colorAverage()
                .iconSet(MaterialIconSet.SHINY)
                .components(Nihonium, 1, Flerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, Oganesson, 1)
                .build();

        Gluons = new Material.Builder(25051, "gluons")
                .fluid()
                .color(0xffffff)
                .build();

        LightQuarks = new Material.Builder(25052, "light_quarks")
                .fluid()
                .color(0x59ff7d)
                .build();

        HeavyQuarks = new Material.Builder(25053, "heavy_quarks")
                .fluid()
                .color(0x4a080b)
                .build();
    }

    public static void registerProperties() {

        Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty());

        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false, true, false, false);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);

        FluidPipeProperties silicaCeramicFluidPipeProps = new FluidPipeProperties(1000, 18, false, false, false, false);
        SilicaCeramic.setProperty(PropertyKey.FLUID_PIPE, silicaCeramicFluidPipeProps);
        SilicaCeramic.addFlags(MaterialFlags.NO_WORKING,MaterialFlags.NO_SMELTING,MaterialFlags.NO_SMASHING);

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
        ZBLAN.addFlags(MaterialFlags.GENERATE_FRAME);
        PedotPSS.addFlags(MaterialFlags.GENERATE_FRAME);
        PedotTMA.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        CarbonNanotubePolymer.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.NO_WORKING);

        // Metals
        VanadiumGallium.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        TinAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Dysprosium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FRAME);
        Vibranium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_BOLT_SCREW);

        WireProperties NihoniumTriiodideProp = new WireProperties(134217728, 2, 64);
        NihoniumTriiodide.setProperty(PropertyKey.WIRE, NihoniumTriiodideProp);
        NihoniumTriiodide.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING);
        Nihonium.addFlags(MaterialFlags.GENERATE_PLATE);
        WireProperties SuperheavyHProp = new WireProperties(536870912, 4, 128);
        SuperheavyH.setProperty(PropertyKey.WIRE, SuperheavyHProp);
        SuperheavyH.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_BOLT_SCREW);
        SuperheavyL.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_BOLT_SCREW);
        WireProperties NeutroniumProp = new WireProperties(2147483647, 4,0);
        Neutronium.setProperty(PropertyKey.WIRE, NeutroniumProp);
        Neutronium.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FOIL);

        // becuase of techs foolishness and thinking graphenes are a foil
        Graphene.addFlags(MaterialFlags.GENERATE_FOIL);

    }

}
