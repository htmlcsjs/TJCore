package tjcore.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockHermeticCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.metatileentities.storage.MetaTileEntityCrate;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import scala.tools.nsc.transform.patmat.Logic;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregicality.science.common.items.GCYSMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockHermeticCasing.HermeticCasingsType.*;
import static gregtech.common.blocks.MetaBlocks.MACHINE_CASING;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static tjcore.api.TJComponents.POWER_IC;
import static tjcore.api.material.TJMaterials.*;
import static tjcore.common.metaitem.TJMetaItems.CLEANROOM_FILTER;
import static tjcore.common.metaitem.TJMetaItems.FIBERGLASS_MESH;
import static tjcore.common.recipes.GTComponents.tierCircuitNames;
import static tjcore.common.recipes.recipemaps.TJRecipeMaps.SPINNING_RECIPES;

public class MultiblockHatches {

    private static MetaItem<?>.MetaValueItem[] motor = {ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV};
    private static MetaItem<?>.MetaValueItem[] piston = {ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV};

    // TODO(Onion): figure out what do do for ulv hatches/buses
    private static MetaItem<?>.MetaValueItem[] pump = {ELECTRIC_PUMP_LV, ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV, ELECTRIC_PUMP_LuV, ELECTRIC_PUMP_ZPM, ELECTRIC_PUMP_UV};
    private static BlockHermeticCasing.HermeticCasingsType[] hermeticCasings = {HERMETIC_LV, HERMETIC_LV, HERMETIC_MV, HERMETIC_HV, HERMETIC_EV, HERMETIC_IV, HERMETIC_LUV, HERMETIC_ZPM, HERMETIC_UV};
    private static MetaTileEntityCrate[] crates = {WOODEN_CRATE, BRONZE_CRATE, STEEL_CRATE, ALUMINIUM_CRATE, STAINLESS_STEEL_CRATE, TITANIUM_CRATE, TUNGSTENSTEEL_CRATE};
    private static MetaItem<?>.MetaValueItem[] conveyor = {CONVEYOR_MODULE_LV, CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV, CONVEYOR_MODULE_LuV, CONVEYOR_MODULE_ZPM, CONVEYOR_MODULE_UV};
    private static Material[] coilRodsOld = new Material[]{IronMagnetic, IronMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic, SamariumMagnetic, SamariumMagnetic, SamariumMagnetic};
    private static Material[] coilWiresOld = new Material[]{Lead, Steel, Aluminium, BlackSteel, TungstenSteel, Iridium, Osmiridium, Europium, Tritanium};
    private static Material[] coilWires = new Material[]{Lead, Tin, Copper, Silver, Aluminium, Platinum, NiobiumTitanium, VanadiumGallium, YttriumBariumCuprate, Pikyonium, PedotTMA, NihoniumTriiodide, Taranium, OganessonTetraTennesside};
    private static Material[] coilStick = new Material[]{IronMagnetic, IronMagnetic, SteelMagnetic, SteelMagnetic, SteelMagnetic, NeodymiumMagnetic, NeodymiumMagnetic, SamariumMagnetic, SamariumMagnetic, ChromiumGermaniumTellurideMagnetic, ChromiumGermaniumTellurideMagnetic, NeptuniumAluminide, NeptuniumAluminide, PlutoniumPhosphide};
    private static MetaItem<?>.MetaValueItem[] voltageCoil = new MetaItem<?>.MetaValueItem[]{VOLTAGE_COIL_ULV, VOLTAGE_COIL_LV, VOLTAGE_COIL_MV, VOLTAGE_COIL_HV, VOLTAGE_COIL_EV, VOLTAGE_COIL_IV, VOLTAGE_COIL_LuV, VOLTAGE_COIL_ZPM, VOLTAGE_COIL_UV, VOLTAGE_COIL_UHV, VOLTAGE_COIL_UEV, VOLTAGE_COIL_UIV, VOLTAGE_COIL_UXV, VOLTAGE_COIL_OpV};

    public static void init() {
        registerEnergyHatches();
        registerIOHatches();
        registerMaintance();
    }

    private static void registerEnergyHatches() {

        ModHandler.removeRecipeByOutput(ENERGY_OUTPUT_HATCH[0].getStackForm());
        ModHandler.removeRecipeByOutput(ENERGY_OUTPUT_HATCH[1].getStackForm());
        ModHandler.removeRecipeByOutput(ENERGY_OUTPUT_HATCH[2].getStackForm());
        MetaTileEntityLoader.registerMachineRecipe(ENERGY_OUTPUT_HATCH, "SCS","WHW","PCP", 'S', POWER_IC, 'C', VOLTAGE_COIL, 'W', CABLE, 'P', PLATE, 'H', CraftingComponent.HULL);

        //ULV - UV
        for (int i = ULV; i < UHV; i++) {
            GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                    OreDictUnifier.get(stick, coilRodsOld[i]),
                    OreDictUnifier.get(wireFine, coilWiresOld[i], 16),
                    IntCircuitIngredient.getIntegratedCircuit(1)
            );
        }

        ModHandler.addShapedRecipe("hand_ulv_coil", voltageCoil[0].getStackForm(),
                "WWW", "WSW", "WWW",
                'W', OreDictUnifier.get(wireGtSingle, Lead),
                'S', OreDictUnifier.get(stick, IronMagnetic));

        ModHandler.addShapedRecipe("hand_lv_coil", voltageCoil[1].getStackForm(),
                "WWW", "WSW", "WWW",
                'W', OreDictUnifier.get(wireGtSingle, Tin),
                'S', OreDictUnifier.get(stick, IronMagnetic));

        for (int i = ULV; i < MAX; i++) {
            SPINNING_RECIPES.recipeBuilder()
                    .duration(40*(i+1))
                    .EUt( i  > IV ? VA[i] : VA[LV])
                    .input(wireFine, coilWires[i], i < LuV ? 16 : (i < UHV) ? 32 : 64)
                    .input(i < ZPM ? stick : stickLong, coilStick[i])
                    .output(voltageCoil[i])
                    .buildAndRegister();
        }
    }

    private static void registerIOHatches() {
        //TODO: make this method work please i am begging you I cant make it work i dont know why it wont do any of the recipes that use casings or make crafting recipes for IO hatches and it will only use ULV casings when i get casing type i what the fuck is happening please someone fix this i cant to it please man we need to rework io hatches but it doesnt work when i do it and i dont want to do it and we need to do it so that people can make the hatches and busses and gaming.
    }

    public static void registerMaintance() {
        ModHandler.removeRecipeByOutput(MAINTENANCE_HATCH.getStackForm());
        ModHandler.removeRecipeByOutput(AUTO_MAINTENANCE_HATCH.getStackForm());
        ModHandler.removeRecipeByOutput(CONFIGURABLE_MAINTENANCE_HATCH.getStackForm());
        ModHandler.removeRecipeByOutput(CLEANING_MAINTENANCE_HATCH.getStackForm());
        ModHandler.addShapedRecipe("maintenance_hatch", MAINTENANCE_HATCH.getStackForm()," d ","SCS"," w ", 'S', OreDictUnifier.get(screw, GalvanizedSteel), 'C', MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LV) );
        ModHandler.addShapedRecipe("maintenance_hatch_auto", AUTO_MAINTENANCE_HATCH.getStackForm(), " A ","CHC"," W ", 'A', ROBOT_ARM_MV, 'C', new UnificationEntry(circuit, tierCircuitNames[MV]), 'W', CABLE.getIngredient(MV), 'H', MAINTENANCE_HATCH.getStackForm());
        ModHandler.addShapedRecipe("maintenance_hatch_configurable", CONFIGURABLE_MAINTENANCE_HATCH.getStackForm(), " d ","CHC"," w ", 'H', MAINTENANCE_HATCH.getStackForm(), 'C', new UnificationEntry(circuit, tierCircuitNames[LV]));
        ModHandler.addShapedRecipe("maintenance_hatch_filtration", CLEANING_MAINTENANCE_HATCH.getStackForm(), "FRF","CAC","WMW", 'F', CLEANROOM_FILTER, 'R', new UnificationEntry(rotor, Titanium), 'C', new UnificationEntry(circuit, tierCircuitNames[EV]), 'A', AUTO_MAINTENANCE_HATCH.getStackForm(), 'W', new UnificationEntry(cableGtSingle, Aluminium), 'M', ELECTRIC_MOTOR_EV);
        ModHandler.addShapedRecipe("cleanroom_filter", CLEANROOM_FILTER.getStackForm(), "WWW","WMW","WWW", 'W', new UnificationEntry(dust, Cellulose), 'M', FIBERGLASS_MESH.getStackForm());
    }
}
