package TJCore.common.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;

public class CircuitRecipes {

    /*
        CURRENT CIRCUIT PROGRESSION
            Primitive (steam)
            Electrical (lv)
            Integrated (mv)
            Micro (hv)
            Nano (ev)
            Imc (iv)
            Optical (luv)
            Quantum (zpm)

        OpV skews
        Uxv skews
        Uiv skews are wetware mainframe, quantum computer, planck assembly and cosmic processor
        Uev skews are bioware mainframe, wetware computer, quantum assembly and planck processor
        Uhv skews are crystal mainframe, bioware computer, wetware assembly and quantum processor
        Uv skews are optical mainframe, crystal computer, bioware assembly and wetware processor
        Zpm skews are imc mainframe, optical computer, crystal assembly and bioware processor
        Luv skews are nano mainframe, imc computer, optical assembly and crystal processor
        Iv skews are micro mainframe, nano computer, imc assembly and optical processor
        Ev skews are integrated mainframe, micro computer, nano assembly and imc processor
        Hv skews are electronic mainframe, integrated computer, micro assembly and nano processor
        Mv are primitive mainframe, electronic computer, integrated assembly and micro processor
        Lv is primitive computer, electronic assembly and integrated processor
        Ulv is primitive assembly and electronic processor
    */
    /*
        mainframes should have some kinda heatsink component


     */

    public static void removePreexistingCircuits() {

    }

    public static void PrimitiveElectronicIntegratedLines() {
        // board, wires, vacuum tubes, resistor(non smd)

        //  RVR
        //  WBW
        //  #V#

        ModHandler.addShapedRecipe("primitive_assembly", );
    }

    public static void MicroLine() {

    }

    public static void NanoLine() {

    }

    public static void IMCLine() {

    }

    public static void OpticalLine() {

    }



}
