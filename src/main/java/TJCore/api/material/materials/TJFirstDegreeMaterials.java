package TJCore.api.material.materials;

import static TJCore.api.TJOreDictionaryLoader.GENERATE_NANOFOIL;
import static TJCore.api.TJOreDictionaryLoader.GENERATE_NANOWIRE;
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
import org.codehaus.plexus.util.Os;
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
                .color(0x000a8f)
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

        BismuthTelluride = new Material.Builder(25054, "bismuth_telluride")
                .ingot()
                .colorAverage()
                .components(Bismuth, 2, Tellurium, 3)
                .build();

        SynthDiamond = new Material.Builder(25055, "synthetic_diamond")
                .dust()
                .gem()
                .color(0x8fbaff)
                .components(Carbon, 8)
                .build();

        GraphenePQD = new Material.Builder(25056, "photoluminescent_graphene_quantum_dots")
                .dust()
                .color(0x616161)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 6)
                .build();

        HeavyQuarkDegenerate = new Material.Builder(25057, "heavy_quark_degenerate_matter")
                .fluid()
                .ingot()
                .color(0x171717)
                .components(Gluons, 1, HeavyQuarks, 4, LightQuarks, 1)
                .build();

        BismuthIridiumOxide = new Material.Builder(25058, "bismuth_iridium_oxide")
                .ingot()
                .colorAverage()
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .iconSet(MaterialIconSet.DULL)
                .build();

        IndiumFluoride = new Material.Builder(25059, "indium_fluoride")
                .fluid()
                .color(0x2d5c53)
                .components(Indium, 1, Fluorine, 3)
                .build();

        EnrichedNaqAlloy = new Material.Builder(25060, "enriched_naquadah_alloy")
                .ingot()
                .fluid()
                .colorAverage()
                .components(NaquadahEnriched, 16, Einsteinium, 4, Rhodium, 4, Technetium, 4, Astatine, 2, Erbium, 2)
                .blastTemp(9700)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SodiumPotassiumNiobate = new Material.Builder(25061, "sodium_potassium_niobate")
                .ingot()
                .colorAverage()
                .components(Sodium, 1, Potassium, 1, Niobium, 2, Oxygen, 6)
                .blastTemp(3600)
                .build();

        TriniumSteel = new Material.Builder(25062, "trinium_steel")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(10200)
                .colorAverage()
                .components(Trinium, 18, Tungsten, 6, Vanadium, 4, Chrome, 2, Tantalum, 1, Cobalt, 1)
                .build();

        LeadZirconateTitanate = new Material.Builder(25063, "lead_zirconate_titanate")
                .ingot()
                .iconSet(MaterialIconSet.DULL)
                .blastTemp(6100)
                .color(0x355232)
                .components(Lead, 12, Titanium, 1, Zirconium, 1, Oxygen, 16)
                .build();

        XenonFluorideSupercondiveMix = new Material.Builder(25064, "xenon_fluoride_mix")
                .fluid()
                .color(0x251a33)
                .build();


        XenonOxyTetraFluoride = new Material.Builder(25065, "xenon_oxytetrafluoride")
                .fluid()
                .colorAverage()
                .components(Xenon, 1, Oxygen, 1, Fluorine, 4)
                .build();

        XenonDioxide = new Material.Builder(25066, "xenon_dioxide")
                .fluid()
                .colorAverage()
                .components(Xenon, 1, Oxygen, 2)
                .build();

        XenonTetraFluoride = new Material.Builder(25067, "xenon_tetrafluoride")
                .fluid()
                .color(0x3d1e42)
                .components(Xenon, 1, Fluorine, 4)
                .build();
        XenonHexaFluoride = new Material.Builder(25068, "xenon_hexafluoride")
                .fluid()
                .color(0x8d5cff)
                .components(Xenon, 1, Fluorine, 6)
                .build();

        TerfenolD_H = new Material.Builder(25069, "terfenol_d_heavy")
                .ingot()
                .blastTemp(10200)
                .components(Osmium, 12, Iron, 6, Dysprosium, 2, Terbium, 1)
                .color(0x4d4d4d)
                .build();

        TerfenolD_L = new Material.Builder(25070, "terfenol_d_light")
                .ingot()
                .blastTemp(10200)
                .components(Lithium7, 12, Iron, 6, Dysprosium, 2, Terbium, 1)
                .color(0x9c9c9c)
                .build();

        SuspendedPGQD = new Material.Builder(25071, "suspended_pgqd")
                .fluid()
                .color(0x65ad95)
                .components(Krypton, 1, GraphenePQD, 1)
                .build();

        Leptons = new Material.Builder(25072, "leptons")
                .fluid()
                .color(0x5500ff)
                .build();

        NeonFluoride = new Material.Builder(25073, "neon_fluoride")
                .fluid()
                .colorAverage()
                .components(Neon, 1, Fluorine, 1)
                .build();

        ExcitedNeonFluoride = new Material.Builder(25074, "excited_neon_fluoride")
                .fluid()
                .colorAverage()
                .color(NeonFluoride.getMaterialRGB())
                .components(NeonFluoride, 1)
                .build();

        ArgonFluorine = new Material.Builder(25075, "argon_fluorine")
                .fluid()
                .color(0x00ff88)
                .components(Argon, 1, Fluorine, 1)
                .build();

        SilverGalliumSelenide = new Material.Builder(25076, "silver_gallium_selenide")
                .dust()
                .colorAverage()
                .components(Silver, 1, Gallium, 1, Selenium, 2)
                .build();

        BismuthPhosphomolybdate = new Material.Builder(25077, "bismuth_phosphomolybdate")
                .dust()
                .colorAverage()
                .components(Bismuth, 9, Phosphorus, 1, Molybdenum, 12, Oxygen, 52)
                .build();

        Acrylonitrile = new Material.Builder(25078, "acrylonitrile")
                .fluid()
                .color(0x565734)
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .build()
                .setFormula("CH2CHCN", true);

        SodiumThiocyanate = new Material.Builder(25079, "sodium_thiocyanate")
                .dust()
                .colorAverage()
                .components(SodiumCyanide, 1, Sulfur, 1)
                .build();

        SodiumThiocyanatePolymerizationSolution = new Material.Builder(25080, "sodiumthiocyanatepolymerizationsolution")
                .fluid()
                .colorAverage()
                .components(Water, 1, SodiumThiocyanate, 1)
                .build();

        Polyacrylonitrile = new Material.Builder(25081, "polyacrylonitrile")
                .dust()
                .color(0x854218)
                .build();

        CFCoatingSolution = new Material.Builder(25082, "cf_coating_solution")
                .fluid()
                .colorAverage()
                .components(PolyvinylChloride, 1, Polyethylene, 1)
                .build();
    }

    public static void registerProperties() {

        // Glass + Ceramics
        SilicaCeramic.addFlags(MaterialFlags.NO_WORKING,MaterialFlags.NO_SMELTING,MaterialFlags.NO_SMASHING, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_FOIL);
        Fiberglass.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FOIL);
        BismuthTelluride.addFlags(MaterialFlags.GENERATE_FOIL);
        BismuthIridiumOxide.addFlags(MaterialFlags.NO_WORKING, MaterialFlags.NO_SMASHING, MaterialFlags.GENERATE_PLATE);
        SodiumPotassiumNiobate.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_ROUND);
        LeadZirconateTitanate.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_RING);

        // Polymers
        Polybenzimidazole.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        PolyphenyleneSulfide.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Polytetrafluoroethylene.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_LONG_ROD);
        PolyvinylChloride.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Polyethylene.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        ReinforcedEpoxyResin.addFlags(MaterialFlags.GENERATE_FOIL);
        PedotPSS.addFlags(MaterialFlags.GENERATE_FRAME);
        PedotTMA.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        CarbonNanotubePolymer.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_PLATE, MaterialFlags.NO_WORKING, MaterialFlags.NO_SMASHING, MaterialFlags.NO_SMELTING);
        PolyvinylButyral.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_RING);
        Epoxy.addFlags(MaterialFlags.GENERATE_FOIL);

        // Metals
        VanadiumGallium.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        TinAlloy.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Dysprosium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FRAME);
        Vibranium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_BOLT_SCREW, GENERATE_NANOFOIL);
        RhodiumPlatedPalladium.addFlags(MaterialFlags.GENERATE_FRAME);
        Duranium.addFlags(MaterialFlags.GENERATE_FRAME, GENERATE_NANOFOIL);
        NihoniumTriiodide.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING);
        Nihonium.addFlags(MaterialFlags.GENERATE_PLATE, GENERATE_NANOWIRE);
        SuperheavyH.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_BOLT_SCREW);
        SuperheavyL.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_BOLT_SCREW);
        Neutronium.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_ROUND);
        HeavyQuarkDegenerate.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_LONG_ROD, GENERATE_NANOWIRE, MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.NO_SMELTING, MaterialFlags.NO_SMASHING, MaterialFlags.NO_WORKING);
        Taranium.addFlags(MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_SPRING_SMALL, GENERATE_NANOWIRE);
        TriniumSteel.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_BOLT_SCREW);
        Fermium.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_SPRING_SMALL, GENERATE_NANOWIRE);
        Dubnium.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_FINE_WIRE, GENERATE_NANOWIRE);
        TerfenolD_L.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_ROTOR);
        TerfenolD_H.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_DENSE);
        EnrichedNaqAlloy.addFlags(MaterialFlags.GENERATE_DENSE, MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, MaterialFlags.GENERATE_BOLT_SCREW, MaterialFlags.GENERATE_RING, MaterialFlags.GENERATE_ROUND, MaterialFlags.GENERATE_FRAME);
        PolystyreneSulfonate.addFlags(MaterialFlags.GENERATE_FOIL);
        Nichrome.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_RING);
        PlutoniumPhosphide.addFlags(GENERATE_NANOFOIL);
        ZBLANGlass.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_BOLT_SCREW);
        ErbiumDopedZBLANGlass.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE);
        PraseodymiumDopedZBLANGlass.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_FINE_WIRE);
        Cobalt.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Carbon.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Osmium.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_SPRING, MaterialFlags.GENERATE_SPRING_SMALL);
        NeodymiumMagnetic.addFlags(MaterialFlags.GENERATE_FOIL, MaterialFlags.GENERATE_RING);
        Rutherfordium.addFlags(MaterialFlags.GENERATE_FOIL);

        //Properties
        PlasmaProperty HQDPlasmaProp = new PlasmaProperty();
        HeavyQuarkDegenerate.setProperty(PropertyKey.PLASMA, HQDPlasmaProp);
        IngotProperty TaraniumIngotProp = new IngotProperty();
        WireProperties TaraniumWireProp = new WireProperties(536870912, 2, 64);
        Taranium.setProperty(PropertyKey.INGOT, TaraniumIngotProp);
        Taranium.setProperty(PropertyKey.WIRE, TaraniumWireProp);
        WireProperties NihoniumTriiodideProp = new WireProperties(134217728, 2, 64);
        NihoniumTriiodide.setProperty(PropertyKey.WIRE, NihoniumTriiodideProp);
        WireProperties SuperheavyHProp = new WireProperties(536870912, 4, 128);
        SuperheavyH.setProperty(PropertyKey.WIRE, SuperheavyHProp);
        WireProperties NeutroniumProp = new WireProperties(2147483647, 4,0);
        Neutronium.setProperty(PropertyKey.WIRE, NeutroniumProp);
        FluidPipeProperties bt6FluidPipeProps = new FluidPipeProperties(1500, 36, false, true, false, false);
        BT6.setProperty(PropertyKey.FLUID_PIPE, bt6FluidPipeProps);
        WireProperties BlueSteelWireProps = new WireProperties(512, 2, 6);
        BlueSteel.setProperty(PropertyKey.WIRE, BlueSteelWireProps);
        FluidPipeProperties bluesteelFluidPipeProps = new FluidPipeProperties(1500, 30, false, true, false, false);
        BlueSteel.setProperty(PropertyKey.FLUID_PIPE, bluesteelFluidPipeProps);
        WireProperties EnrichedNaqAlloyProps = new WireProperties(2097152, 2, 48);
        EnrichedNaqAlloy.setProperty(PropertyKey.WIRE, EnrichedNaqAlloyProps);
        Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty());
        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false, true, false, false);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);
        FluidPipeProperties silicaCeramicFluidPipeProps = new FluidPipeProperties(1000, 18, false, false, false, false);
        SilicaCeramic.setProperty(PropertyKey.FLUID_PIPE, silicaCeramicFluidPipeProps);
        FluidPipeProperties PZTPipeProps = new FluidPipeProperties(3200, 46,false,true,true,false);
        LeadZirconateTitanate.setProperty(PropertyKey.FLUID_PIPE, PZTPipeProps);
        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Einsteinium.setProperty(PropertyKey.DUST, new DustProperty());
        Technetium.setProperty(PropertyKey.DUST, new DustProperty());
        Actinium.setProperty(PropertyKey.DUST, new DustProperty());
        Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        Carbon.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rutherfordium.setProperty(PropertyKey.DUST, new DustProperty());
        Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());


        // becuase of techs foolishness and thinking graphenes are a foile
        Graphene.addFlags(MaterialFlags.GENERATE_FOIL);
    }

}
