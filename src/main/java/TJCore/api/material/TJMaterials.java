package TJCore.api.material;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.common.MetaFluids;

import static gregtech.api.unification.material.info.MaterialFlags.*;

import java.util.ArrayList;
import java.util.Arrays;


public class TJMaterials {

    public static ArrayList<MaterialFlag> STANDARDPLATE = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES));
    public static ArrayList<MaterialFlag> STANDARDFOIL = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FOIL));
    public static ArrayList<MaterialFlag> STANDARDROD = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW));
    public static ArrayList<MaterialFlag> STANDARDROTOR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROTOR, GENERATE_RING));
    public static ArrayList<MaterialFlag> STANDARDGEAR = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_GEAR, GENERATE_SMALL_GEAR));
    public static ArrayList<MaterialFlag> STANDARDSPRING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_SPRING, GENERATE_SPRING_SMALL));
    public static ArrayList<MaterialFlag> STANDARDROUND = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_ROUND));
    public static ArrayList<MaterialFlag> STANDARDLENS = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS));

    public static ArrayList<MaterialFlag> STANDARDCASING = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_FRAME));
    public static ArrayList<MaterialFlag> STANDARDGEM = new ArrayList<MaterialFlag>(Arrays.asList(GENERATE_LENS, HIGH_SIFTER_OUTPUT));

    @SafeVarargs
    public static ArrayList<MaterialFlag> SetMaterialFlags(ArrayList<MaterialFlag>... materials) {
        ArrayList<MaterialFlag> result = new ArrayList<MaterialFlag>();
        for(ArrayList<MaterialFlag> x : materials) {
            result.addAll(x);
        }
        return result;
    }

    //Primary
    public static Material BT6;
    public static Material Birmabright;

    //Chemicals
    public static Material TriphenylPhosphine;// PhosphorusTrichloride + PhenylmagnesiumBromide → TriphenylPhosphine + 3(Mg,Br,Cl)
    public static Material PhosphorusTrichloride; // P4 + 6 Cl2 → 4 PCl3
    public static Material PhenylmagnesiumBromide; // Bromobenzene + mg
    public static Material Bromobenzene; // Benzene + Bromine


    public static Material MolybdenumSulfide;
    public static Material Acetylene; // C2H2
    public static Material Difluoroethane; //C2H4F2

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
