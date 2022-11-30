package TJCore.api.material;
import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;

import static gregtech.api.unification.material.info.MaterialFlags.*;

import java.util.*;


public class TJMaterials {

    public static List<MaterialFlag> STANDARDPLATE = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES));
    public static List<MaterialFlag> STANDARDWIREFINE = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FINE_WIRE));
    public static List<MaterialFlag> STANDARDFOIL = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FOIL));
    public static List<MaterialFlag> STANDARDROD = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW));
    public static List<MaterialFlag> STANDARDROTOR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROTOR, GENERATE_RING));
    public static List<MaterialFlag> STANDARDGEAR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_GEAR, GENERATE_SMALL_GEAR));
    public static List<MaterialFlag> STANDARDSPRING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_SPRING, GENERATE_SPRING_SMALL));
    public static List<MaterialFlag> STANDARDROUND = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROUND));
    public static List<MaterialFlag> STANDARDLENS = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS));

    public static List<MaterialFlag> STANDARDCASING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FRAME));
    public static List<MaterialFlag> STANDARDGEM = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS, HIGH_SIFTER_OUTPUT));

    @SafeVarargs
    public static List<MaterialFlag> SetMaterialFlags(List<MaterialFlag>... materials) {
        List<MaterialFlag> result = new ArrayList<MaterialFlag>();
        for(List<MaterialFlag> x : materials) {
            result.addAll(x);
        }
        return result;
    }

    //Isotopes
    public static final Element Co60 = Elements.add(27L, 33L, -1L, (String)null, "Cobalt-60", "Co-60", true);
    public static Material Cobalt60;

    //Alloys
    public static Material BT6;
    public static Material Birmabright;
    public static Material NickelPlatedTin;
    public static Material DegenerateRhenium;
    public static Material NihoniumTriiodide;
    public static Material SuperheavyH;
    public static Material SuperheavyL;
    public static Material EnrichedNaqAlloy;
    public static Material TriniumSteel;
    public static Material TerfenolD_H;
    public static Material TerfenolD_L;
    public static Material GalvanizedSteel;
    public static Material LutetiumTantalate;
    public static Material Iridrhodruthenium;
    public static Material HEA_1;
    public static Material HEA_2;
    public static Material HEA_3;
    public static Material HDCS_1;
    public static Material HDCS_2;
    public static Material HDCS_3;
    public static Material Pikyonium;
    public static Material TantalumCarbide;
    public static Material HafniumCarbide;
    public static Material SeaborgiumCarbide;
    public static Material TantalumHafniumSeaborgiumCarbide;
    public static Material TantalumHafniumSeaborgiumCarboNitride;
    public static Material OganessonTetraTennesside;

    //Soldering Alloys
    public static Material SolderingAlloyI;
    public static Material SolderingAlloyII;
    public static Material SolderingAlloyIII;
    public static Material SolderingAlloyIV;
    public static Material SolderingAlloyV;
    public static Material SolderingAlloyVI;
    public static Material FritSolderMix;
    public static Material SolderVPrep;
    public static Material SolderVPrepClean;
    public static Material SolderVStruct;
    public static Material IndiumRadium;
    public static Material IndiumRadiumRadon;
    public static Material PilledFoilMix;
    public static Material IrradiatingMix;
    public static Material SolderVIPrep;


    //Chemicals
    public static Material Methyltrichlorosilane;
    public static Material Methyltrimethoxysilane;
    public static Material Polymethylsilesquioxane;
    public static Material Silane;
    public static Material TriphenylPhosphine;
    public static Material PhenylmagnesiumBromide;
    public static Material Bromobenzene;
    public static Material HydrogenSilsesquioxane;
    public static Material SU8_Photoresist;
    public static Material MolybdenumSulfide;
    public static Material Difluoroethane; //C2H4F2
    public static Material PalladiumChloride; // PdCl2
    public static Material AllylAcetate;
    public static Material SilverLeadOxide;
    public static Material LuminescentSiliconNanocrystals;
    public static Material SeleniumMonobromide;
    public static Material HydraziniumChloride;
    public static Material DibromoisophthalicAcid;
    public static Material Dibromoterephthaloyldichloride;
    public static Material HafniumSilicate;
    public static Material GraphenePQD;
    public static Material BismuthIridiumOxide;
    public static Material IndiumFluoride;
    public static Material XenonDioxide;
    public static Material XenonTetraFluoride;
    public static Material XenonOxyTetraFluoride;
    public static Material XenonHexaFluoride;
    public static Material NeonFluoride;
    public static Material ExcitedNeonFluoride;
    public static Material ArgonFluorine;
    public static Material SilverGalliumSelenide;

    // Cermaics + Glass
    public static Material SodiumPotassiumNiobate;
    public static Material BismuthTelluride;
    public static Material SilicaCeramic;
    public static Material Fiberglass;
    public static Material SynthDiamond;
    public static Material LeadZirconateTitanate;
    public static Material BismuthPhosphomolybdate;
    public static Material Acrylonitrile;
    public static Material SodiumThiocyanate;
    public static Material SodiumThiocyanatePolymerizationSolution;
    public static Material Cellulose;

    // Metals

    // Polymers
    public static Material Polyacrylonitrile;
    public static Material Polyetheretherketone;
    public static Material CarbonNanotubePolymer;
    public static Material Ladder_Poly_P_Phenylene;



    // Mixtures
    public static Material SuspendedPGQD;
    public static Material ArgonSilane;
    public static Material DiamondCVDSolution;
    public static Material XenonFluorideSupercondiveMix;
    public static Material P1Solution;
    public static Material TetrakisPDCatalyst;
    public static Material CFCoatingSolution;

    // Magic materials, unknown composition
    public static Material Draconium;
    public static Material Manasteel;
    public static Material Terrasteel;
    public static Material Thaumium;
    public static Material Void;
    public static Material ColdIron;
    public static Material Starmetal;
    public static Material ManasteelAlloy;
    public static Material Starlight;
    public static Material Salis;

    //endgame unknown
    public static Material ProgrammableMatter;
    public static Material Gluons;
    public static Material HeavyQuarks;
    public static Material LightQuarks;
    public static Material Leptons;
    public static Material HeavyQuarkDegenerate;
}
