package TJCore.common.recipes;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.blocks.HermeticCasings;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.storage.MetaTileEntityCrate;
import gregtech.common.metatileentities.storage.MetaTileEntityQuantumChest;
import gregtech.common.metatileentities.storage.MetaTileEntityQuantumTank;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.init.Blocks;

import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregtech.common.blocks.HermeticCasings.HermeticCasingsType.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class MultiblockHatches {

    public static MetaItem.MetaValueItem[] motor = {ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV};
    public static MetaItem.MetaValueItem[] piston = {ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV};

    // TODO(Onion): figure out what do do for ulv hatches/buses
    public static MetaItem.MetaValueItem[] pump = {ELECTRIC_PUMP_LV, ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV, ELECTRIC_PUMP_LUV, ELECTRIC_PUMP_ZPM, ELECTRIC_PUMP_UV};
    public static HermeticCasings.HermeticCasingsType[] hermeticCasings = {HERMETIC_LV, HERMETIC_LV, HERMETIC_MV, HERMETIC_HV, HERMETIC_EV, HERMETIC_IV, HERMETIC_LUV, HERMETIC_ZPM, HERMETIC_UV};
    public static MetaTileEntityCrate[] crates = {BRONZE_CRATE, STEEL_CRATE, ALUMINIUM_CRATE, STAINLESS_STEEL_CRATE, TITANIUM_CRATE, TUNGSTENSTEEL_CRATE};


    public static MetaItem.MetaValueItem[] conveyor = {CONVEYOR_MODULE_LV, CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV, CONVEYOR_MODULE_LUV, CONVEYOR_MODULE_ZPM, CONVEYOR_MODULE_UV};

    public static void registerEnergyHatches() {

    }

    public static void registerIOHatches() {

        for(int i = 0; i < 8; i++) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.HULL[i])
                    .input(conveyor[i])
                    .input(i < 5 ? crates[i] : QUANTUM_CHEST[i-5])
                    .input(Blocks.GLASS) // TODO(Onion): replace with tierable glass
                    .notConsumable(new IntCircuitIngredient(1))
                    .output(ITEM_IMPORT_BUS[i])
                    .EUt(16 * (int)Math.pow(4, i))
                    .duration(200)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.HULL[i])
                    .input(conveyor[i])
                    .input(i < 5 ? crates[i] : QUANTUM_CHEST[i-5])
                    .input(Blocks.GLASS)
                    .notConsumable(new IntCircuitIngredient(2))
                    .output(ITEM_EXPORT_BUS[i])
                    .EUt(16 * (int)Math.pow(4, i))
                    .duration(200)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.HULL[i])
                    .input(pump[i])
                    .input(MetaBlocks.HERMETIC_CASING.getItemVariant(hermeticCasings[i]).getItem())
                    .input(Blocks.GLASS)
                    .notConsumable(new IntCircuitIngredient(1))
                    .output(FLUID_IMPORT_HATCH[i])
                    .EUt(16 * (int)Math.pow(4, i))
                    .duration(200)
                    .buildAndRegister();

            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(MetaTileEntities.HULL[i])
                    .input(pump[i])
                    .input(MetaBlocks.HERMETIC_CASING.getItemVariant(hermeticCasings[i]).getItem())
                    .input(Blocks.GLASS)
                    .notConsumable(new IntCircuitIngredient(2))
                    .output(FLUID_EXPORT_HATCH[i])
                    .EUt(16 * (int)Math.pow(4, i))
                    .duration(200)
                    .buildAndRegister();
        }

    }

    public static void registerMufflerAndMaintance() {

    }
}
