package TJCore.common.recipes.recipemaps;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;

public class TJRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler", 3, 6, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);
    public static final RecipeMap<SimpleRecipeBuilder> STEAM_COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("steam_assembler", 3, 6, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);
    public static final RecipeMap<SimpleRecipeBuilder> TREE_FARMER_RECIPES = new RecipeMap<>("tree_farmer", 1, 3, 0, 6, 0, 1, 0, 1, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);
    public static void initRecipeMaps() {
    }

}
