package TJCore.common.recipes;

import TJCore.common.TJConfig;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import static gregtech.api.unification.ore.OrePrefix.*;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class MaterialRecipes {

    public static void register() {
        if(TJConfig.recipes.harderFrames)
            frameGt.addProcessingHandler(PropertyKey.DUST, MaterialRecipes::createFrames);

        registerMetalCasings();
    }

    public static void createFrames(OrePrefix prefix, Material mat, DustProperty property) {

        if(mat.hasFlag(GENERATE_FRAME)) {
            ModHandler.removeRecipeByName(String.format("gregtech:frame_%s", mat));

            ModHandler.addShapedRecipe(String.format("frame1_%s", mat),
                    OreDictUnifier.get(prefix, mat, 1),
                    "PLP", "LwL", "LLL",
                    'P', new UnificationEntry(OrePrefix.plateDouble, mat),
                    'L', new UnificationEntry(OrePrefix.stickLong, mat));



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

}
