package TJCore.common.recipes.recipemaps;


import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.ValidationResult;

public class PrinterRecipeMap extends RecipeBuilder<PrinterRecipeMap> {

    private int tempurature;

    public PrinterRecipeMap(Recipe recipe, RecipeMap<PrinterRecipeMap> recipeMap) {
        super(recipe, recipeMap);
        this.tempurature = recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @Override
    public PrinterRecipeMap copy() {
        return null;
    }

    @Override
    public ValidationResult<Recipe> build() {
        return null;
    }


}
