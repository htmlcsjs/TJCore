package TJCore.common.recipes;

import TJCore.common.metaitem.TJMetaItem;
import TJCore.common.metaitem.TJMetaItems;
import gregicality.multiblocks.GregicalityMultiblocks;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.items.GCYSMetaItems;
import gregicality.science.loaders.recipe.GCYSRecipeLoader;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opencl.CL;


import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.*;

public class CircuitRecipes {

    public static void removePreexistingCircuits() {
        ELECTRONIC_CIRCUIT_LV.setInvisible();
        RESISTOR.setInvisible();
        DIODE.setInvisible();
        CAPACITOR.setInvisible();
        TRANSISTOR.setInvisible();
        INDUCTOR.setInvisible();
        SMD_CAPACITOR.setInvisible();
        SMD_DIODE.setInvisible();
        SMD_RESISTOR.setInvisible();
        SMD_TRANSISTOR.setInvisible();
        SMD_INDUCTOR.setInvisible();
        ADVANCED_SMD_CAPACITOR.setInvisible();
        ADVANCED_SMD_DIODE.setInvisible();
        ADVANCED_SMD_RESISTOR.setInvisible();
        ADVANCED_SMD_TRANSISTOR.setInvisible();
        ADVANCED_SMD_INDUCTOR.setInvisible();
        ELECTRONIC_CIRCUIT_LV.setInvisible();
        ELECTRONIC_CIRCUIT_MV.setInvisible();
        INTEGRATED_CIRCUIT_LV.setInvisible();
        INTEGRATED_CIRCUIT_MV.setInvisible();
        INTEGRATED_CIRCUIT_HV.setInvisible();
        NAND_CHIP_ULV.setInvisible();
        MICROPROCESSOR_LV.setInvisible();
        PROCESSOR_MV.setInvisible();
        PROCESSOR_ASSEMBLY_HV.setInvisible();
        WORKSTATION_EV.setInvisible();
        MAINFRAME_IV.setInvisible();
        //NANO_PROCESSOR_HV.setInvisible();
        NANO_PROCESSOR_ASSEMBLY_EV.setInvisible();
        //NANO_COMPUTER_IV.setInvisible();
        //NANO_MAINFRAME_LUV.setInvisible();
        QUANTUM_PROCESSOR_EV.setInvisible();
        QUANTUM_ASSEMBLY_IV.setInvisible();
        QUANTUM_COMPUTER_LUV.setInvisible();
        QUANTUM_MAINFRAME_ZPM.setInvisible();
        CRYSTAL_PROCESSOR_IV.setInvisible();
        CRYSTAL_ASSEMBLY_LUV.setInvisible();
        CRYSTAL_COMPUTER_ZPM.setInvisible();
        CRYSTAL_MAINFRAME_UV.setInvisible();
        WETWARE_PROCESSOR_LUV.setInvisible();
        WETWARE_PROCESSOR_ASSEMBLY_ZPM.setInvisible();
        WETWARE_SUPER_COMPUTER_UV.setInvisible();
        GTRecipeHandler.removeAllRecipes(CIRCUIT_ASSEMBLER_RECIPES);

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{
                FLUID_CELL_LARGE_STAINLESS_STEEL.getStackForm(),
                OreDictUnifier.get(plate, Naquadah,4),
                OreDictUnifier.get(plate, Ruridit, 2),
                OreDictUnifier.get(bolt, Trinium, 12),
                OreDictUnifier.get(stick,SamariumMagnetic),
                OreDictUnifier.get(rotor,Iridium),
                ELECTRIC_MOTOR_LuV.getStackForm()},
                new FluidStack[]{SolderingAlloy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{CARBON_FIBERS.getStackForm(1)}, new FluidStack[]{Epoxy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, BorosilicateGlass)}, new FluidStack[]{Epoxy.getFluid(144)});
    }
    public static void registerCircuits() {
        removePreexistingCircuits();
        SMD.registerSMDRecipes();
        Chips.registerChips();
        registerBoards();
        registerRecipes();
        registerSolder();
    }

    private static void registerSolder() {

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
    public static void registerRecipes() {
        primitive();
        electronic();
        integrated();
        micro();
        nano();
        imc();
        optical();
        crystal();
        wetware();
        bioware();
        quantum();
        exotic();
        cosmic();
        supra();
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
                .output(ingot, SilicaCeramic, 6)
                .EUt(30)
                .duration(420)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .input(plate, SilicaCeramic)
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
    private static void integratedBoard() {
        Material[] laminatorFluids = {Polyethylene,PolyvinylChloride,Polytetrafluoroethylene,Polybenzimidazole};
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
                .input(foil, Fiberglass)
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
                .input(wireFine,Fiberglass)
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
                .input(foil,Fiberglass)
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
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(20)
                .input(wireFine,ZBLAN)
                .fluidInputs(Europium.getFluid(25))
                .output(ZBLANMATRIX)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(20)
                .input(ZBLANMATRIX)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(144))
                .output(OPTICAL_BASE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(40)
                .input(OPTICAL_BASE)
                .input(dustSmall,IndiumPhosphide)
                .input(foil,ZBLAN)
                .output(LAMINATED_OPTICAL_BASE)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(60)
                .input(dustSmall,LuminescentSiliconNanocrystals)
                .input(LAMINATED_OPTICAL_BASE)
                .fluidInputs(SeleniumMonobromide.getFluid(50))
                .output(OPTICAL_PREBOARD)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(20)
                .input(wireFine,ZBLAN)
                .input(OPTICAL_PREBOARD)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(50))
                .output(OPTICAL_BOARD)
                .buildAndRegister();
    }
    private static void crystalBoard(){
        FSZM_RECIPES.recipeBuilder()
                .duration(80)
                .EUt(VA[EV])
                .input(SAPPHIRE_WAFER)
                .fluidInputs(Argon.getFluid(50))
                .output(PROCESSED_CRYSTAL_WAFER)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(140)
                .EUt(VA[IV])
                .input(dust, HafniumSilicate, 4)
                .input(wireFine, Rhodium)
                .output(CRYSTAL_SFET_BUNDLE, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(90)
                .EUt(VA[ZPM])
                .input(PROCESSED_CRYSTAL_WAFER)
                .input(CRYSTAL_SFET_BUNDLE, 4)
                .output(CRYSTAL_SFET_WAFER)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(55)
                .EUt(VA[EV])
                .input(foil,Germanium, 2)
                .input(foil,ZBLAN)
                .output(REFRACTING_SHEET)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(105)
                .EUt(VA[EV])
                .input(REFRACTING_SHEET)
                .input(CRYSTAL_SFET_WAFER)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(288))
                .output(LAMINATED_CRYSTAL_PCB_SHEET)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .duration(20)
                .EUt(VA[MV])
                .input(dust, Cobalt60)
                .input(foil,Lead)
                .output(GAMMA_EMITTING_DIODE, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(65)
                .EUt(VA[ZPM])
                .input(LAMINATED_CRYSTAL_PCB_SHEET)
                .input(GAMMA_EMITTING_DIODE, 8)
                .output(CRYSTAL_PREBOARD)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .duration(160)
                .EUt(VA[EV])
                .input(CRYSTAL_PREBOARD)
                .output(CRYSTAL_BOARD, 8)
                .buildAndRegister();
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
    public static void primitive() {
        ModHandler.addShapedRecipe("primitive_assembly_ulv", PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                "RVR", "WBW", " V ",
                'R', RESISTOR.getStackForm(),
                'V', VACUUM_TUBE.getStackForm(),
                'B', PRIMITIVE_BOARD.getStackForm(),
                'W', OreDictUnifier.get(wireGtSingle, Tin));

        ModHandler.addShapedRecipe("primitive_computer_lv", PRIMITIVE_COMPUTER_LV.getStackForm(),
                "CAC", "WBW", "PAP",
                'C', CAPACITOR.getStackForm(),
                'A', PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                'W', OreDictUnifier.get(cableGtSingle, RedAlloy),
                'B', PRIMITIVE_BOARD.getStackForm(),
                'P', OreDictUnifier.get(plate, Tin));

        ModHandler.addShapedRecipe("primitive_mainframe_mv", PRIMITIVE_MAINFRAME_MV.getStackForm(),
                "DPD", "CFC", "TGT",
                'C', PRIMITIVE_COMPUTER_LV.getStackForm(),
                'D', DIODE.getStackForm(),
                'F', OreDictUnifier.get(frameGt, Wood),
                'P', OreDictUnifier.get(plate, WroughtIron),
                'T', TRANSISTOR.getStackForm(),
                'G', OreDictUnifier.get(cableGtSingle, Tin));
    }
    // Processor - CR
    // Assembly - TR
    // Computer - IC
    // Mainframe - TD
    public static void electronic() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(SIMPLE_CPU)
                .input(ELECTRONIC_BOARD)
                .input(CAPACITOR,2)
                .input(RESISTOR, 2)
                .input(wireFine, Tin, 4)
                .output(ELECTRONIC_PROCESSOR_ULV, 2)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_PROCESSOR_ULV, 2)
                .input(ELECTRONIC_BOARD)
                .input(TRANSISTOR, 2)
                .input(RESISTOR, 2)
                .input(wireFine, Tin, 2)
                .output(ELECTRONIC_ASSEMBLY_LV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_ASSEMBLY_LV, 2)
                .input(plate, Aluminium)
                .input(INDUCTOR, 2)
                .input(CAPACITOR, 2)
                .input(wireFine, Copper, 2)
                .output(ELECTRONIC_COMPUTER_MV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_COMPUTER_MV)
                .input(frameGt, Aluminium)
                .input(TRANSISTOR, 2)
                .input(DIODE, 2)
                .input(cableGtSingle, Copper, 2)
                .output(ELECTRONIC_MAINFRAME_HV)
                .buildAndRegister();
    }
    public static void integrated() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_CHIP)
                .input(INTEGRATED_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Copper, 4)
                .output(INTEGRATED_PROCESSOR_LV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_PROCESSOR_LV,2)
                .input(INTEGRATED_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Copper, 2)
                .output(INTEGRATED_ASSEMBLY_MV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_ASSEMBLY_MV,2)
                .input(plate, StainlessSteel)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Electrum, 2)
                .output(INTEGRATED_COMPUTER_HV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_COMPUTER_HV,2)
                .input(frameGt, StainlessSteel)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Electrum,2)
                .output(INTEGRATED_MAINFRAME_EV)
                .buildAndRegister();
    }
    public static void micro() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_CHIP)
                .input(MICRO_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Electrum,4)
                .output(MICRO_PROCESSOR_MV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_PROCESSOR_MV, 2)
                .input(MICRO_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Electrum, 2)
                .output(MICRO_ASSEMBLY_HV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_ASSEMBLY_HV,2 )
                .input(plate, Titanium)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Aluminium, 2)
                .output(MICRO_COMPUTER_EV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_COMPUTER_EV, 2)
                .input(frameGt, Titanium)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Aluminium, 2)
                .output(MICRO_MAINFRAME_IV)
                .buildAndRegister();
    }
    public static void nano() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(NANO_CHIP)
                .input(NANO_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Aluminium, 4)
                .output(TJMetaItems.NANO_PROCESSOR_HV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(TJMetaItems.NANO_PROCESSOR_HV, 2)
                .input(NANO_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Aluminium, 2)
                .output(NANO_ASSEMBLY_EV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(NANO_ASSEMBLY_EV, 2)
                .input(plate, TungstenSteel)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Platinum, 2)
                .output(TJMetaItems.NANO_COMPUTER_IV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(TJMetaItems.NANO_COMPUTER_IV, 2)
                .input(frameGt, TungstenSteel)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Platinum, 2)
                .output(TJMetaItems.NANO_MAINFRAME_LUV)
                .buildAndRegister();
    }
    public static void imc() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_CHIP)
                .input(IMC_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Platinum, 4)
                .output(IMC_PROCESSOR_EV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_PROCESSOR_EV,2)
                .input(IMC_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Platinum, 2)
                .output(IMC_ASSEMBLY_IV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_ASSEMBLY_IV)
                .input(plate, RhodiumPlatedPalladium)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, NiobiumTitanium, 2)
                .output(IMC_COMPUTER_LUV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_COMPUTER_LUV)
                .input(frameGt, RhodiumPlatedPalladium)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .output(IMC_MAINFRAME_ZPM)
                .buildAndRegister();
    }
    public static void optical() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_CHIP)
                .input(OPTICAL_BOARD)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, NiobiumTitanium, 4)
                .output(OPTICAL_PROCESSOR_IV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_PROCESSOR_IV, 2)
                .input(OPTICAL_BOARD)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, NiobiumTitanium, 2)
                .output(OPTICAL_ASSEMBLY_LUV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_ASSEMBLY_LUV, 2)
                .input(plate, NaquadahAlloy)
                .input(SMD_INDUCTOR_2, 2)
                .input(SMD_CAPACITOR_2, 2)
                .input(wireFine, VanadiumGallium, 2)
                .output(OPTICAL_COMPUTER_ZPM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_COMPUTER_ZPM, 2)
                .input(frameGt, NaquadahAlloy)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, VanadiumGallium)
                .output(OPTICAL_MAINFRAME_UV)
                .buildAndRegister();
    }
    public static void crystal() {
        /*CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input()
                .input()
                .input()
                .input()
                .input()
                .output()
                .buildAndRegister(); */
    }
    public static void wetware() {

    }
    public static void bioware() {

    }
    public static void quantum() {

    }
    public static void exotic() {

    }
    public static void cosmic() {

    }
    public static void supra() {

    }
}
