package TJCore.common.recipes;
import TJCore.common.TJConfig;
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

import static TJCore.api.material.TJMaterials.*;
import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.metatileentities.TJMetaTileEntities.*;
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
import scala.tools.nsc.typechecker.Adaptations;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.common.items.MetaItems.RESISTOR;
import static gregtech.common.items.MetaItems.VACUUM_TUBE;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;

public class MachineRecipes {

    static int[] vIndex = new int[]{ULV, LV, MV, HV, EV, IV, LuV, ZPM, UV, UHV, UEV, UIV, UXV, OpV, MAX};
    static Material[] hullMat = new Material[]{Steel, Aluminium, StainlessSteel, Titanium, TungstenSteel, RhodiumPlatedPalladium, NaquadahAlloy, Darmstadtium, Orichalcum, Adamantium, Vibranium, Draconium, HeavyQuarkDegenerate, Neutronium};
    static Material[] cableMat = new Material[]{Tin, Copper, Gold, Aluminium, Platinum, NiobiumTitanium, VanadiumGallium, YttriumBariumCuprate, EnrichedNaqAlloy, PedotTMA, NihoniumTriiodide, Taranium, SuperheavyH, Neutronium};

    public static void registerMachines() {
        removeOldMachines();
        setComponents();
        registerElectric();
        registerSteam();
        registerMulti();
    }

    private static void removeOldMachines() {
        // LV -> UV
        for (int i = LV; i <= UV; i++) {
            ModHandler.removeRecipes(MIXER[i].getStackForm());
        }
    }

    private static void setComponents(){
        ROTOR = new Component(Stream.of(new Object[][]{
                {0, new UnificationEntry(OrePrefix.rotor, Steel)},
                {1, new UnificationEntry(OrePrefix.rotor, GalvanizedSteel)},
                {2, new UnificationEntry(OrePrefix.rotor, Aluminium)},
                {3, new UnificationEntry(OrePrefix.rotor, StainlessSteel)},
                {4, new UnificationEntry(OrePrefix.rotor, Titanium)},
                {5, new UnificationEntry(OrePrefix.rotor, TungstenSteel)},
                {6, new UnificationEntry(OrePrefix.rotor, RhodiumPlatedPalladium)},
                {7, new UnificationEntry(OrePrefix.rotor, NaquadahAlloy)},
                {8, new UnificationEntry(OrePrefix.rotor, Darmstadtium)},
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }

    private static void registerElectric() {
        MetaTileEntityLoader.registerMachineRecipe(MIXER, "GRG", "GEG", "CMC", 'M', CraftingComponent.HULL, 'E', MOTOR, 'R', ROTOR, 'C', CIRCUIT, 'G', GLASS);

    }

    private static void registerSteam() {
        ModHandler.addShapedRecipe("steam_mixer_bronze", STEAM_MIXER_BRONZE.getStackForm(),
                "GRG", "GHG", "PEP",
                'G', OreDictUnifier.get("blockGlass"),
                'R', OreDictUnifier.get(rotor, Bronze),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL),
                'P', OreDictUnifier.get(pipeNormalFluid, TinAlloy),
                'E', OreDictUnifier.get(gear, Bronze));
        ModHandler.addShapedRecipe("steam_mixer_steel", STEAM_MIXER_STEEL.getStackForm(),
                "GRG", "GHG", "PEP",
                'G', OreDictUnifier.get("blockGlass"),
                'R', OreDictUnifier.get(rotor, Steel),
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL),
                'P', OreDictUnifier.get(pipeNormalFluid, TinAlloy),
                'E', OreDictUnifier.get(gear, Steel));
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
    }

    private static void registerMulti() {

    }
}
