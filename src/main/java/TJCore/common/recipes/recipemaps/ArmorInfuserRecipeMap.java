package TJCore.common.recipes.recipemaps;

import com.brandon3055.draconicevolution.DEFeatures;
import com.brandon3055.draconicevolution.api.itemupgrade.IUpgradableItem;
import com.brandon3055.draconicevolution.api.itemupgrade.UpgradeHelper;
import com.brandon3055.draconicevolution.items.ToolUpgrade;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.MatchingMode;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.ingredients.NBTIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;
import java.util.List;

public class ArmorInfuserRecipeMap extends RecipeMap<SimpleRecipeBuilder> {
    
    // These items are the ones to input for each upgrade
    public static final ItemStack[][] upgradeItems = {
            {new ItemStack(DEFeatures.draconicCore, 4)},
            {new ItemStack(DEFeatures.wyvernCore, 4)},
            {new ItemStack(DEFeatures.awakenedCore, 4)}
    };
    
    public ArmorInfuserRecipeMap(String unlocalizedName, int minInputs, int maxInputs, int minOutputs, int maxOutputs, int minFluidInputs, int maxFluidInputs, int minFluidOutputs, int maxFluidOutputs, SimpleRecipeBuilder defaultRecipe, boolean isHidden) {
        super(unlocalizedName, minInputs, maxInputs, minOutputs, maxOutputs, minFluidInputs, maxFluidInputs, minFluidOutputs, maxFluidOutputs, defaultRecipe, isHidden);
    }
    
    
    /**
     * This is the REAL recipe checker.
     */
    @Nullable
    @Override
    public Recipe findRecipe(long voltage, List<ItemStack> inputs, List<FluidStack> fluidInputs, int outputFluidTankCapacity, MatchingMode matchingMode, boolean exactVoltage) {
        ItemStack piece = ItemStack.EMPTY;
        ItemStack idkupgrade = ItemStack.EMPTY;
        IUpgradableItem uu = null;
        for (ItemStack itemStack : inputs) {
            if (itemStack.getItem() instanceof IUpgradableItem) {
                piece = itemStack;
                uu = (IUpgradableItem)piece.getItem();
            } else if (itemStack.getItem() instanceof ToolUpgrade) {
                idkupgrade = itemStack;
            }
        }
        if (!piece.isEmpty() && uu != null) {
            ItemStack upgrade = ItemStack.EMPTY;
            for (String upr : uu.getValidUpgrades(piece)) {
                if (ToolUpgrade.ID_TO_NAME.get(idkupgrade.getMetadata()).equals(upr)) {
                    upgrade = idkupgrade;
                    break;
                }
            }
            String upgradeName = ToolUpgrade.ID_TO_NAME.get(upgrade.getMetadata());
    
            int currLvl = UpgradeHelper.getUpgradeLevel(piece, upgradeName);
            if (currLvl == uu.getMaxUpgradeLevel(piece, upgradeName)) {
                return null;
            }
            if (!upgrade.isEmpty()) {
                ItemStack armor = piece.copy();
                UpgradeHelper.setUpgradeLevel(armor, upgradeName, currLvl + 1);
                return new SimpleRecipeBuilder()
                        .inputs(upgradeItems[currLvl])
                        .inputs(new CountableIngredient(new NBTIngredient(piece), 1))
                        .outputs(armor)
                        .EUt(30)
                        .duration(100)
                        .build().getResult();
            }
        }
        return null;
    }
}
