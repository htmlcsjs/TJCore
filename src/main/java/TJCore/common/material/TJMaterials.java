package TJCore.common.material;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import static gregtech.api.unification.material.info.MaterialFlags.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    public static ArrayList<MaterialFlag> SetMaterialFlags(ArrayList<MaterialFlag>... materials) {
        ArrayList<MaterialFlag> result = new ArrayList<MaterialFlag>();
        for(ArrayList<MaterialFlag> x : materials) {
            result.addAll(x);
        }
        return result;
    }

    //Secondary
    public static Material BT6;
    public static Material Birmabright;
}
