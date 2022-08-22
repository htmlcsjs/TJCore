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

    //Primary
    public static Material BT6;
    public static Material Birmabright;

    public static Material Ladder_Poly_P_Phenylene;

    public static Material HydrogenSilsesquioxane;

    public static Material SU8_Photoresist;

    //Chemicals
    public static Material TriphenylPhosphine;// PhosphorusTrichloride + PhenylmagnesiumBromide → TriphenylPhosphine + 3(Mg,Br,Cl)
    public static Material PhosphorusTrichloride; // P4 + 6 Cl2 → 4 PCl3
    public static Material PhenylmagnesiumBromide; // Bromobenzene + mg
    public static Material Bromobenzene; // Benzene + Bromine
    public static Material Draconium;

    public static Material ZBLAN;

    public static Material SilicaCeramic;
    public static Material NickelPlatedTin;
    public static Material MolybdenumSulfide;
    public static Material Acetylene; // C2H2
    public static Material Difluoroethane; //C2H4F2

    public static Material AllylAcetate;


    // Magic materials, unknown composition
    public static Material Manasteel; // Fe50C + Salis
    public static Material Terrasteel;
    public static Material Thaumium; // TungstenSteel + Manasteel + salis?
    public static Material Void;
    public static Material ColdIron; // frozen molten iron?
    public static Material Starmetal; // Ax*Sx* (salis + space shit?)
    public static Material Starlight; // Ax*
    public static Material Salis; // ?

}
