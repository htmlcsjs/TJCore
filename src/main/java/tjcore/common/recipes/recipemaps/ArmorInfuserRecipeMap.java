package tjcore.common.recipes.recipemaps;

//import gregtech.api.recipes.CountableIngredient;
//import gregtech.api.recipes.MatchingMode;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
//import gregtech.api.recipes.ingredients.NBTIngredient;


public class ArmorInfuserRecipeMap extends RecipeMap<SimpleRecipeBuilder> {
    
    public ArmorInfuserRecipeMap(String unlocalizedName, int minInputs, int maxInputs, int minOutputs, int maxOutputs, int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs, SimpleRecipeBuilder defaultRecipe, boolean isHidden) {
        super(unlocalizedName, minInputs, maxInputs, minOutputs, maxOutputs, minFluidInputs, maxFluidInputs, minFluidOutputs, maxFluidOutputs, defaultRecipe, isHidden);
    }
    
    /**
     * This is the REAL recipe checker.
     */
    /*
    @Nullable
    @Override
    public Recipe findRecipe(long voltage, List<ItemStack> inputs, List<FluidStack> fluidInputs, int outputFluidTankCapacity, MatchingMode matchingMode, boolean exactVoltage) {
        
        // Use original recipe checker to find fake recipe with only non-armor/upgrade key inputs
        Recipe recipe = super.findRecipe(voltage, inputs, fluidInputs, outputFluidTankCapacity, matchingMode, exactVoltage);
        // Start handling armor and upgrade key
        if (recipe != null && recipe.isHidden()) {
            ItemStack idkupgrade = ItemStack.EMPTY;
            ItemStack piece = ItemStack.EMPTY;
            for (ItemStack itemStack : inputs) {
                if (itemStack.getItem() instanceof IUpgradableItem) {
                    piece = itemStack;
                } else if (itemStack.getItem() instanceof ToolUpgrade) {
                    idkupgrade = itemStack;
                }
            }
            if (!piece.isEmpty()) {
                IUpgradableItem asUp = (IUpgradableItem) piece.getItem();
                ItemStack upgrade = ItemStack.EMPTY;
                // Check if found key is valid for found IUpgradableItem ItemStack
                for (String upr : asUp.getValidUpgrades(piece)) {
                    if (ToolUpgrade.ID_TO_NAME.get(idkupgrade.getMetadata()).equals(upr)) {
                        upgrade = idkupgrade;
                        break;
                    }
                }
                String upgradeName = ToolUpgrade.ID_TO_NAME.get(upgrade.getMetadata());
                int currLvl = UpgradeHelper.getUpgradeLevel(piece, upgradeName);
                if (currLvl == asUp.getMaxUpgradeLevel(piece, upgradeName)) {
                    return null;
                }
                if (!upgrade.isEmpty()) {
                    // Creating the output ItemStack
                    ItemStack armor = piece.copy();
                    UpgradeHelper.setUpgradeLevel(armor, upgradeName, currLvl + 1);
                    // This is the new recipe that the multiblock will use
                    return new SimpleRecipeBuilder()
                            .append(ArmorInfuserRecipes.recipes[currLvl], 1, false, false)
                            .inputs(new CountableIngredient(new NBTIngredient(piece), 1))
                            .outputs(armor)
                            .build().getResult();
                }
            }
        }
        return null;
    }
    */

}
