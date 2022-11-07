package TJCore.common.recipes;

import TJCore.common.TJConfig;
import TJCore.common.blocks.BlockBearing;
import TJCore.common.metaitem.TJMetaItem;
import TJCore.common.metaitem.TJMetaItems;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;

import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static gregtech.api.unification.material.Materials.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.ore.OrePrefix;
import static gregtech.api.unification.ore.OrePrefix.*;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import scala.tools.nsc.transform.patmat.Logic;
import stanhebben.zenscript.type.casting.CastingRuleVirtualMethod;

import static gregtech.api.recipes.RecipeMaps.*;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.common.items.MetaItems.*;

public class MaterialRecipes {

    public static void register() {
        registerCeramics();
        registerMetals();
        registerSimpleCompounds();
        registerMetalCasings();
        registerModifiedDecomp();
        registerFarming();
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
    }
    public static void registerMetals() {
        registerNickelPlatedTin();
        registerGalvanizedSteel();
        registerSteelChanges();
        registerAluminumChanges();
        registerMixing();
        registerEBF();
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

    public static void registerFarming() {
    }
    public static void registerNickelPlatedTin() {
        OrePrefix[] nickelPlatedTinPrefix = new OrePrefix[]{ingot, plate, plateDouble, foil};
        int tinyQuantity;
        for (OrePrefix prefix : nickelPlatedTinPrefix) {
            tinyQuantity = (int) ((prefix.getMaterialAmount(Steel))/ M) + 1;
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
        removeDoublePlateDecomp(NickelPlatedTin, 98);
        removeBlockIngotNuggetChunkDecomp(NickelPlatedTin);


        ((MetaItem) OreDictUnifier.get(dust, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem) OreDictUnifier.get(dustSmall, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem) OreDictUnifier.get(dustTiny, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem) OreDictUnifier.get(chunk, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        ((MetaItem) OreDictUnifier.get(nugget, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(dust, NickelPlatedTin)).setInvisible();
        //((MetaItem) OreDictUnifier.get(block, NickelPlatedTin).getItem()).getItem(OreDictUnifier.get(block, NickelPlatedTin)).setInvisible();

    }
    public static void registerGalvanizedSteel() {
        OrePrefix[] galvanizedSteelPrefix = new OrePrefix[]{ingot, plate, stick, stickLong, bolt, screw, ring, gear, gearSmall, rotor, round};
        int tinyQuantity;
        for (OrePrefix prefix : galvanizedSteelPrefix) {
            tinyQuantity = (int) ((prefix.getMaterialAmount(Steel))/ M) + 1;
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

        ((MetaItem) OreDictUnifier.get(dust, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem) OreDictUnifier.get(chunk, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem) OreDictUnifier.get(dustSmall, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem) OreDictUnifier.get(nugget, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(nugget, GalvanizedSteel)).setInvisible();
        //TODO: remove this shit block with groovy, you cant cast
        //((MetaItem) OreDictUnifier.get(block, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
        ((MetaItem) OreDictUnifier.get(dustTiny, GalvanizedSteel).getItem()).getItem(OreDictUnifier.get(dust, GalvanizedSteel)).setInvisible();
    }
    public static void registerAluminumChanges() {
        ModHandler.addShapedRecipe("alumina_mold", ALUMINA_MOLD.getStackForm(), " B "," F ", " M ",  'F', OreDictUnifier.get(foil, Carbon), 'M', SHAPE_MOLD_INGOT, 'B', OreDictUnifier.get(wireFine, Carbon));
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
                        .output(ingot, Steel)
                        .buildAndRegister();

                PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                        .duration(j == 2 ? 400 : 60)
                        .input(j == 2 ? block : ingot, WroughtIron)
                        .input(orePrefixes[j], fuels[i], j == 2 ? 1 : 2)
                        .output(ingot, Steel)
                        .buildAndRegister();
            }
        }
    }
    public static void registerCeramics() {

        FURNACE_RECIPES.recipeBuilder()
                .EUt(VA[0])
                .duration(20)
                .input(dust, Silicon)
                .chancedOutput(ingot, Silicon, 5000, 1000)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust,SiliconDioxide,6)
                .output(ingot, SilicaCeramic, 6)
                .EUt(30)
                .duration(420)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust,SiliconDioxide,6)
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
                "   "," S ","HPW",
                'S', SAW,
                'H', HARD_HAMMER,
                'W', WRENCH,
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("small_fluid_pipe_ceramic", OreDictUnifier.get(pipeSmallFluid, SilicaCeramic),
                "   ","WPH","   ",
                'W', WRENCH,
                'H', HARD_HAMMER,
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("normal_fluid_pipe_ceramic", OreDictUnifier.get(pipeNormalFluid, SilicaCeramic),
                "   ","PPP","W H",
                'W', WRENCH,
                'H', HARD_HAMMER,
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        ModHandler.addShapedRecipe("large_fluid_pipe_ceramic", OreDictUnifier.get(pipeLargeFluid, SilicaCeramic),
                "PPP","W H","PPP",
                'W', WRENCH,
                'H', HARD_HAMMER,
                'P', OreDictUnifier.get(plate, SilicaCeramic));

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[MV])
                .input(wireFine, BorosilicateGlass, 4)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(ingot, Fiberglass)
                .buildAndRegister();

    }
    public static void registerModifiedDecomp() {
        ELECTROLYZER_RECIPES.recipeBuilder()
                .duration(55)
                .EUt(VA[LV])
                .input(dust, Stibnite, 5)
                .chancedOutput(dust, Antimony, 2, 1000, 500)
                .output(dust, Sulfur, 3)
                .buildAndRegister();
    }
    public static void registerFrames(OrePrefix prefix, Material mat, DustProperty property) {
        if(mat.hasFlag(GENERATE_FRAME)) {
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
    public static void registerMetalCasings() {

        if(TJConfig.recipes.harderMetalCasings) {
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
    public static void removeFoilDecomp(Material material, int gasAmount) {
        GTRecipeHandler.removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, material)}, new FluidStack[]{Oxygen.getFluid(gasAmount)});
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(foil, material));
        GTRecipeHandler.removeRecipesByInputs(BENDER_RECIPES, OreDictUnifier.get(plate, material), IntCircuitIngredient.getIntegratedCircuit(1));
        ModHandler.removeRecipes(OreDictUnifier.get(foil, material, 2));
    }
    public static void removeDoublePlateDecomp(Material material, int gasAmount) {
        GTRecipeHandler.removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(plateDouble, material)}, new FluidStack[]{Oxygen.getFluid(gasAmount)});
    }
    public static void removeRodLongDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_ROD_LONG.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(stickLong, material));
        GTRecipeHandler.removeRecipesByInputs(FORGE_HAMMER_RECIPES, OreDictUnifier.get(stick, material, 2));
        ModHandler.removeRecipes(OreDictUnifier.get(stickLong, material));
        ModHandler.removeRecipes(OreDictUnifier.get(stick, material, 2));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_ROD_LONG.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{Lubricant.getFluid(1)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{DistilledWater.getFluid(3)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(stickLong, material)}, new FluidStack[]{Water.getFluid(4)});
    }
    public static void removeGearDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material, 4), SHAPE_EXTRUDER_GEAR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(gear, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 4), SHAPE_EXTRUDER_GEAR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material, 8), SHAPE_MOLD_GEAR.getStackForm());
        ModHandler.removeRecipes(OreDictUnifier.get(gear, material));
    }
    public static void removeSmallGearDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(gearSmall, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_GEAR_SMALL.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_GEAR_SMALL.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material,2), SHAPE_MOLD_GEAR_SMALL.getStackForm());
        ModHandler.removeRecipes(OreDictUnifier.get(gearSmall, material));
    }
    public static void removePlateDecomp(Material material, int lube, int distilled, int water) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(plate, material));
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{Lubricant.getFluid(lube)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{DistilledWater.getFluid(distilled)});
        GTRecipeHandler.removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{OreDictUnifier.get(block, material)}, new FluidStack[]{Water.getFluid(water)});
    }
    public static void removeFrameDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(frameGt, material));
    }
    public static void removeBlockIngotNuggetChunkDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(nugget, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(block, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(chunk, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ingot, material));
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(block, material), SHAPE_MOLD_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(nugget, material, 9), SHAPE_MOLD_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(chunk, material, 4), SHAPE_MOLD_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material, 9), SHAPE_MOLD_BLOCK.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_MOLD_CHUNK.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_MOLD_NUGGET.getStackForm());
        ModHandler.removeRecipes(OreDictUnifier.get(chunk, material, 4));
        ModHandler.removeRecipes(OreDictUnifier.get(nugget, material, 9));
        ModHandler.removeRecipes(OreDictUnifier.get(block, material));
        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(ingot, material, 9));
        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(nugget, material, 9));
        GTRecipeHandler.removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(chunk, material, 4));
        ModHandler.removeRecipes(OreDictUnifier.get(ingot, material, 9));
        ModHandler.removeRecipes(OreDictUnifier.get(ingot, material));
    }
    public static void removeExtruderBlockIngot(Material material){
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_INGOT.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 9), SHAPE_EXTRUDER_BLOCK.getStackForm());
    }
    public static void removeSmeltingDecomp(Material material) {
        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dustSmall, material));
        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dustTiny, material));
    }
    public static void removeRoundDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(round, material));
        GTRecipeHandler.removeRecipesByInputs(LATHE_RECIPES, OreDictUnifier.get(nugget, material));
    }
    public static void removeRingDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ring, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material), SHAPE_EXTRUDER_RING.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material), SHAPE_EXTRUDER_RING.getStackForm());
    }
    public static void removeRotorDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(rotor, material));
        ModHandler.removeRecipes(OreDictUnifier.get(rotor, material));
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, material, 4), SHAPE_EXTRUDER_ROTOR.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(dust, material, 4), SHAPE_EXTRUDER_ROTOR.getStackForm());
    }
    public static void removeBoltScrewDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(bolt, material));
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(screw, material));
        ModHandler.removeRecipes(OreDictUnifier.get(bolt, material, 2));
        ModHandler.removeRecipes(OreDictUnifier.get(screw, material));
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
    public static void removeRodDecomp(Material material) {
        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(stick, material));
        GTRecipeHandler.removeRecipesByInputs(LATHE_RECIPES, OreDictUnifier.get(ingot, material));
        ModHandler.removeRecipes(OreDictUnifier.get(stick, material));

    }

}
