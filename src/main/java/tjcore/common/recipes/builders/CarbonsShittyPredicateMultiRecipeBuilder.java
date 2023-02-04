package tjcore.common.recipes.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTUtility;

import javax.annotation.Nonnull;

public class CarbonsShittyPredicateMultiRecipeBuilder  extends RecipeBuilder<CarbonsShittyPredicateMultiRecipeBuilder> {

    protected int pipeTier = -1;
    protected int coilTier = -1;
    protected int glassTier = -1;


    public CarbonsShittyPredicateMultiRecipeBuilder() {}

    public CarbonsShittyPredicateMultiRecipeBuilder(Recipe recipe, RecipeMap<CarbonsShittyPredicateMultiRecipeBuilder> recipeMap) {super(recipe, recipeMap);}

    public CarbonsShittyPredicateMultiRecipeBuilder(RecipeBuilder<CarbonsShittyPredicateMultiRecipeBuilder> recipeBuilder) {super(recipeBuilder);}

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if(key.equals("pipe") && value instanceof Number) {
            pipeTier(((Number) value).intValue());
            return true;
        }
        if(key.equals("glass") && value instanceof Number) {
            glassTier = ((Number) value).intValue();
            return true;
        }

        return super.applyProperty(key, value);
    }

    public CarbonsShittyPredicateMultiRecipeBuilder pipeTier(int pie) {
        if(!GTUtility.isBetweenInclusive(0, 3, pie)) {
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.pipeTier = pie;
        return this;
    }
}
