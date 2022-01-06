package TJCore.common.recipes;

import crafttweaker.api.item.IItemStack;
import gregtech.api.GTValues;

import java.util.ArrayList;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregtech.api.util.GTLog;
import org.apache.logging.log4j.Level;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class GTComponents {

    public static void registerComponents() {

        //ArrayList<IItemStack> rods = new ArrayList<IItemStack>(5);
        GTLog.logger.log(Level.ERROR, "motor man, make the recipe. FATAL");


            TJRecipeMaps.COMPONENT_ASSEMBLER_RECIPE_MAP.recipeBuilder()
                    .input(cableGtSingle, Tin, 2)
                    .input(cableGtSingle, Tin, 2)
                    .input(cableGtSingle, Tin, 2)
                    .outputs(ELECTRIC_MOTOR_LV.getStackForm())
                    .EUt(30)
                    .duration(20)
                    .buildAndRegister();


    }

}
