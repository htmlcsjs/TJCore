package TJCore.common.recipes;

import TJCore.api.material.TJMaterials;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.DEHYDRATOR_RECIPES;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.LAMINATOR_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

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
        ELECTRONIC_CIRCUIT_LV.setInvisible();
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{CARBON_FIBERS.getStackForm(1)}, new FluidStack[]{Epoxy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, BorosilicateGlass)}, new FluidStack[]{Epoxy.getFluid(144)});
    }

    public static void registerCircuits() {
        removePreexistingCircuits();
        Wafers.registerLithography();
        registerBoards();
    }

    public static void registerBoards() {
        primitiveBoard();
        electronicBoard();
        integratedBoard();
        microBoard();
        nanoBoard();
        imcBoard();
        opticalBoard();
        crystalBoard();
        wetwareBoard();
        biowareBoard();
        quantumBoard();
        exoticBoard();
        cosmicBoard();
        supraBoard();
    }

    private static void primitiveBoard() {
        //Primitive Point to Point PCB
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Wood, 4)
                .fluidInputs(Creosote.getFluid(500))
                .output(WETPHENOLICPULP)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(WETPHENOLICPULP)
                .output(WETPRESSEDPHENOLICSUBSTRATE)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        DEHYDRATOR_RECIPES.recipeBuilder()
                .input(WETPRESSEDPHENOLICSUBSTRATE)
                .output(PRIMITIVE_PREBOARD)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapelessRecipe("primitive_board", PRIMITIVE_BOARD.getStackForm(1),
                new UnificationEntry(wireFine, Copper),
                PRIMITIVE_PREBOARD.getStackForm());

    }

    private static void electronicBoard() {
        ///Silicate Stenciled PCB
        BLAST_RECIPES.recipeBuilder()
                .input(dust,SiliconDioxide,6)
                .input(dustTiny, Nickel)
                .output(ingot, TJMaterials.SilicaCeramic, 6)
                .EUt(30)
                .duration(420)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .input(plate, TJMaterials.SilicaCeramic)
                .input(foil, Copper, 2)
                .output(ELECTRONIC_PREBOARD)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ELECTRONIC_PREBOARD)
                .input(foil,Copper)
                .output(ELECTRONIC_BOARD)
                .EUt(30)
                .duration(20)
                .buildAndRegister();
    }
    public static Material[] laminatorFluids = {Polyethylene,PolyvinylChloride,Polytetrafluoroethylene,Polybenzimidazole};
    private static void integratedBoard() {
        //Machine Stenciled PCB
        for (int i = 0; i < laminatorFluids.length; i++) {
            LAMINATOR_RECIPES.recipeBuilder()
                    .input(plate, Polyethylene)
                    .input(foil,Copper,2)
                    .fluidInputs(laminatorFluids[i].getFluid(144/(i+1)))
                    .output(INTEGRATED_PREBOARD, i+1)
                    .EUt(30)
                    .duration(20)
                    .buildAndRegister();
        }
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_PREBOARD)
                .input(foil, Copper)
                .output(INTEGRATED_BOARD)
                .EUt(120)
                .duration(40)
                .buildAndRegister();
    }
    private static void microBoard() {
        //Simple Etched PCB
        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(50)
                .input(foil,Epoxy,4)
                .input(foil,AnnealedCopper,2)
                .output(COPPER_LAMINATED_EPOXID)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(120)
                .duration(20)
                .input(COPPER_LAMINATED_EPOXID)
                .input(foil,Polyethylene)
                .output(MICRO_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(35)
                .input(MICRO_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(MICRO_BOARD)
                .buildAndRegister();
    }
    private static void nanoBoard(){
        //Reinforced Etched PCB
        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(2000)
                .duration(20)
                .input(foil, Epoxy, 4)
                .input(foil, Electrum)
                .input(foil, TJMaterials.Fiberglass)
                .output(ELECTRUM_LAMINATED_EPOXID,2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(35)
                .input(ELECTRUM_LAMINATED_EPOXID)
                .input(foil,Epoxy)
                .output(MICRO_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(20)
                .input(MICRO_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(MICRO_BOARD)
                .buildAndRegister();
    }
    private static void imcBoard(){
        //Multi-Layer Etched PCB
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(20)
                .input(wireFine,TJMaterials.Fiberglass)
                .output(FIBERGLASS_MESH,2)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(40)
                .input(FIBERGLASS_MESH)
                .fluidInputs(Epoxy.getFluid(72))
                .output(plate,ReinforcedEpoxyResin)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(20)
                .input(foil,ReinforcedEpoxyResin,2)
                .input(foil,Germanium)
                .input(foil,TJMaterials.Fiberglass)
                .output(GERMANIUM_LAMINATED_EPOXID,2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(15)
                .input(GERMANIUM_LAMINATED_EPOXID)
                .input(foil,Epoxy)
                .output(IMC_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(20)
                .input(IMC_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(IMC_BOARD)
                .buildAndRegister();

    }
    private static void opticalBoard(){
        //Optical Integrated PCB
    }
    private static void crystalBoard(){
        //Energy Modulus PCB
    }
    private static void wetwareBoard(){
        //Organic Neural Network Support Unit
    }
    private static void biowareBoard(){
        //Bio-Froth Support Unit
    }
    private static void quantumBoard(){
        //Q-Bit Computational Framework
    }
    private static void exoticBoard(){
        //Exotic Particle Manipulation Framework
    }
    private static void cosmicBoard(){
        //Cosmic Soup Physical Calculation Framework
    }
    private static void supraBoard(){
        //Temporally Isolated Calculation Framework
    }


    /*public static void PrimitiveElectronicIntegratedLines() {

        ModHandler.addShapelessRecipe("capacitor", CAPACITOR.getStackForm(3),
                new UnificationEntry(plate, Nickel),
                new UnificationEntry(dust, Sulfur),
                new UnificationEntry(dust, Mica),
                new UnificationEntry(wireGtSingle, Copper));


        ModHandler.addShapedRecipe("primitive_assembly", PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                "RVR", "WBW", " V ",
                'R', RESISTOR.getStackForm(),
                'V', VACUUM_TUBE.getStackForm(),
                'B', COATED_BOARD.getStackForm(),
                'W', new UnificationEntry(wireGtSingle, Tin));

        ModHandler.addShapedRecipe("primitive_assembly_phenolic", PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                "RVR", "WBW", " V ",
                'R', RESISTOR.getStackForm(),
                'V', VACUUM_TUBE.getStackForm(),
                'B', PHENOLIC_BOARD.getStackForm(),
                'W', new UnificationEntry(wireGtSingle, Tin));

        ModHandler.addShapedRecipe("primitive_computer", PRIMITIVE_COMPUTER_LV.getStackForm(),
                "CFC", "APA", "FAF",
                'P', new UnificationEntry(plate, Steel),
                'C', CAPACITOR.getStackForm(),
                'F', new UnificationEntry(wireFine, Copper),
                'A', PRIMITIVE_ASSEMBLY_ULV.getStackForm());

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(PRIMITIVE_COMPUTER_LV.getStackForm(2))
                .input(plate, Aluminium, 2)
                .input(DIODE, 2)
                .input(INDUCTOR, 2)
                .output(PRIMITIVE_MAINFRAME_MV)
                .EUt(30)
                .duration(15 * 20)
                .buildAndRegister();






        MetaItem<?>.MetaValueItem[] boards = {GOOD_CIRCUIT_BOARD, PLASTIC_CIRCUIT_BOARD};
        MetaItem<?>.MetaValueItem[] transistor = {TRANSISTOR, SMD_TRANSISTOR_1};
        MetaItem<?>.MetaValueItem[] resistor = {RESISTOR, SMD_RESISTOR_1};
        MetaItem<?>.MetaValueItem[] diode = {DIODE, SMD_DIODE_1};
        MetaItem<?>.MetaValueItem[] capacitor = {CAPACITOR, SMD_CAPACITOR_1};
        MetaItem<?>.MetaValueItem[] inductor = {INDUCTOR, SMD_INDUCTOR_1};

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                        .input(boards[i])
                        .input(NAND_MEMORY_CHIP, 2)
                        .input(resistor[j], 4)
                        .input(wireFine, Tin, 4)
                        .output(ELECTRONIC_PROCESSOR_ULV)
                        .EUt(30)
                        .duration(50)
                        .buildAndRegister();


            }
            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ELECTRONIC_PROCESSOR_ULV, 3)
                    .input(capacitor[i], 2)
                    .input(transistor[i], 2)
                    .input(resistor[i], 4)
                    .input(wireFine, TinAlloy, 8)
                    .output(ELECTRONIC_ASSEMBLY_LV)
                    .EUt(30)
                    .duration(100)
                    .buildAndRegister();

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ELECTRONIC_ASSEMBLY_LV, 2)
                    .input(inductor[i], 2)
                    .input(transistor[i], 4)
                    .input(resistor[i], 2)
                    .input(wireFine, Copper, 8)
                    .output(ELECTRONIC_COMPUTER_MV)
                    .EUt(30)
                    .duration(200)
                    .buildAndRegister();

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(ELECTRONIC_COMPUTER_MV, 2)
                    .input(diode[i], 2)
                    .input(inductor[i], 4)
                    .input(frameGt, StainlessSteel, 1)
                    .output(ELECTRONIC_MAINFRAME_HV)
                    .EUt(30)
                    .duration(400)
                    .buildAndRegister();


        }
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 4)
                .output(ELECTRONIC_PROCESSOR_ULV, 3)
                .EUt(VA[EV])
                .duration(400)
                .buildAndRegister();

       //LASER_ENGRAVER_RECIPES.recipeBuilder()
       //        .input(LITHOGRAPHY_MASK.getStackForm(Polyethylene))



        // TODO(Onion): add to cleanroom logic recipes

        MetaItem<?>.MetaValueItem[] board2 = { PLASTIC_CIRCUIT_BOARD };

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(board2[0])
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_2, 4)
                .input(INTEGRATED_LOGIC_CIRCUIT) // needs lithography shit
                .output(INTEGRATED_PROCESSOR_LV)
                .EUt(VA[MV])
                .duration(50)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_PROCESSOR_LV, 3)
                .input(INTEGRATED_LOGIC_CIRCUIT)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_2, 4)
                .input(plate, Aluminium)
                .input(wireFine, Copper, 8)
                .output(INTEGRATED_ASSEMBLY_MV)
                .EUt(VA[MV])
                .duration(90)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_ASSEMBLY_MV, 2)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_INDUCTOR_2, 4)
                .input(plate, StainlessSteel, 2)
                .input(cableGtSingle, Gold, 2)
                .output(INTEGRATED_COMPUTER_HV)
                .EUt(VA[MV])
                .duration(180)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_COMPUTER_HV, 2)
                .input(SMD_DIODE_2, 2)
                .input(SMD_INDUCTOR_2, 4)
                .input(RANDOM_ACCESS_MEMORY, 3)
                .input(plate, Titanium, 2)
                .input(cableGtDouble, Aluminium, 1)
                .output(INTEGRATED_MAINFRAME_EV)
                .EUt(VA[MV])
                .duration(270)
                .buildAndRegister();
    }*/
}
