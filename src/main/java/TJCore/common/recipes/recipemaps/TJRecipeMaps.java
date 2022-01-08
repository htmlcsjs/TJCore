package TJCore.common.recipes.recipemaps;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;

public class TJRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler", 3, 6, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.TRICORDER_TOOL);
    public static final RecipeMap<SimpleRecipeBuilder> STEAM_ASSEMBLER_RECIPES = new RecipeMap<>("steam_assembler", 3, 6, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false);
    public static void initRecipeMaps() {
    }

}
