package TJCore.common.recipes;
import TJCore.common.blocks.BlockBearing;
import TJCore.common.blocks.BlockTurbineBlades;
import TJCore.common.blocks.TJMetaBlocks;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;

import static TJCore.api.TJComponents.*;
import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.blocks.BlockTurbineBlades.TurbineBladesType.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.metatileentities.TJMetaTileEntities.*;
import static TJCore.common.recipes.GTComponents.tierCircuitNames;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;

import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.OreDictionaryLoader;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import scala.Char;
import scala.tools.cmd.Meta;
import scala.tools.cmd.gen.AnyValReps;

import static gregtech.api.GTValues.*;
import static gregtech.common.blocks.MetaBlocks.MACHINE_CASING;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

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
        ModHandler.removeRecipes(STEAM_MACERATOR_BRONZE.getStackForm());
        removeAllTeirs(TRANSFORMER);
        removeAllTeirs(STEAM_TURBINE);
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
                ModHandler.removeRecipes(mte.getStackForm());
            }
        }
    }


    private static void registerHulls() {


        for (int i = 0; i < MAX; i++) {
            if (i < UIV) {
                ModHandler.removeRecipes(MACHINE_CASING.getItemVariant(machineCasingTypes[i]));
                if (i != UEV) GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(plate, hullMaterialOld[i], 8), IntCircuitIngredient.getIntegratedCircuit(8));
                //System.out.println("\nDebug- Attempting to remove recipe inputs:\n8x " + hullMaterialOld[i].getLocalizedName() + " plate 8\nIntCircuit Config: 8");
            }

            OreDictUnifier.registerOre(MACHINE_CASING.getItemVariant(machineCasingTypes[i]), new ItemMaterialInfo(
                    new MaterialStack(i == 1 ? Steel : hullMaterialNew[i], M*4),
                    new MaterialStack(secondaryHullMaterial[i], M/2)
            ));

            OreDictUnifier.registerOre(MetaTileEntities.HULL[i].getStackForm(), new ItemMaterialInfo(
                    new MaterialStack(i == 1 ? Steel : hullMaterialNew[i], M*5),
                    new MaterialStack(secondaryHullMaterial[i], M/2),
                    new MaterialStack(hullPolymerNew[i], M*2),
                    new MaterialStack(cableGtSingleNew[i], M)
            ));

            ModHandler.addShapedRecipe("machine_casing_" + VN[i].toLowerCase(), MACHINE_CASING.getItemVariant(machineCasingTypes[i]),
                    "BHB","PFP","BSB",
                    'B', new UnificationEntry(bolt, secondaryHullMaterial[i]),
                    'P', new UnificationEntry(plate, hullMaterialNew[i]),
                    'F', new UnificationEntry(frameGt, hullMaterialNew[i]),
                    'H', HARD_HAMMER,
                    'S', SCREWDRIVER
            );
            ModHandler.addShapedRecipe(MetaTileEntities.HULL[i].getMetaName(), MetaTileEntities.HULL[i].getStackForm(),
                    "   ","PMP","CHC",
                    'P', new UnificationEntry(plate, hullPolymerNew[i]),
                    'M', new UnificationEntry(plate, hullMaterialNew[i]),
                    'C', new UnificationEntry(cableGtSingle, cableGtSingleNew[i]),
                    'H', MACHINE_CASING.getItemVariant(machineCasingTypes[i])
            );
        }
    }
    private static void registerElectric() {
        MetaTileEntityLoader.registerMachineRecipe(PRINTER, "WRW", "PSP", "CHC", 'P', PISTON, 'W', COIL_HEATING, 'R', RING, 'S', SUBSTRATE, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(LAMINATOR, "WGW", "MHM", "CGC", 'M', MOTOR, 'G', COIL_ELECTRIC, 'W', CABLE, 'H', CraftingComponent.HULL, 'C', CIRCUIT);
        MetaTileEntityLoader.registerMachineRecipe(COMPONENT_ASSEMBLER, "WCW", "AHA", "WCW", 'A', ROBOT_ARM, 'W', CABLE, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(TRANSFORMER, "   ","FHC","   ", 'F', CABLE_QUAD, 'C', CABLE_TIER_UP, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(SPINNING_MACHINE, "GRG","CMC","WHW", 'G', GLASS, 'R', RODSTICK, 'C', CIRCUIT, 'M', MOTOR, 'W', CABLE, 'H', CraftingComponent.HULL);
    }

    private static void registerSteam() {

        ModHandler.addShapedRecipe("steam_component_assembler", STEAM_COMPONENT_ASSEMBLER.getStackForm(),
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
                "PGP", "MCM", "RWR",
                'G', OreDictUnifier.get(gear, Steel),
                'M', ELECTRIC_MOTOR_LV.getStackForm(),
                'W', OreDictUnifier.get(wireGtDouble, Copper),
                'R', new UnificationEntry(circuit, tierCircuitNames[LV]),
                'P', OreDictUnifier.get(pipeLargeFluid, Steel),
                'C', MetaTileEntities.HULL[LV].getStackForm());

        ModHandler.addShapedRecipe("primitive_tree_farmer", PRIMITIVE_TREE_FARMER.getStackForm(),
                "GAG", "DBCD", "PCP",
                'G', OreDictUnifier.get(gearSmall, Bronze),
                'A', OreDictUnifier.get(toolHeadAxe, Invar),
                'D', new ItemStack(Blocks.DIRT),
                'B', new ItemStack(Blocks.BRICK_BLOCK),
                'P', OreDictUnifier.get(pipeNormalFluid, Wood),
                'C', WOODEN_CRATE.getStackForm());
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
    }
}
