package tjcore.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tjcore.common.TJConfig;

import static gregicality.science.api.recipes.GCYSRecipeMaps.CVD_RECIPES;
import static gregicality.science.api.recipes.GCYSRecipeMaps.SONICATION_RECIPES;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_FRAME;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static tjcore.api.material.TJMaterials.*;
import static tjcore.common.metaitem.TJMetaItems.*;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.*;

public class MaterialRecipes {

    public static void register() {
        registerCeramics();
        registerMetals();
        registerSimpleCompounds();
        registerSyntheticDiamond();
        registerMetalCasings();
        registerModifiedDecomp();
        registerFarming();
        registerWireCable();
        registerCobalt();
    }

    public static void registerSimpleCompounds() {

        MIXER_RECIPES.recipeBuilder()
                .duration(35)
                .EUt(VA[LV])
                .input(dust, Silver)
                .input(dust, Lead)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, SilverLeadOxide, 3)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .duration(280)
                .EUt(8)
                .input(STICKY_RESIN, 2)
                .chancedOutput(plate, Rubber, 1, 700, 0)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(340)
                .notConsumable(plate, Gold)
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(4000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(HydroiodicAcid.getFluid(4000))
                .input(dust, Hafnium)
                .output(dust, HafniumSilicate)
                .buildAndRegister();
    }

    public static void registerMetals() {
        registerNickelPlatedTin();
        registerGalvanizedSteel();
        registerSteelChanges();
        registerAluminumChanges();
        registerMixing();
        registerEBF();

    }

    private static void registerWireCable() {

    }

    private static void registerMixing() {
        MIXER_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(40)
                .input(dust, Aluminium, 5)
                .input(dust, Manganese)
                .input(dust, Magnesium)
                .output(dust, Birmabright, 7)
                .buildAndRegister();
    }

    private static void registerEBF() {

    }

    private static void registerFarming() {

    }

    private static void registerSyntheticDiamond() {
        MIXER_RECIPES.recipeBuilder()
                .EUt(VA[HV])
                .duration(55)
                .input(dust, Graphite)
                .fluidInputs(Propane.getFluid(1000))
                .fluidOutputs(DiamondSonicationSolution.getFluid(1000))
                .buildAndRegister();

        SONICATION_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(90)
                .fluidInputs(DiamondSonicationSolution.getFluid(1000), Methane.getFluid(100))
                .fluidOutputs(Butene.getFluid(1000))
                .chancedOutput(dustTiny, SynthDiamond, 1500, 100)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(145)
                .fluidInputs(Methane.getFluid(100), Hydrogen.getFluid(10000))
                .notConsumable(gemExquisite, SynthDiamond)
                .output(gem, SynthDiamond)
                .buildAndRegister();
    }

    private static void registerNickelPlatedTin() {
        OrePrefix[] nickelPlatedTinPrefix = new OrePrefix[]{ingot, plate, plateDouble, foil};
        int tinyQuantity;
        for (OrePrefix prefix : nickelPlatedTinPrefix) {
            tinyQuantity = (int) ((prefix.getMaterialAmount(Steel)) / M) + 1;
            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .duration(tinyQuantity * 15)
                    .EUt(8)
                    .input(prefix, Tin, 1)
                    .input(dustTiny, Nickel, tinyQuantity)
                    .output(prefix, NickelPlatedTin)
                    .buildAndRegister();
        }
        removeSmeltingDecomp(NickelPlatedTin);
        removePlateDecomp(NickelPlatedTin, 18, 55, 73);
        removeFoilDecomp(NickelPlatedTin, 24);

        //TODO CEu 2.5.0
//        removeDoublePlateDecomp(NickelPlatedTin, 98);
        removeBlockIngotNuggetChunkDecomp(NickelPlatedTin);


        ((MetaItem<?>) OreDictUnifier.get(dust, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem<?>) OreDictUnifier.get(dustSmall, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem<?>) OreDictUnifier.get(dustTiny, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
//        ((MetaItem<?>) OreDictUnifier.get(chunk, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible(); //TODO Chunks
        ((MetaItem<?>) OreDictUnifier.get(nugget, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        //((MetaItem<?>) OreDictUnifier.get(block, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(block, NickelPlatedTin)).setInvisible();

    }

    private static void registerGalvanizedSteel() {
        OrePrefix[] galvanizedSteelPrefix = new OrePrefix[]{ingot, plate, stick, stickLong, bolt, screw, ring, gear, gearSmall, rotor, round};
        int tinyQuantity;
        for (OrePrefix prefix : galvanizedSteelPrefix) {
            tinyQuantity = (int) ((prefix.getMaterialAmount(Steel)) / M) + 1;
            ALLOY_SMELTER_RECIPES.recipeBuilder()
                    .duration(tinyQuantity * 15)
                    .EUt(8)
                    .input(prefix, Steel, 1)
                    .input(dustTiny, Zinc, tinyQuantity)
                    .output(prefix, GalvanizedSteel)
                    .buildAndRegister();
        }
        removeExtruderBlockIngot(GalvanizedSteel);
        removeRotorDecomp(GalvanizedSteel);
        removeRodDecomp(GalvanizedSteel);
        removeRodLongDecomp(GalvanizedSteel);
        removeBoltScrewDecomp(GalvanizedSteel);
        removeGearDecomp(GalvanizedSteel);
        removeSmallGearDecomp(GalvanizedSteel);
        removeFrameDecomp(GalvanizedSteel);
        removePlateDecomp(GalvanizedSteel, 10, 31, 42);
        removeBlockIngotNuggetChunkDecomp(GalvanizedSteel);
        removeSmeltingDecomp(GalvanizedSteel);
        removeRoundDecomp(GalvanizedSteel);
        removeRingDecomp(GalvanizedSteel);

        /**
         * TODO: Use {@link OrePrefix#setIgnored(Material)}
         */
        ((MetaItem<?>) OreDictUnifier.get(dust, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
//        ((MetaItem<?>) OreDictUnifier.get(chunk, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible(); //TODO Chunks
        ((MetaItem<?>) OreDictUnifier.get(dustSmall, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem<?>) OreDictUnifier.get(nugget, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(nugget, GalvanizedSteel)).setInvisible();
        //TODO: remove this shit block with groovy, you cant cast
        //((MetaItem<?>) OreDictUnifier.get(block, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem<?>) OreDictUnifier.get(dustTiny, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
    }

    private static void registerAluminumChanges() {
        ModHandler.addShapedRecipe("alumina_mold", ALUMINA_MOLD.getStackForm(), " B ", " F ", " M ", 'F', OreDictUnifier.get(foil, Carbon), 'M', SHAPE_MOLD_INGOT, 'B', OreDictUnifier.get(wireFine, Carbon));
        ModHandler.addShapelessRecipe("full_alumina_mold", FULL_ALUMINA_MOLD.getStackForm(),
                ALUMINA_MOLD.getStackForm(),
                new UnificationEntry(dust, Alumina),
                new UnificationEntry(dust, Alumina),
                new UnificationEntry(dust, Alumina),
                new UnificationEntry(dust, Alumina),
                new UnificationEntry(dust, Alumina));

        ModHandler.addSmeltingRecipe(FULL_ALUMINA_MOLD.getStackForm(), HOT_ALUMINA_MOLD.getStackForm(), 1);
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[ULV])
                .duration(40)
                .fluidInputs(Water.getFluid(50))
                .input(HOT_ALUMINA_MOLD)
                .output(ALUMINA_MOLD)
                .output(ingot, Aluminium, 2)
                .buildAndRegister();
    }

    private static void registerSteelChanges() {
        GTRecipeHandler.removeAllRecipes(PRIMITIVE_BLAST_FURNACE_RECIPES);
        Material[] fuels = new Material[]{Coal, Charcoal, Coke};
        OrePrefix[] orePrefixes = new OrePrefix[]{dust, gem, block};
        for (int i = 0; i < fuels.length; i++) {
            for (int j = 0; j < orePrefixes.length; j++) {
                PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                        .duration(j == 2 ? 600 : 80)
                        .input(j == 2 ? block : ingot, Iron)
                        .input(orePrefixes[j], fuels[i], j == 2 ? 1 : 2)
                        .output(j == 2 ? block : ingot, Steel)
                        .buildAndRegister();

                PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                        .duration(j == 2 ? 400 : 60)
                        .input(j == 2 ? block : ingot, WroughtIron)
                        .input(orePrefixes[j], fuels[i], j == 2 ? 1 : 2)
                        .output(j == 2 ? block : ingot, Steel)
                        .buildAndRegister();
            }
        }
    }

    private static void registerCeramics() {

        FURNACE_RECIPES.recipeBuilder()
                .EUt(VA[0])
                .duration(20)
                .input(dust, Silicon)
                .chancedOutput(ingot, Silicon, 5000, 1000)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 6)
                .output(ingot, SilicaCeramic, 6)
                .EUt(30)
                .duration(420)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 6)
                .input(dustTiny, Nickel)
                .output(ingot, SilicaCeramic, 6)
                .EUt(VA[0])
                .duration(120)
                .buildAndRegister();

        removePlateDecomp(SilicaCeramic, 18, 55, 73);

        CUTTER_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(100)
                .input(block, SilicaCeramic)
                .output(plate, SilicaCeramic, 9)
                .buildAndRegister();

        ModHandler.addShapedRecipe("tiny_fluid_pipe_ceramic", OreDictUnifier.get(pipeTinyFluid, SilicaCeramic, 2),
                "   ", " s ", "hPw",
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("small_fluid_pipe_ceramic", OreDictUnifier.get(pipeSmallFluid, SilicaCeramic),
                "   ", "wPh", "   ",
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("normal_fluid_pipe_ceramic", OreDictUnifier.get(pipeNormalFluid, SilicaCeramic),
                "   ", "PPP", "w h",
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("large_fluid_pipe_ceramic", OreDictUnifier.get(pipeLargeFluid, SilicaCeramic),
                "PPP", "w h", "PPP",
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[MV])
                .input(wireFine, BorosilicateGlass, 4)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(ingot, Fiberglass)
                .buildAndRegister();

    }

    private static void registerModifiedDecomp() {
        ELECTROLYZER_RECIPES.recipeBuilder()
                .duration(55)
                .EUt(VA[LV])
                .input(dust, Stibnite, 5)
                .chancedOutput(dust, Antimony, 2, 1000, 500)
                .output(dust, Sulfur, 3)
                .buildAndRegister();
    }

    public static void registerFrames(OrePrefix prefix, Material mat, DustProperty property) {
        if (mat.hasFlag(GENERATE_FRAME)) {
            ModHandler.removeRecipeByName(String.format("gregtech:frame_%s", mat));
            ModHandler.addShapedRecipe(String.format("frame1_%s", mat),
                    OreDictUnifier.get(prefix, mat, 1),
                    "PLP", "LwL", "LLL",
                    'P', new UnificationEntry(OrePrefix.plate, mat),
                    'L', new UnificationEntry(OrePrefix.stick, mat));
            GTRecipeHandler.removeRecipesByInputs(RecipeMaps.ASSEMBLER_RECIPES, OreDictUnifier.get(OrePrefix.stick, mat, 4), IntCircuitIngredient.getIntegratedCircuit(4));

            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                    .input(OrePrefix.stick, mat, 5)
                    .circuitMeta(4)
                    .outputs(OreDictUnifier.get(prefix, mat, 1))
                    .EUt(VA[LV])
                    .duration(64)
                    .buildAndRegister();
        }
    }

    public static void registerCobalt() {
        CHEMICAL_RECIPES.recipeBuilder()
                .EUt(VA[MV])
                .duration(130)
                .input(dust, Cobalt)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(CobaltChloride.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .EUt(VA[MV])
                .duration(230)
                .input(dust, Iodine, 4)
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(Hydrazine.getFluid(1000))
                .fluidOutputs(ImpureHydroiodicAcid.getFluid(2000))
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .EUt(VA[MV])
                .duration(155)
                .fluidInputs(ImpureHydroiodicAcid.getFluid(1000))
                .fluidOutputs(HydroiodicAcid.getFluid(2000))
                .fluidOutputs(Nitrogen.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .EUt(VA[MV])
                .duration(90)
                .fluidInputs(CobaltChloride.getFluid(1000))
                .fluidInputs(HydroiodicAcid.getFluid(1000))
                .fluidOutputs(CobaltIodide.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(330)
                .fluidInputs(CobaltIodide.getFluid(1000))
                .fluidOutputs(Cobalt59Iodide.getFluid(950))
                .fluidOutputs(Cobalt60Iodide.getFluid(50))
                .buildAndRegister();

        EXPOSURE_CHAMBER_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(180)
                .input(dust, Cobalt59)
                .output(dust, Cobalt)
                .notConsumable(EMITTER_IV)
                .buildAndRegister();
    }

    public static void registerMetalCasings() {

        if (TJConfig.recipes.harderMetalCasings) {
            ModHandler.removeRecipeByName("gregtech:casing_coke_bricks");
            ModHandler.removeRecipeByName("gregtech:casing_bronze_bricks");
            ModHandler.removeRecipeByName("gregtech:casing_steel_solid");
            ModHandler.removeRecipeByName("gregtech:casing_titanium_stable");
            ModHandler.removeRecipeByName("gregtech:casing_invar_heatproof");
            ModHandler.removeRecipeByName("gregtech:casing_aluminium_frostproof");
            ModHandler.removeRecipeByName("gregtech:casing_stainless_clean");
            ModHandler.removeRecipeByName("gregtech:casing_tungstensteel_robust");
            ModHandler.removeRecipeByName("gregtech:casing_hssg_robust");
            RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                    .input(frameGt, Steel)
                    .input(plate, Steel, 6)
                    .input(screw, Steel, 24)
                    .circuitMeta(2)
                    .outputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID, 1))
                    .EUt(VA[LV])
                    .duration(80)
                    .buildAndRegister();
        }
    }

    // Decompisition / Conversion Recipe Removal
    private static void removeFoilDecomp(Material material, int gasAmount) {
        GTRecipeHandler.removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, material)}, new FluidStack[]{Oxygen.getFluid(gasAmount)});
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(foil, material));
        GTRecipeHandler.removeRecipesByInputs(BENDER_RECIPES, OreDictUnifier.get(plate, material), IntCircuitIngredient.getIntegratedCircuit(1));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(foil, material, 2));
    }

    private static void removeDoublePlateDecomp(Material material, int gasAmount) {
        GTRecipeHandler.removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(plateDouble, material)}, new FluidStack[]{Oxygen.getFluid(gasAmount)});
    }

    private static void removeRodLongDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_ROD_LONG.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(stickLong, material));
        GTRecipeHandler.removeRecipesByInputs(FORGE_HAMMER_RECIPES, OreDictUnifier.get(stick, material, 2));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(stickLong, material));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(stick, material, 2));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_ROD_LONG.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{Lubricant.getFluid(1)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{DistilledWater.getFluid(3)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{Water.getFluid(4)});
    }

    private static void removeGearDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material, 4), SHAPE_EXTRUDER_GEAR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(gear, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 4), SHAPE_EXTRUDER_GEAR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material, 8), SHAPE_MOLD_GEAR.getStackForm());
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(gear, material));
    }

    private static void removeSmallGearDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(gearSmall, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_GEAR_SMALL.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_GEAR_SMALL.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material, 2), SHAPE_MOLD_GEAR_SMALL.getStackForm());
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(gearSmall, material));
    }

    private static void removePlateDecomp(Material material, int lube, int distilled, int water) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(plate, material));
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{Lubricant.getFluid(lube)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{DistilledWater.getFluid(distilled)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{Water.getFluid(water)});
    }

    private static void removeFrameDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(frameGt, material));
    }

    private static void removeBlockIngotNuggetChunkDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(nugget, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(block, material));
//        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(chunk, material)); //TODO Chunks
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ingot, material));
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(block, material), SHAPE_MOLD_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(nugget, material, 9), SHAPE_MOLD_INGOT.getStackForm());
//        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(chunk, material, 4), SHAPE_MOLD_INGOT.getStackForm()); //TODO Chunks
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material, 9), SHAPE_MOLD_BLOCK.getStackForm());
//        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_MOLD_CHUNK.getStackForm()); //TODO Chunks
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_MOLD_NUGGET.getStackForm());
//        ModHandler.removeRecipes(OreDictUnifier.get(chunk, material, 4)); //TODO Chunks
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(nugget, material, 9));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(block, material));
        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(ingot, material, 9));
        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(nugget, material, 9));
//        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(chunk, material, 4)); //TODO Chunks
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(ingot, material, 9));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(ingot, material));
    }

    private static void removeExtruderBlockIngot(Material material) {
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 9), SHAPE_EXTRUDER_BLOCK.getStackForm());
    }

    private static void removeSmeltingDecomp(Material material) {
        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dustSmall, material));
        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dustTiny, material));
    }

    private static void removeRoundDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(round, material));
        GTRecipeHandler.removeRecipesByInputs(LATHE_RECIPES, OreDictUnifier.get(nugget, material));
    }

    private static void removeRingDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ring, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_RING.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_RING.getStackForm());
    }

    private static void removeRotorDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(rotor, material));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(rotor, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 4), SHAPE_EXTRUDER_ROTOR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material, 4), SHAPE_EXTRUDER_ROTOR.getStackForm());
    }

    private static void removeBoltScrewDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(bolt, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(screw, material));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(bolt, material, 2));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(screw, material));
        GTRecipeHandler.removeRecipesByInputs(LATHE_RECIPES, OreDictUnifier.get(bolt, material));
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stick, material)}, new FluidStack[]{Lubricant.getFluid(1)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stick, material)}, new FluidStack[]{DistilledWater.getFluid(3)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stick, material)}, new FluidStack[]{Water.getFluid(4)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(screw, material)}, new FluidStack[]{Lubricant.getFluid(1)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(screw, material)}, new FluidStack[]{DistilledWater.getFluid(3)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(screw, material)}, new FluidStack[]{Water.getFluid(4)});
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_BOLT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_BOLT.getStackForm());
    }

    private static void removeRodDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(stick, material));
        GTRecipeHandler.removeRecipesByInputs(LATHE_RECIPES, OreDictUnifier.get(ingot, material));
        ModHandler.removeRecipeByOutput(OreDictUnifier.get(stick, material));

    }

}
