package TJCore.api.material;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;

import static gregtech.api.unification.material.info.MaterialFlags.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    //Alloys
    public static Material BT6;
    public static Material Birmabright;
    public static Material NickelPlatedTin;

    //Chemicals
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

    // Cermaics + Glass
    public static Material SilicaCeramic;
    public static Material ZBLAN;
    public static Material Fiberglass;

    // Metals

    // Polymers
    public static Material Ladder_Poly_P_Phenylene;
    public static Material Kapton_K;

    // Mixtures
    public static Material DiamondCVDSolution;

    public static Material P1Solution;
    public static Material TetrakisPDCatalyst;


    // Magic materials, unknown composition
    public static Material Draconium;
    public static Material Manasteel;
    public static Material Terrasteel;
    public static Material Thaumium;
    public static Material Void;
    public static Material ColdIron;
    public static Material Starmetal;
    public static Material Starlight;
    public static Material Salis;

}
