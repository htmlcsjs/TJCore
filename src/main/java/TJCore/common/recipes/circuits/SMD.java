package TJCore.common.recipes.circuits;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;


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


        // RESISTORS

        // CAPACITORS

        ModHandler.addShapedRecipe("capcitor", CAPACITOR.getStackForm(3),
                " F ", "WDW", " F ",
                'F', OreDictUnifier.get(foil, Copper),
                'D', OreDictUnifier.get(dustTiny, Glass),
                'W', OreDictUnifier.get(wireFine, Tin));

        // DIODES

        ModHandler.addShapedRecipe("diode", DIODE.getStackForm(4),
                " F ", "PDP", " F ",
                'F', OreDictUnifier.get(wireFine, Copper),
                'D', OreDictUnifier.get(foil, Gallium),
                'P', OreDictUnifier.get(plate, Glass));

        // INDUCTORS

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
                .input(nanowire, Palladium, 32)
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
