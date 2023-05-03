package tjcore.common.recipes;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.ToolItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tjcore.common.blocks.BlockBearing;
import tjcore.common.blocks.BlockGeneratorCoil;
import tjcore.common.blocks.BlockTurbineBlades;
import tjcore.common.blocks.TJMetaBlocks;
import tjcore.common.pipelike.rotation.TileEntityRotationAxle;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.EXTRUDER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS;
import static gregtech.common.blocks.MetaBlocks.FRAMES;
import static gregtech.common.blocks.MetaBlocks.MACHINE_CASING;
import static gregtech.common.items.MetaItems.ELECTRIC_MOTOR_LV;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_ROD;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static net.minecraft.init.Blocks.IRON_BARS;
import static tjcore.api.TJComponents.*;
import static tjcore.api.material.TJMaterials.*;
import static tjcore.common.blocks.BlockTurbineBlades.TurbineBladesType.*;
import static tjcore.common.blocks.TJMetaBlocks.BLOCK_GENERATOR_COIL;
import static tjcore.common.blocks.TJMetaBlocks.ROTATION_AXLE;
import static tjcore.common.metaitem.TJMetaItems.*;
import static tjcore.common.metatileentities.TJMetaTileEntities.*;
import static tjcore.common.recipes.GTComponents.tierCircuitNames;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.*;

public class MachineRecipes {

    static BlockMachineCasing.MachineCasingType[] machineCasingTypes = new BlockMachineCasing.MachineCasingType[] {BlockMachineCasing.MachineCasingType.ULV, BlockMachineCasing.MachineCasingType.LV, BlockMachineCasing.MachineCasingType.MV, BlockMachineCasing.MachineCasingType.HV, BlockMachineCasing.MachineCasingType.EV, BlockMachineCasing.MachineCasingType.IV, BlockMachineCasing.MachineCasingType.LuV, BlockMachineCasing.MachineCasingType.ZPM, BlockMachineCasing.MachineCasingType.UV, BlockMachineCasing.MachineCasingType.UHV, BlockMachineCasing.MachineCasingType.UEV, BlockMachineCasing.MachineCasingType.UIV, BlockMachineCasing.MachineCasingType.UXV, BlockMachineCasing.MachineCasingType.OpV, BlockMachineCasing.MachineCasingType.MAX};
    static Material[] cableGtSingleOld = new Material[]{RedAlloy, Tin, Copper, Gold, Aluminium, Platinum, NiobiumTitanium, VanadiumGallium, YttriumBariumCuprate, Europium};
    static Material[] hullPolymerOld = new Material[]{Polyethylene, Polyethylene, Polyethylene, Polyethylene, Polyethylene, Polytetrafluoroethylene, Polytetrafluoroethylene, Polybenzimidazole, Polybenzimidazole, Polybenzimidazole};
    static Material[] hullPolymerNew = new Material[]{Rubber, Rubber, Rubber, Polyethylene, Polyethylene, Polytetrafluoroethylene, Polytetrafluoroethylene, Polybenzimidazole, Polybenzimidazole, Polyetheretherketone, Polyetheretherketone, Kevlar, Kevlar, Fullerene};
    static Material[] hullMaterialNew = new Material[]{WroughtIron, GalvanizedSteel, Aluminium, StainlessSteel, Titanium, TungstenSteel, LutetiumTantalate, Iridrhodruthenium, Tritanium, Bohrium, Adamantium, Vibranium, ProgrammableMatter, HeavyQuarkDegenerate};
    static Material[] hullMaterialOld = new Material[]{WroughtIron, Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, RhodiumPlatedPalladium, NaquadahAlloy, Darmstadtium, Orichalcum, Adamantium, null, null, null};

    static Material[] secondaryHullMaterial = new Material[]{Brass, Steel, GalvanizedSteel, Chrome, Ultimet, Palladium, Iridium, HSSS, Duranium, Seaborgium, HDCS_1, HDCS_2, HDCS_3, SuperheavyL};
    static Material[] cableGtSingleNew = new Material[]{Lead, Tin, Copper, Silver, Aluminium, Platinum, NiobiumTitanium, VanadiumGallium, YttriumBariumCuprate, Pikyonium, PedotTMA, NihoniumTriiodide, Taranium, OganessonTetraTennesside};

    public static void registerMachines() {
        removeOldMachines();
        registerHulls();
        registerElectric();
        registerSteam();
        registerMulti();
        registerGenerator();
    }

    private static void removeOldMachines() {
        ModHandler.removeRecipeByOutput(STEAM_MACERATOR_BRONZE.getStackForm());
        removeAllTeirs(TRANSFORMER);
        removeAllTeirs(STEAM_TURBINE);
        removeAllTeirs(COMBUSTION_GENERATOR);
        removeAllTeirs(GAS_TURBINE);
        removeAllTeirs(MetaTileEntities.HULL);
        for (int i = ULV; i < MAX; i++) {
            if (i < UEV) {
                GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                        new ItemStack[] {MACHINE_CASING.getItemVariant(machineCasingTypes[i]), OreDictUnifier.get(cableGtSingle, cableGtSingleOld[i], 2)},
                        new FluidStack[]{hullPolymerOld[i].getFluid(288)}
                );
            }
        }
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[] {MACHINE_CASING.getItemVariant(machineCasingTypes[MV]), OreDictUnifier.get(cableGtSingle, AnnealedCopper, 2)},
                new FluidStack[]{hullPolymerOld[MV].getFluid(288)}
        );
    }

    private static void removeAllTeirs(MetaTileEntity[] mteIn) {
        for (MetaTileEntity mte: mteIn) {
            if (mte != null) {
                ModHandler.removeRecipeByOutput(mte.getStackForm());
            }
        }
    }


    private static void registerHulls() {


        for (int i = 0; i < MAX; i++) {
            if (i < UIV) {
                ModHandler.removeRecipeByOutput(MACHINE_CASING.getItemVariant(machineCasingTypes[i]));
                //TODO CEu 2.5.0
//                if (i != UEV) GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(plate, hullMaterialOld[i], 8), IntCircuitIngredient.getIntegratedCircuit(8));
                //System.out.println("\nDebug- Attempting to remove recipe inputs:\n8x " + hullMaterialOld[i].getLocalizedName() + " plate 8\nIntCircuit Config: 8");
            }

            OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(machineCasingTypes[i]), new ItemMaterialInfo(
                    new MaterialStack(i == 1 ? Steel : hullMaterialNew[i], M*4)
            ));

            OreDictUnifier.registerOre(MetaTileEntities.HULL[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(i == 1 ? Steel : hullMaterialNew[i], M*5),
                    new MaterialStack(hullPolymerNew[i], M*2),
                    new MaterialStack(cableGtSingleNew[i], M)
            ));

            ModHandler.addShapedRecipe("machine_casing_" + VN[i].toLowerCase(), MACHINE_CASING.getItemVariant(machineCasingTypes[i]),
                    "BhB","PFP","BwB",
                    'B', new UnificationEntry(bolt, secondaryHullMaterial[i]),
                    'P', new UnificationEntry(plate, hullMaterialNew[i]),
                    'F', new UnificationEntry(frameGt, hullMaterialNew[i])
            );
            ModHandler.addShapedRecipe(MetaTileEntities.HULL[i].getMetaName(), MetaTileEntities.HULL[i].getStackForm(),
                    "   ","PMP","CHC",
                    'P', new UnificationEntry(plate, hullPolymerNew[i]),
                    'M', new UnificationEntry(plate, hullMaterialNew[i]),
                    'C', new UnificationEntry(cableGtSingle, cableGtSingleNew[i]),
                    'H', MACHINE_CASING.getItemVariant(machineCasingTypes[i])
            );

            ASSEMBLER_RECIPES.recipeBuilder()
                    .duration(80)
                    .EUt(VA[i + 1])
                    .input(plate, hullMaterialNew[i], 2)
                    .input(frameGt, hullMaterialNew[i])
                    .circuitMeta(4)
                    .outputs(MACHINE_CASING.getItemVariant(machineCasingTypes[i]))
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .duration(80)
                    .EUt(VA[i + 1])
                    .inputs(MACHINE_CASING.getItemVariant(machineCasingTypes[i]))
                    .input(plate, hullMaterialNew[i])
                    .input(cableGtSingle, cableGtSingleNew[i], 2)
                    .fluidInputs(hullPolymerNew[i].getFluid(288))
                    .circuitMeta(4)
                    .outputs(MetaTileEntities.HULL[i].getStackForm())
                    .buildAndRegister();
        }
    }
    private static void registerElectric() {
        MetaTileEntityLoader.registerMachineRecipe(PRINTER, "WRW", "PSP", "CHC", 'P', PISTON, 'W', COIL_HEATING, 'R', RING, 'S', SUBSTRATE, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(LAMINATOR, "WGW", "MHM", "CGC", 'M', MOTOR, 'G', COIL_ELECTRIC, 'W', CABLE, 'H', CraftingComponent.HULL, 'C', CIRCUIT);
        MetaTileEntityLoader.registerMachineRecipe(TRANSFORMER, "   ","FHC","   ", 'F', CABLE_QUAD, 'C', CABLE_TIER_UP, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(SPINNING_MACHINE, "GRG","CMC","WHW", 'G', GLASS, 'R', RODSTICK, 'C', CIRCUIT, 'M', MOTOR, 'W', CABLE, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(DRYER, "WSW", "CHC", "WSW", 'W', CABLE, 'S', SPRING, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
    }

    private static void registerSteam() {

        ModHandler.addShapedRecipe("steam_component_assembler", STEAM_ASSEMBLER.getStackForm(),
                "TGT", "PHP", "SUS",
                'G', OreDictUnifier.get(gearSmall, Steel),
                'T', OreDictUnifier.get(pipeNormalFluid, Bronze),
                'U', STEAM_PUMP.getStackForm(),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                'P', STEAM_PISTON.getStackForm(),
                'S', OreDictUnifier.get(pipeTinyFluid, Steel));

        ModHandler.addShapedRecipe("steam_mixer_bronze", STEAM_MIXER_BRONZE.getStackForm(),
                "GRG", "GMG", "PHP",
                'G', OreDictUnifier.get("blockGlass"),
                'R', OreDictUnifier.get(rotor, Bronze),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                'P', OreDictUnifier.get(pipeNormalFluid, Bronze),
                'M', STEAM_MOTOR);
        ModHandler.addShapedRecipe("steam_mixer_steel", STEAM_MIXER_STEEL.getStackForm(),
                "GRG", "GMG", "PHP",
                'G', OreDictUnifier.get("blockGlass"),
                'R', OreDictUnifier.get(rotor, Steel),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                'P', OreDictUnifier.get(pipeNormalFluid, TinAlloy),
                'M', STEAM_MOTOR);
        ModHandler.addShapedRecipe("steam_dryer_bronze", STEAM_DRYER_BRONZE.getStackForm(),
                "PGP", "PHP", "PLP",
                'L', OreDictUnifier.get(plateDouble,Copper),
                'G', OreDictUnifier.get("blockGlass"),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_BRICKS_HULL),
                'P', OreDictUnifier.get(pipeTinyFluid, Bronze));
        ModHandler.addShapedRecipe("steam_dryer_steel", STEAM_DRYER_STEEL.getStackForm(),
                "PGP", "PHP", "PLP",
                'L', OreDictUnifier.get(plateDouble,Cupronickel),
                'G', OreDictUnifier.get("blockGlass"),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_BRICKS_HULL),
                'P', OreDictUnifier.get(pipeTinyFluid, TinAlloy));
        ModHandler.addShapedRecipe("steam_macerator_bronze_alternate", STEAM_MACERATOR_BRONZE.getStackForm(),
                "GPG", "PHP", "IPI",
                'G', OreDictUnifier.get(gear, WroughtIron),
                'P', OreDictUnifier.get(pipeSmallFluid, Bronze),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                'I', STEAM_PISTON.getStackForm());
    }

    private static void registerMulti() {
        ModHandler.addShapedRecipe("modular_steam_turbine", MODULAR_TURBINE.getStackForm(),
                "PGP", "SCS", "TRT",
                'G', OreDictUnifier.get(gear, Steel),
                'S', OreDictUnifier.get(screw, GalvanizedSteel),
                'R', OreDictUnifier.get(spring, Steel),
                'T', OreDictUnifier.get(plate, Rubber),
                'P', OreDictUnifier.get(pipeLargeFluid, Steel),
                'C', MetaTileEntities.HULL[LV].getStackForm());

        ModHandler.addShapedRecipe("primitive_tree_farmer", PRIMITIVE_TREE_FARMER.getStackForm(),
                "GAG", "DBD", "PCP",
                'G', OreDictUnifier.get(gearSmall, Bronze),
                'A', OreDictUnifier.get(plate, Invar), //TODO find replacement for toolHeadAxe
                'D', new ItemStack(Blocks.DIRT),
                'B', new ItemStack(Blocks.BRICK_BLOCK),
                'P', OreDictUnifier.get(pipeNormalFluid, Wood),
                'C', WOODEN_CRATE.getStackForm());

        ModHandler.addShapedRecipe("alternator", ALTERNATOR.getStackForm(),
                "AWA", "CHC", "AWA",
                'A', new UnificationEntry(circuit, tierCircuitNames[LV]),
                'W', OreDictUnifier.get(wireGtDouble, Tin),
                'H', MetaTileEntities.HULL[LV].getStackForm(),
                'C', TJMetaBlocks.BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.TIN));

        ModHandler.addShapedRecipe("primitive_roaster", PRIMITIVE_ROASTER.getStackForm(),
            "BhB", "BIB", "BPB",
                'I', new ItemStack(IRON_BARS),
                'B', MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS),
                'P', OreDictUnifier.get(plate, Iron));

        ModHandler.addShapedRecipe("roaster", ROASTER.getStackForm(),
        "HHH", "HFH", "WCW",
                'H', MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF),
                'F', new ItemStack(Blocks.FURNACE),
                'W', OreDictUnifier.get(cableGtSingle, Copper),
                'C', new UnificationEntry(circuit, tierCircuitNames[HV])
        );
        ModHandler.addShapelessRecipe("magnetic_iron_block", OreDictUnifier.get(block, IronMagnetic),
                OreDictUnifier.get(ingot, Iron),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone),
                OreDictUnifier.get(dust, Redstone));



    }

    private static void registerGenerator() {
        BlockTurbineBlades.TurbineBladesType[] bladeTypes = new BlockTurbineBlades.TurbineBladesType[] {GALVANIZED_STEEL_BLADES, ALUMINUM_BLADES, STAINLESS_STEEL_BLADES, TITANIUM_BLADES, TUNGSTENSTEEL_BLADES};
        BlockBearing.BearingType[] bearingTypes = new BlockBearing.BearingType[] {BlockBearing.BearingType.GALVANIZED_STEEL_BEARING, BlockBearing.BearingType.ALUMINUM_BEARING, BlockBearing.BearingType.STAINLESS_STEEL_BEARING, BlockBearing.BearingType.TITANIUM_BEARING, BlockBearing.BearingType.TUNGSTENSTEEL_BEARING};
        Material[] bladeMaterial = new Material[]{GalvanizedSteel, Aluminium, StainlessSteel, Titanium, TungstenSteel};
        Material[] secondaryMaterial = new Material[]{Steel, Birmabright, Nichrome, BT6, Tungsten};
        for (int i = 0; i < 5; i++) {
            ModHandler.addShapedRecipe(bladeMaterial[i].getUnlocalizedName() + "_turbine_blades", TJMetaBlocks.TURBINE_BLADES.getItemVariant(bladeTypes[i]),
                    "PSP", "PGP", "RLR",
                    'P', OreDictUnifier.get(plate, bladeMaterial[i]),
                    'S', OreDictUnifier.get(screw, secondaryMaterial[i]),
                    'G', OreDictUnifier.get(spring, secondaryMaterial[i]),
                    'R', OreDictUnifier.get(ring, bladeMaterial[i]),
                    'L', OreDictUnifier.get(stickLong, secondaryMaterial[i]));
            ModHandler.addShapedRecipe(bladeMaterial[i].getUnlocalizedName() + "_turbine_bearing", TJMetaBlocks.BLOCK_BEARING.getItemVariant(bearingTypes[i]),
                    "PSP", "SRS", "PSP",
                    'P', OreDictUnifier.get(plate, bladeMaterial[i]),
                    'S', OreDictUnifier.get(stick, secondaryMaterial[i]),
                    'R', OreDictUnifier.get(ring, bladeMaterial[i]));
        }

        ModHandler.addShapedRecipe("generator_coil_tin", TJMetaBlocks.BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.TIN),
                "WSW", "WFW", "WSW",
                'W', OreDictUnifier.get(wireGtDouble, Tin),
                'S', OreDictUnifier.get(bolt, GalvanizedSteel),
                'F', FRAMES.get(GalvanizedSteel));

        SPINNING_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[LV])
                .input(frameGt, GalvanizedSteel)
                .input(wireFine, Tin, 24)
                .outputs(BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.TIN))
                .buildAndRegister();

        SPINNING_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[MV])
                .input(frameGt, Aluminium)
                .input(wireFine, Copper, 24)
                .outputs(BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.COPPER))
                .buildAndRegister();

        SPINNING_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[HV])
                .input(frameGt, StainlessSteel)
                .input(wireFine, Electrum, 24)
                .outputs(BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.ELECTRUM))
                .buildAndRegister();

        SPINNING_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[EV])
                .input(frameGt, Titanium)
                .input(wireFine, Aluminium, 24)
                .outputs(BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.ALUMINIUM))
                .buildAndRegister();

        SPINNING_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[IV])
                .input(frameGt, TungstenSteel)
                .input(wireFine, Platinum, 24)
                .outputs(BLOCK_GENERATOR_COIL.getItemVariant(BlockGeneratorCoil.CoilType.PLATINUM))
                .buildAndRegister();



        ModHandler.addShapedRecipe("gearbox", GEARBOX.getStackForm(),
                "WGW", "GFG", "WGW",
                'W', OreDictUnifier.get(plate, Wood),
                'G', OreDictUnifier.get(gearSmall, Steel),
                'F', FRAMES.get(Steel));

        ModHandler.addShapedRecipe("axle_bronze", new ItemStack(ROTATION_AXLE),
                " f ", " R ", " s ",
                'R', OreDictUnifier.get(stickLong, Bronze)
        );

        ModHandler.addShapedRecipe("axle_iron", new ItemStack(ROTATION_AXLE, 2),
                " f ", " R ", " s ",
                'R', OreDictUnifier.get(stickLong, Iron)
                );

        ModHandler.addShapedRecipe("axle_steel", new ItemStack(ROTATION_AXLE, 4),
                " f ", " R ", " s ",
                'R', OreDictUnifier.get(stickLong, Steel)
        );

        EXTRUDER_RECIPES.recipeBuilder()
                .duration(105)
                .EUt(VA[MV])
                .notConsumable(SHAPE_EXTRUDER_ROD)
                .input(stickLong, Steel)
                .output(ROTATION_AXLE, 8)
                .buildAndRegister();
    }
}
