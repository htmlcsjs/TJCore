package TJCore.common.recipes;

import gregicality.multiblocks.GregicalityMultiblocks;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opencl.CL;


import static TJCore.api.TJOreDictionaryLoader.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SMD {
    public static void registerSMDRecipes() {
//
        // TRANSISTORS

        ModHandler.addShapedRecipe("transistor", TRANSISTOR.getStackForm(2),
                " F ", "WDW", " F ",
                'F', OreDictUnifier.get(foil, Silicon),
                'D', OreDictUnifier.get(foil, Gold),
                'W', OreDictUnifier.get(dustTiny, SiliconDioxide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, PolyvinylChloride, 2)
                .input(ring, SilicaCeramic, 2)
                .input(wireFine, AnnealedCopper, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_TRANSISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .input(foil, Ladder_Poly_P_Phenylene, 2)
                .input(plate, Ruthenium)
                .input(wireFine, ZBLANGlass)
                .fluidInputs(SeleniumMonobromide.getFluid(288))
                .output(SMD_TRANSISTOR_2, 32)
                .buildAndRegister();

        //TODO - replace steel wire with
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(65)
                .EUt(VA[LuV])
                .input(plate, BismuthTelluride)
                .input(foil, PolyvinylButyral, 4)
                .input(pipeTinyFluid, Chrome, 4)
                .input(nanoWire, Lead, 16)
                .fluidInputs(Glycerol.getFluid(250))
                .output(SMD_TRANSISTOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(75)
                .EUt(VA[UHV])
                .input(LANGMUIR_HOUSING)
                .input(TRANSMON_SUPPORT)
                .fluidInputs(Kevlar.getFluid(144))
                .output(SMD_TRANSISTOR_4, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(105)
                .EUt(VA[UXV])
                .input(bolt, Taranium)
                .input(foil, HeavyQuarkDegenerate, 4)
                .input(wireFine, SuperheavyH, 16)
                .input(nanoWire, Neutronium, 32)
                .fluidInputs(Gluons.getFluid(250))
                .output(SMD_TRANSISTOR_5, 32)
                .buildAndRegister();

        // RESISTORS


        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, SilicaCeramic, 2)
                .input(dust, SilverLeadOxide)
                .input(foil, PolyvinylChloride)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_RESISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .input(dust, Silicon, 2)
                .input(dustSmall, Gallium, 2)
                .input(foil, TungstenCarbide, 2)
                .input(wireFine, Nichrome, 4)
                .fluidInputs(Polytetrafluoroethylene.getFluid(288))
                .output(SMD_RESISTOR_2, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .input(bolt, Diamond)
                .input(foil, Palladium)
                .input(plate, BismuthIridiumOxide, 2)
                .fluidInputs(IndiumFluoride.getFluid(1000))
                .output(SMD_RESISTOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UHV])
                .input(foil, Graphene)
                .input(bolt, EnrichedNaqAlloy)
                .input(nanoWire, Trinium, 4)
                .fluidInputs(Iron.getPlasma(50))
                .output(SMD_RESISTOR_4, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(125)
                .EUt(VA[OpV])
                .input(round, Neutronium, 2)
                .input(springSmall, Taranium, 4)
                .input(bolt, SuperheavyL, 4)
                .input(nanoWire, Vibranium, 32)
                .fluidInputs(Gluons.getFluid(250))
                .output(SMD_RESISTOR_5, 32)
                .buildAndRegister();

        // CAPACITORS

        ModHandler.addShapedRecipe("capcitor", CAPACITOR.getStackForm(3),
                " F ", "WDW", " F ",
                'F', OreDictUnifier.get(foil, Copper),
                'D', OreDictUnifier.get(dustTiny, Glass),
                'W', OreDictUnifier.get(wireFine, Tin));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, SilicaCeramic, 4)
                .input(foil, NickelPlatedTin)
                .input(wireFine, Silver, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_CAPACITOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .input(foil, Ladder_Poly_P_Phenylene, 2)
                .input(dust, LuminescentSiliconNanocrystals, 2)
                .input(wireFine, ZBLANGlass)
                .fluidInputs(SeleniumMonobromide.getFluid(144))
                .output(SMD_CAPACITOR_2, 32)
                .buildAndRegister();

        //TODO - Replace Meat w/ ATP
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .input(dust, Meat, 2)
                .input(plate, BismuthIridiumOxide, 2)
                .input(foil, PolystyreneSulfonate, 2)
                .input(round, SodiumPotassiumNiobate, 18)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(SMD_CAPACITOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UEV])
                .input(bolt, TriniumSteel, 4)
                .input(plate, LeadZirconateTitanate, 2)
                .input(GRAPHENE_ALUMINOSILICATE_AEROGEL, 2)
                .input(nanoWire, Samarium, 32)
                .fluidInputs(XenonFluorideSupercondiveMix.getFluid(10))
                .output(SMD_CAPACITOR_4, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(plate, Copper, 2)
                .input(dust, Cobalt60, 2)
                .input(bolt, SuperheavyH, 2)
                .input(nanoWire, HeavyQuarkDegenerate, 16)
                .input(nanoWire, Taranium, 16)
                .fluidInputs(Leptons.getFluid(50))
                .output(SMD_CAPACITOR_5, 32)
                .buildAndRegister();

        // DIODES

        ModHandler.addShapedRecipe("diode", DIODE.getStackForm(4),
                " F ", "PDP", " F ",
                'F', OreDictUnifier.get(wireFine, Copper),
                'D', OreDictUnifier.get(foil, Gallium),
                'P', OreDictUnifier.get(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(dustSmall, Phosphorus)
                .input(dustSmall, Gallium)
                .input(foil, Silicon, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_DIODE_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .input(foil, Ruthenium, 2)
                .input(dustSmall, Naquadah)
                .input(dustSmall, Indium)
                .fluidInputs(PolyphenyleneSulfide.getFluid(144))
                .output(SMD_DIODE_2, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .input(plate,PMMA, 4)
                .input(foil, Fermium)
                .input(bolt, EnrichedNaqAlloy)
                .fluidInputs(PolyvinylButyral.getFluid(144))
                .output(SMD_DIODE_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UIV])
                .input(dust, GraphenePQD, 2)
                .input(foil, PedotTMA, 2)
                .input(ring, NihoniumTriiodide)
                .input(nanoWire, Adamantium, 32)
                .output(SMD_DIODE_4, 32)
                .buildAndRegister();

        // INDUCTORS
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(FERROUS_INDUCTOR_CORE)
                .input(wireFine, Copper, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_INDUCTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .input(TUNGSTEN_INDUCTOR_CORE)
                .input(foil, Naquadah)
                .input(wireFine, Platinum)
                .fluidInputs(PolyphenyleneSulfide.getFluid(144))
                .output(SMD_INDUCTOR_2, 32)
                .buildAndRegister();

        //TODO - replace meat with Fructose 1,6-bisphosphate (F1,6BP)
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UV])
                .input(STERILE_POLYMER_FOIL)
                .input(dust, Meat)
                .input(ring, HSSE)
                .input(nanoWire, Gold, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(50))
                .output(SMD_INDUCTOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UEV])
                .input(bolt, TerfenolD_L, 2)
                .input(foil, ThalliumCopperChloride, 2)
                .input(springSmall, Fermium, 2)
                .input(nanoWire, Adamantium, 32)
                .fluidInputs(PedotPSS.getFluid(144))
                .output(SMD_INDUCTOR_4, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[UXV])
                .input(ring, HeavyQuarkDegenerate, 4)
                .input(foil, SuperheavyH, 4)
                .input(foil, Fullerene, 4)
                .input(springSmall, Taranium, 4)
                .input(nanoWire, Taranium, 32)
                .fluidInputs(Leptons.getFluid(50))
                .output(SMD_INDUCTOR_5, 32)
                .buildAndRegister();
        // MISC. INTERMEDIARIES
        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[HV])
                .input(foil, Dubnium)
                .input(foil, Polybenzimidazole, 2)
                .fluidInputs(Polystyrene.getFluid(144))
                .output(LAYERED_POLYMER_FOIL)
                .buildAndRegister();

        EXPOSURE_CHAMBER_RECIPES.recipeBuilder()
                .duration(160)
                .EUt(VA[LuV])
                .input(LAYERED_POLYMER_FOIL)
                .notConsumable(BLACKLIGHT)
                .output(STERILE_POLYMER_FOIL)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[LV])
                .input(bolt, Steel)
                .input(foil, Silicon)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(FERROUS_INDUCTOR_CORE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[EV])
                .input(bolt, Tungsten)
                .input(foil, NiobiumNitride)
                .fluidInputs(Glass.getFluid(144))
                .output(TUNGSTEN_INDUCTOR_CORE)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[IV])
                .input(plate, SynthDiamond)
                .input(foil, SiliconeRubber)
                .input(nanoWire, Palladium, 32)
                .output(TRANSMON_SUPPORT)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(85)
                .EUt(VA[LuV])
                .input(SAPPHIRE_WAFER)
                .input(plate, GalliumNitride)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(SQUID_BASE)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[ZPM])
                .input(SQUID_BASE)
                .fluidInputs(Helium.getPlasma(5))
                .output(LANGMUIR_OSCILATOR)
                .buildAndRegister();

        GCYSRecipeMaps.MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[UEV])
                .input(LANGMUIR_OSCILATOR)
                .input(dustTiny, GraphenePQD)
                .output(LANGMUIR_HOUSING)
                .buildAndRegister();

        //Xenon Fluoride Superconductive Mix

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[EV])
                .fluidInputs(Xenon.getFluid(1000), Fluorine.getFluid(4000))
                .fluidOutputs(XenonTetraFluoride.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(30)
                .EUt(VA[LV])
                .fluidInputs(XenonTetraFluoride.getFluid(1000), DistilledWater.getFluid(2000))
                .fluidOutputs(HydrofluoricAcid.getFluid(4000), XenonDioxide.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[LuV])
                .fluidInputs(XenonDioxide.getFluid(1000), Acetylene.getFluid(1000), HydrofluoricAcid.getFluid(4000))
                .fluidOutputs(XenonOxyTetraFluoride.getFluid(1000), Ethanol.getFluid(1000))
                .buildAndRegister();

        GCYSRecipeMaps.CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .duration(130)
                .EUt(VA[ZPM])
                .fluidInputs(XenonOxyTetraFluoride.getFluid(3000), BoronTrifluoride.getFluid(2000))
                .fluidOutputs(XenonHexaFluoride.getFluid(3000))
                .output(dust, BoronTrioxide, 5)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[IV])
                .fluidInputs(XenonHexaFluoride.getFluid(1000))
                .input(dustTiny, Lutetium)
                .input(dustTiny, Praseodymium)
                .input(dustTiny, Holmium)
                .input(dustTiny, Lanthanum)
                .input(dustTiny, Thallium)
                .input(dust, Kevlar)
                .fluidOutputs(XenonFluorideSupercondiveMix.getFluid(1000))
                .output(dustTiny, Kevlar, 9)
                .buildAndRegister();
    }
}
