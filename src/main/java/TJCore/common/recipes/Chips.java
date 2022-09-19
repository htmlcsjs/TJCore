package TJCore.common.recipes;

import gregicality.science.api.recipes.GCYSRecipeMaps;
import gregicality.science.loaders.recipe.chain.KaptonChain;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.Material;

import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.api.recipes.GCYSRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.ingot;


public class Chips {

    // Lithography Arrays

    static MetaItem<?>.MetaValueItem[] boule = {SILICON_BOULE, ANTIMONY_DOPED_SILICON_BOULE, BORON_DOPED_SILICON_BOULE, GALLIUM_ARSENIDE_BOULE, SILVER_GALLIUM_SELENIDE_BOULE};
    static MetaItem<?>.MetaValueItem[] rawWafer = {SILICON_WAFER, ANTIMONY_DOPED_SILICON_WAFER, BORON_DOPED_SILICON_WAFER, GALLIUM_ARSENIDE_WAFER, SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] layered = {LAYERED_SILICON_WAFER, LAYERED_ANTIMONY_DOPED_SILICON_WAFER, LAYERED_BORON_DOPED_SILICON_WAFER, LAYERED_GALLIUM_ARSENIDE_WAFER, LAYERED_SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] prepared = {PREPARED_SILICON_WAFER, PREPARED_ANTIMONY_DOPED_SILICON_WAFER, PREPARED_BORON_DOPED_SILICON_WAFER, PREPARED_GALLIUM_ARSENIDE_WAFER, PREPARED_SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] lithPrep = {INTEGRATED_WAFER_LITHOGRAPHY_PREP, MICRO_WAFER_LITHOGRAPHY_PREP, NANO_WAFER_LITHOGRAPHY_PREP, IMC_WAFER_LITHOGRAPHY_PREP, OPTICAL_WAFER_LITHOGRAPHY_PREP};
    static MetaItem<?>.MetaValueItem[] prebaked = {PREBAKED_INTEGRATED_WAFER, PREBAKED_MICRO_WAFER, PREBAKED_NANO_WAFER, PREBAKED_IMC_WAFER, PREBAKED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] treated = {TREATED_INTEGRATED_WAFER, TREATED_MICRO_WAFER, TREATED_NANO_WAFER, TREATED_IMC_WAFER, TREATED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] raw = {RAW_INTEGRATED_WAFER, RAW_MICRO_WAFER, RAW_NANO_WAFER, RAW_IMC_WAFER, RAW_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] baked = {BAKED_INTEGRATED_WAFER, BAKED_MICRO_WAFER, BAKED_NANO_WAFER, BAKED_IMC_WAFER, BAKED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] wafer = {INTEGRATED_WAFER, MICRO_WAFER, NANO_WAFER, IMC_WAFER, OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] etched = {ETCHED_INTEGRATED_WAFER, ETCHED_MICRO_WAFER, ETCHED_NANO_WAFER, ETCHED_IMC_WAFER, ETCHED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] chip = {INTEGRATED_CHIP, MICRO_CHIP, NANO_CHIP, IMC_CHIP, OPTICAL_CHIP};

    static MetaItem<?>.MetaValueItem[] hardMask = {INTEGRATED_HARD_MASK, MICRO_HARD_MASK, NANO_HARD_MASK, IMC_HARD_MASK, OPTICAL_HARD_MASK};
    static Material[] conductor = {Copper, NickelPlatedTin, Electrum, Platinum, ZBLAN};
    static MetaItem<?>.MetaValueItem[] uvEmitter = {UVEMITTER_A, UVEMITTER_B, UVEMITTER_C, UVEMITTER_D, UVEMITTER_E};

    static Material[] polymer = {Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, PolyphenyleneSulfide, Ladder_Poly_P_Phenylene};
    static Material[] printMaterial = {Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, PolyphenyleneSulfide, Polybenzimidazole};
    static Material[] photopolymers = {HydrogenSilsesquioxane, HydrogenSilsesquioxane, HydrogenSilsesquioxane, SU8_Photoresist, SU8_Photoresist};

    public static void registerChips(){
        electronicChip();
        lithographyChips();
        crystalChip();
        wetwareChip();
        biowareChip();
        quantumChip();
        exoticChip();
        cosmicChip();
        supraChip();
    }

    private static void electronicChip() {
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .duration(900)
                .EUt(VA[LV])
                .input(SILICON_WAFER)
                .notConsumable(craftingLens, Glass)
                .output(SIMPLE_CPU_WAFER)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .duration(500)
                .EUt(VA[LV])
                .input(SIMPLE_CPU_WAFER)
                .output(SIMPLE_CPU,4)
                .buildAndRegister();
    }

    private static void lithographyChips() {

        //TODO: CARBON make this recipe not overlap with integrated circuits

        //HARDMASK recipe generation

        for (int i = 0; i < hardMask.length; i++) {
            for (int j = 0; j < printMaterial.length; j++) {
                PRINTER_RECIPES.recipeBuilder()
                        .input(wireFine, printMaterial[j], (48 / (j + 1)))
                        .circuitMeta(i)
                        .output(hardMask[i])
                        .EUt(VA[i + 1])
                        .duration(3000)
                        .buildAndRegister();
            }

        }

        //Wafer generation for each type
        for (int i = 0; i < boule.length; i++) {
            int tierPower = VA[i + 1];

            CUTTER_RECIPES.recipeBuilder()
                    .input(boule[i])
                    .output(rawWafer[i])
                    .EUt(tierPower)
                    .duration(400)
                    .buildAndRegister();

            LAMINATOR_RECIPES.recipeBuilder()
                    .input(rawWafer[i])
                    .input(foil, conductor[i])
                    .fluidInputs(polymer[i].getFluid(16))
                    .output(layered[i])
                    .EUt(tierPower)
                    .duration(400)
                    .buildAndRegister();

            LAMINATOR_RECIPES.recipeBuilder()
                    .input(layered[i])
                    .input(foil, polymer[i], 2)
                    .output(prepared[i])
                    .EUt(30)
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(prepared[i])
                    .input(hardMask[i])
                    .output(lithPrep[i])
                    .EUt(tierPower)
                    .duration(20)
                    .buildAndRegister();

            FURNACE_RECIPES.recipeBuilder()
                    .input(lithPrep[i])
                    .output(prebaked[i])
                    .EUt(30)
                    .duration(600)
                    .buildAndRegister();

            CHEMICAL_BATH_RECIPES.recipeBuilder()
                    .input(prebaked[i])
                    .fluidInputs(photopolymers[i].getFluid(25 * (i + 1)))
                    .output(treated[i])
                    .EUt(tierPower)
                    .duration(60)
                    .buildAndRegister();

            LASER_ENGRAVER_RECIPES.recipeBuilder()
                    .input(treated[i])
                    .notConsumable(uvEmitter[i])
                    .output(raw[i])
                    .EUt(tierPower)
                    .duration(300)
                    .buildAndRegister();

            FURNACE_RECIPES.recipeBuilder()
                    .input(raw[i])
                    .output(baked[i])
                    .EUt(30)
                    .duration(600)
                    .buildAndRegister();

            PACKER_RECIPES.recipeBuilder()
                    .input(baked[i])
                    .outputs(wafer[i].getStackForm(), hardMask[i].getStackForm())
                    .EUt(30)
                    .duration(200)
                    .buildAndRegister();

            CHEMICAL_BATH_RECIPES.recipeBuilder()
                    .input(wafer[i])
                    .fluidInputs(NitricAcid.getFluid(25 * (i + 1)))
                    .output(etched[i])
                    .EUt(tierPower)
                    .duration(20)
                    .buildAndRegister();

            CUTTER_RECIPES.recipeBuilder()
                    .input(etched[i])
                    .output(chip[i], 64)
                    .output(chip[i], 64)
                    .EUt(tierPower)
                    .duration(20)
                    .buildAndRegister();
        }
    }

    private static void crystalChip() {
        //Crystal Chip
        MIXER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(50)
                .input(dust,Diamond)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(DiamondCVDSolution.getFluid(1000))
                .buildAndRegister();

        //TODO: CARBON - Make this CVD recipe
        CVD_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(100)
                .input(SAPPHIRE_WAFER)
                .fluidInputs(DiamondCVDSolution.getFluid(50))
                .output(COATED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(100)
                .input(COATED_SAPPHIRE_WAFER)
                .fluidInputs(Starlight.getFluid(250))
                .output(DIRTY_COATED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(60)
                .input(DIRTY_COATED_SAPPHIRE_WAFER)
                .fluidInputs(Dysprosium.getFluid(144))
                .output(CLEANED_COATED_SAPPHIRE_WAFER)
                .output(ingot,Dysprosium)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(5)
                .input(CLEANED_COATED_SAPPHIRE_WAFER)
                .fluidInputs(Helium.getPlasma(150))
                .output(SAPPHIRE_SUBSTRATE_PREP)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(130)
                .input(SAPPHIRE_SUBSTRATE_PREP)
                .fluidInputs(AquaRegia.getFluid(250))
                .output(ETCHED_SAPPHIRE_WAFER)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(340)
                .blastFurnaceTemp(8600)
                .input(ETCHED_SAPPHIRE_WAFER)
                .notConsumable(Argon.getFluid(1))
                .output(SUPERHEATED_SAPPHIRE_WAFER)
                .buildAndRegister();

        //TODO: ANYONE - Find a way to either/or viable/nonviable here
        VACUUM_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(40)
                .input(SUPERHEATED_SAPPHIRE_WAFER)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(VIABLE_SAPPHIRE_WAFER)
                .fluidOutputs(Steam.getFluid(1000))
                //.chancedOutput(NONVIABLE_SAPPHIRE_WAFER, 5000)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(1000)
                .input(NONVIABLE_SAPPHIRE_WAFER)
                .fluidInputs(Starlight.getFluid(500))
                .output(RECYCLED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(10)
                .input(RECYCLED_SAPPHIRE_WAFER)
                .fluidInputs(Dysprosium.getFluid(288))
                .output(CLEANED_COATED_SAPPHIRE_WAFER)
                .output(ingot ,Dysprosium,2);

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(140)
                .input(VIABLE_SAPPHIRE_WAFER)
                .input(foil,Rutherfordium)
                .output(SINTERED_SAPPHIRE_WAFER)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(30)
                .input(wireFine,Palladium,2)
                .input(SINTERED_SAPPHIRE_WAFER)
                .output(WIRED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(30)
                .input(WIRED_SAPPHIRE_WAFER)
                .output(RAW_SAPPHIRE_CHIP,32)
                .buildAndRegister();


        CANNER_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(65)
                .input(RAW_SAPPHIRE_CHIP)
                .fluidInputs(Neon.getFluid(10))
                .output(SAPPHIRE_CHIP)
                .buildAndRegister();
    }

    private static void wetwareChip() {

    }

    private static void biowareChip() {

    }

    private static void quantumChip() {

    }

    private static void exoticChip() {

    }

    private static void cosmicChip() {

    }

    private static void supraChip() {

    }
}
