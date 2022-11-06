package TJCore.common.recipes;
import TJCore.common.TJConfig;
import TJCore.common.blocks.BlockBearing;
import TJCore.common.blocks.BlockTurbineBlades;
import TJCore.common.blocks.TJMetaBlocks;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;

import static TJCore.api.TJComponents.*;
import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.blocks.BlockTurbineBlades.TurbineBladesType.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.metatileentities.TJMetaTileEntities.*;
import static TJCore.common.recipes.GTComponents.tierCircuitNames;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import static gregtech.api.unification.ore.OrePrefix.*;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import scala.tools.nsc.typechecker.Adaptations;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

public class MachineRecipes {

    public static void registerMachines() {
        removeOldMachines();
        registerElectric();
        registerSteam();
        registerMulti();
        registerGenerator();
    }

    private static void removeOldMachines() {
        removeAllTeirs(STEAM_TURBINE);
    }

    private static void removeAllTeirs(MetaTileEntity[] mteIn) {
        for (MetaTileEntity mte: mteIn) {
            if (mte != null) {
                ModHandler.removeRecipes(mte.getStackForm());
            }
        }
    }

    private static void registerElectric() {
        MetaTileEntityLoader.registerMachineRecipe(PRINTER, "WRW", "PSP", "CHC", 'P', PISTON, 'W', COIL_HEATING, 'R', RING, 'S', SUBSTRATE, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
        MetaTileEntityLoader.registerMachineRecipe(LAMINATOR, "WGW", "MHM", "CGC", 'M', MOTOR, 'G', COIL_ELECTRIC, 'W', CABLE, 'H', CraftingComponent.HULL, 'C', CIRCUIT);
        MetaTileEntityLoader.registerMachineRecipe(COMPONENT_ASSEMBLER, "WCW", "AHA", "WCW", 'A', ROBOT_ARM, 'W', CABLE, 'C', CIRCUIT, 'H', CraftingComponent.HULL);
    }

    private static void registerSteam() {
        ModHandler.addShapedRecipe("steam_mixer_bronze", STEAM_MIXER_BRONZE.getStackForm(),
                "GRG", "GMG", "PHP",
                'G', OreDictUnifier.get("blockGlass"),
                'R', OreDictUnifier.get(rotor, Bronze),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                'P', OreDictUnifier.get(pipeNormalFluid, TinAlloy),
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
                'I', OreDictUnifier.get("craftingPiston"));
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
                "GAG", "DBD", "PCP",
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
