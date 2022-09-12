package TJCore.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.Material;

import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.LAMINATOR_RECIPES;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.PRINTER_RECIPES;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static gregtech.api.unification.ore.OrePrefix.wireFine;


public class Chips {

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


    public static void registerLithography() {

        //TODO: CARBON make this recipe not overlap with integrated circuits

        //HARDMASK recipe generation

        for (int i = 0; i < hardMask.length; i++) {
            PRINTER_RECIPES.recipeBuilder()
                    .input(wireFine, printMaterial[i], 48 / (i + 1))
                    .output(hardMask[i])
                    .EUt(VA[i + 1])
                    .duration(3000)
                    .buildAndRegister();
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
}
