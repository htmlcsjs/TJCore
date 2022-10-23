package TJCore.common.recipes;

import TJCore.api.TJOreDictionaryLoader;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.*;
import gregtech.api.unification.ore.IOreRegistrationHandler;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraftforge.fluids.Fluid;
import org.jetbrains.annotations.NotNull;

import static TJCore.api.TJOreDictionaryLoader.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;

public class MaterialProcessing {
    public static void registerMaterialProcessing(){
        nanoWire.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::registerNanoWires);
        nanoFoil.addProcessingHandler(PropertyKey.INGOT, MaterialProcessing::registerNanoFoils);
    }

    public static void registerNanoFoils(OrePrefix prefix, @NotNull Material mat, IngotProperty prop) {
        NANOSCALE_GROWTH_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(120)
                .circuitMeta(1)
                .fluidInputs(mat.getFluid(16))
                .output(prefix, mat, 16)
                .buildAndRegister();

        RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(5)
                .input(prefix, mat)
                .fluidOutputs(mat.getFluid(1))
                .buildAndRegister();

    }
    public static void registerNanoWires(OrePrefix prefix, @NotNull Material mat, IngotProperty prop) {
             NANOSCALE_GROWTH_RECIPES.recipeBuilder()
                     .EUt(VA[ZPM])
                     .duration(120)
                     .circuitMeta(0)
                     .fluidInputs(mat.getFluid(16))
                     .output(prefix, mat, 16)
                     .buildAndRegister();

             RecipeMaps.EXTRACTOR_RECIPES.recipeBuilder()
                     .EUt(VA[LV])
                     .duration(5)
                     .input(prefix, mat)
                     .fluidOutputs(mat.getFluid(1))
                     .buildAndRegister();
    }
}
