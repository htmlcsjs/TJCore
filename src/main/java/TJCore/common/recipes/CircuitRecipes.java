package TJCore.common.recipes;

import TJCore.common.metaitem.TJMetaItem;
import TJCore.common.metaitem.TJMetaItems;
import gregicality.multiblocks.GregicalityMultiblocks;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.items.GCYSMetaItems;
import gregicality.science.loaders.recipe.GCYSRecipeLoader;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItem1;
import gregtech.common.items.MetaItems;
import gregtech.loaders.recipe.chemistry.PolymerRecipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.advancements.critereon.OredictItemPredicate;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.opencl.CL;


import java.util.ArrayList;
import java.util.List;

import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.*;

public class CircuitRecipes {

    public static void removePreexistingCircuits() {

        oreDictHandling();

        GTRecipeHandler.removeAllRecipes(CIRCUIT_ASSEMBLER_RECIPES);
        GTRecipeHandler.removeAllRecipes(ASSEMBLY_LINE_RECIPES);

        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[] {OreDictUnifier.get(dust, Carbon,4)}, new FluidStack[] {Polyethylene.getFluid(36)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[] {OreDictUnifier.get(dust, Carbon,4)}, new FluidStack[] {Polytetrafluoroethylene.getFluid(18)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[] {OreDictUnifier.get(dust, Carbon,4)}, new FluidStack[] {Epoxy.getFluid(9)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[] {OreDictUnifier.get(dust, Carbon,8)}, new FluidStack[] {Polybenzimidazole.getFluid(9)});

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
    public static void oreDictHandling() {
        List<String> toRemove = new ArrayList<>();
        toRemove.add("circuitUlv");
        toRemove.add("circuitLv");
        toRemove.add("circuitMv");
        toRemove.add("circuitHv");
        toRemove.add("circuitEv");
        toRemove.add("circuitIv");
        toRemove.add("circuitLuv");
        toRemove.add("circuitZpm");
        toRemove.add("circuitUv");
        toRemove.add("circuitUhv");
        toRemove.add("circuitUev");
        toRemove.add("circuitUiv");
        toRemove.add("circuitUxv");
        toRemove.add("circuitOpv");
        toRemove.add("circuitMax");

        for (String oredict : toRemove) {
            List<ItemStack> list = OreDictionary.getOres(oredict, false);
            for (int i = 0; i < list.size(); i++) {
                ItemStack stack = list.get(i);
                if (!(stack.getItem() instanceof TJMetaItem)) {
                    MetaItem<?>.MetaValueItem valueItem = ((MetaItem) stack.getItem()).getItem(stack);
                    valueItem.setInvisible();
                    list.remove(i);
                    i--;
                }
            }
        }

        VACUUM_TUBE.setInvisible(true);
        SMD_CAPACITOR.setInvisible();
        SMD_DIODE.setInvisible();
        SMD_INDUCTOR.setInvisible();
        SMD_TRANSISTOR.setInvisible();
        SMD_RESISTOR.setInvisible();
        ADVANCED_SMD_CAPACITOR.setInvisible();
        ADVANCED_SMD_RESISTOR.setInvisible();
        ADVANCED_SMD_TRANSISTOR.setInvisible();
        ADVANCED_SMD_DIODE.setInvisible();
        ADVANCED_SMD_INDUCTOR.setInvisible();
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

        ModHandler.addShapedRecipe("stencil_cutting_head", STENCILING_CUTHEAD.getStackForm(),
                "RP ", "RG ", "SL ",
                'R', OreDictUnifier.get(stick, Steel),
                'P', OreDictUnifier.get(plate, Steel),
                'G', OreDictUnifier.get(gear, Steel),
                'L', OreDictUnifier.get(springSmall, Steel),
                'S', OreDictUnifier.get(screw, Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_PREBOARD)
                .input(foil, Polyethylene)
                .notConsumable(STENCILING_CUTHEAD)
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
                .fluidInputs(Polyethylene.getFluid(144))
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
                .fluidInputs(Polyethylene.getFluid(144))
                .output(ELECTRUM_LAMINATED_EPOXID,2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(35)
                .input(ELECTRUM_LAMINATED_EPOXID)
                .input(foil,Polyethylene)
                .output(NANO_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(20)
                .input(MICRO_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(NANO_BOARD)
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
                .input(plate, ReinforcedEpoxyResin)
                .input(foil,Germanium)
                .input(foil,Fiberglass)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(GERMANIUM_LAMINATED_EPOXID,2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(15)
                .input(GERMANIUM_LAMINATED_EPOXID)
                .input(foil,Polyethylene)
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
                .input(wireFine, ZBLANGlass)
                .fluidInputs(Europium.getFluid(16))
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
                .input(foil,ErbiumDopedZBLANGlass)
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
                .input(wireFine,ZBLANGlass, 4)
                .input(OPTICAL_PREBOARD)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(50))
                .output(TJMetaItems.OPTICAL_BOARD)
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
                .input(foil,PraseodymiumDopedZBLANGlass)
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
                .input(plate, Aluminium, 2)
                .input(INDUCTOR, 2)
                .input(CAPACITOR, 2)
                .input(wireFine, Copper, 2)
                .output(ELECTRONIC_COMPUTER_MV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_COMPUTER_MV, 2)
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
                .input(plate, StainlessSteel, 2)
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
                .input(plate, Titanium, 2)
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
                .input(plate, TungstenSteel, 2)
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
                .input(IMC_ASSEMBLY_IV, 2)
                .input(plate, RhodiumPlatedPalladium, 2)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, NiobiumTitanium, 2)
                .output(IMC_COMPUTER_LUV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_COMPUTER_LUV, 2)
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
                .input(TJMetaItems.OPTICAL_BOARD)
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
                .input(TJMetaItems.OPTICAL_BOARD)
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
                .input(plate, HSSE ,2)
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
                .input(frameGt, HSSE)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, VanadiumGallium,2)
                .output(OPTICAL_MAINFRAME_UV)
                .buildAndRegister();
    }
    public static void crystal() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(SAPPHIRE_CHIP)
                .input(CRYSTAL_BOARD)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_3, 2)
                .input(wireFine, VanadiumGallium, 4)
                .output(CRYSTAL_PROCESSOR_LUV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_PROCESSOR_LUV, 2)
                .input(CRYSTAL_BOARD)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_RESISTOR_3, 2)
                .input(wireFine, VanadiumGallium, 2)
                .output(CRYSTAL_ASSEMBLY_ZPM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_ASSEMBLY_ZPM, 2)
                .input(plate, Europium, 2)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_INDUCTOR_2, 2)
                .input(wireFine, Naquadah,2)
                .output(CRYSTAL_COMPUTER_UV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_COMPUTER_UV, 2)
                .input(frameGt, Europium)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, Naquadah,2)
                .output(CRYSTAL_MAINFRAME_UHV)
                .buildAndRegister();
    }
    public static void wetware() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .cleanroom(STERILE_CLEANROOM)
                .input(WETWARE_CPU)
                .input(TJMetaItems.WETWARE_BOARD)
                .input(SMD_RESISTOR_3, 2)
                .input(SMD_CAPACITOR_3, 2)
                .input(wireFine, Naquadah, 4)
                .output(WETWARE_PROCESSOR_ZPM, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .cleanroom(STERILE_CLEANROOM)
                .input(WETWARE_PROCESSOR_ZPM, 2)
                .input(TJMetaItems.WETWARE_BOARD)
                .input(SMD_TRANSISTOR_3, 2)
                .input(SMD_RESISTOR_3, 2)
                .input(wireFine, Naquadah, 2)
                .output(WETWARE_ASSEMBLY_UV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .cleanroom(STERILE_CLEANROOM)
                .input(WETWARE_ASSEMBLY_UV, 2)
                .input(plate, Duranium, 2)
                .input(SMD_CAPACITOR_3, 2)
                .input(SMD_INDUCTOR_3, 2)
                .input(wireFine, YttriumBariumCuprate, 2)
                .output(WETWARE_COMPUTER_UHV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .cleanroom(STERILE_CLEANROOM)
                .input(WETWARE_COMPUTER_UHV,2)
                .input(frameGt, Duranium)
                .input(SMD_DIODE_2, 2)
                .input(SMD_TRANSISTOR_3, 2)
                .input(cableGtSingle, YttriumBariumCuprate,2)
                .output(WETWARE_MAINFRAME_UEV)
                .buildAndRegister();
    }
    public static void bioware() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UHV])
                .cleanroom(STERILE_CLEANROOM)
                .input(BIOWARE_CPU)
                .input(BIOWARE_BOARD)
                .input(SMD_RESISTOR_4,2)
                .input(SMD_CAPACITOR_3, 2)
                .input(wireFine, YttriumBariumCuprate, 4)
                .output(BIOWARE_PROCESSOR_UV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UHV])
                .cleanroom(STERILE_CLEANROOM)
                .input(BIOWARE_PROCESSOR_UV, 2)
                .input(BIOWARE_BOARD)
                .input(SMD_TRANSISTOR_3, 2)
                .input(SMD_RESISTOR_4, 2)
                .input(wireFine, YttriumBariumCuprate, 2)
                .output(BIOWARE_ASSEMBLY_UHV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UHV])
                .cleanroom(STERILE_CLEANROOM)
                .input(BIOWARE_ASSEMBLY_UHV, 2)
                .input(plate, PedotPSS, 2)
                .input(SMD_CAPACITOR_3, 2)
                .input(SMD_INDUCTOR_3, 2)
                .input(wireFine, PedotTMA, 2)
                .output(BIOWARE_COMPUTER_UEV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UHV])
                .cleanroom(STERILE_CLEANROOM)
                .input(BIOWARE_COMPUTER_UEV, 2)
                .input(frameGt, PedotPSS, 2)
                .input(SMD_DIODE_3, 2)
                .input(SMD_TRANSISTOR_3, 2)
                .input(cableGtSingle, PedotTMA,2)
                .output(BIOWARE_MAINFRAME_UIV)
                .buildAndRegister();
    }
    public static void quantum() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UEV])
                .input(QUANTUM_CPU)
                .input(QUANTUM_BOARD)
                .input(SMD_RESISTOR_4, 2)
                .input(SMD_CAPACITOR_4, 2)
                .input(wireFine, PedotTMA, 4)
                .output(QUANTUM_PROCESSOR_UHV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UEV])
                .input(QUANTUM_PROCESSOR_UHV, 2)
                .input(QUANTUM_BOARD)
                .input(SMD_TRANSISTOR_4, 2)
                .input(SMD_RESISTOR_4, 2)
                .input(wireFine, PedotTMA, 2)
                .output(QUANTUM_ASSEMBLY_UEV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UEV])
                .input(QUANTUM_ASSEMBLY_UEV, 2)
                .input(plate, CarbonNanotubePolymer, 2)
                .input(SMD_CAPACITOR_4, 2)
                .input(SMD_INDUCTOR_4, 2)
                .input(wireFine, CarbonNanotube, 2)
                .output(QUANTUM_COMPUTER_UIV)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .duration(180)
                .EUt(VA[UEV])
                .fluidInputs(SolderingAlloyV.getFluid(288))
                .fluidInputs(Helium.getFluid(1000))
                .input(QUANTUM_COMPUTER_UIV, 2)
                .input(frameGt, CarbonNanotubePolymer)
                .input(SMD_DIODE_3, 16)
                .input(SMD_TRANSISTOR_4, 8)
                .input(SMD_INDUCTOR_4, 8)
                .input(SMD_RESISTOR_4, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 2)
                .input(foil, Phosphorene, 2)
                .input(bolt, Adamantium, 4)
                .input(cableGtSingle, CarbonNanotube, 4)
                .output(QUANTUM_MAINFRAME_UXV)
                .buildAndRegister();
    }
    public static void exotic() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UIV])
                .input(EXOTIC_CPU)
                .input(EXOTIC_BOARD)
                .input(SMD_RESISTOR_4, 2)
                .input(SMD_CAPACITOR_4, 2)
                .input(wireFine, CarbonNanotube, 4)
                .output(EXOTIC_PROCESSOR_UEV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UIV])
                .input(EXOTIC_PROCESSOR_UEV, 2)
                .input(EXOTIC_BOARD)
                .input(SMD_RESISTOR_4, 2)
                .input(SMD_TRANSISTOR_4, 2)
                .input(wireFine, CarbonNanotube, 2)
                .output(EXOTIC_ASSEMBLY_UIV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UIV])
                .input(EXOTIC_ASSEMBLY_UIV, 2)
                .input(plate, Vibranium, 2)
                .input(SMD_CAPACITOR_4, 2)
                .input(SMD_INDUCTOR_4, 2)
                .input(wireFine, NihoniumTriiodide, 2)
                .output(EXOTIC_COMPUTER_UXV)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .duration(180)
                .EUt(VA[UIV])
                .fluidInputs(SolderingAlloyV.getFluid(288))
                .fluidInputs(HeliumNeon.getFluid(1000))
                .input(EXOTIC_COMPUTER_UXV, 2)
                .input(frameGt, Vibranium)
                .input(SMD_DIODE_4, 8)
                .input(SMD_TRANSISTOR_4, 16)
                .input(SMD_INDUCTOR_4, 8)
                .input(SMD_RESISTOR_4, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 4)
                .input(foil, Fullerene, 2)
                .input(bolt, Vibranium, 4)
                .input(cableGtSingle, NihoniumTriiodide, 4)
                .output(EXOTIC_MAINFRAME_OPV)
                .buildAndRegister();
    }
    public static void cosmic() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(COSMIC_CPU)
                .input(COSMIC_BOARD)
                .input(SMD_RESISTOR_5, 2)
                .input(SMD_CAPACITOR_5, 2)
                .input(wireFine, NihoniumTriiodide, 4)
                .output(COSMIC_PROCESSOR_UIV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(COSMIC_PROCESSOR_UIV, 2)
                .input(COSMIC_BOARD)
                .input(SMD_RESISTOR_5, 2)
                .input(SMD_TRANSISTOR_4, 2)
                .input(wireFine, NihoniumTriiodide, 2)
                .output(COSMIC_ASSEMBLY_UXV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(COSMIC_ASSEMBLY_UXV, 2)
                .input(plate, SuperheavyL, 2)
                .input(SMD_CAPACITOR_5, 2)
                .input(SMD_INDUCTOR_5, 2)
                .input(wireFine, SuperheavyH, 2)
                .output(COSMIC_COMPUTER_OPV)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .duration(180)
                .EUt(VA[UXV])
                .fluidInputs(SolderingAlloyVI.getFluid(288))
                .fluidInputs(LightQuarks.getFluid(1000))
                .input(COSMIC_COMPUTER_OPV, 2)
                .input(frameGt, SuperheavyL)
                .input(SMD_DIODE_4, 8)
                .input(SMD_TRANSISTOR_4, 16)
                .input(SMD_INDUCTOR_5, 8)
                .input(SMD_RESISTOR_5, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 4)
                .input(gem, CubicHeterodiamond,  2)
                .input(ring, SuperheavyL, 2)
                .input(cableGtSingle, NihoniumTriiodide, 4)
                .output(COSMIC_MAINFRAME_MAX)
                .buildAndRegister();

    }
    public static void supra() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(SUPRA_CPU)
                .input(SUPRA_BOARD)
                .input(SMD_RESISTOR_5, 2)
                .input(SMD_CAPACITOR_5, 2)
                .input(wireFine, SuperheavyH, 4)
                .output(SUPRA_PROCESSOR_UXV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(SUPRA_PROCESSOR_UXV, 2)
                .input(SUPRA_BOARD)
                .input(SMD_RESISTOR_5, 2)
                .input(SMD_TRANSISTOR_5, 2)
                .input(wireFine, SuperheavyH, 2)
                .output(SUPRA_ASSEMBLY_OPV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(SUPRA_ASSEMBLY_OPV, 2)
                .input(plate, Neutronium, 2)
                .input(SMD_CAPACITOR_5, 2)
                .input(SMD_INDUCTOR_5, 2)
                .input(wireFine, Neutronium, 2)
                .output(SUPRA_COMPUTER_MAX)
                .buildAndRegister();

    }
}
