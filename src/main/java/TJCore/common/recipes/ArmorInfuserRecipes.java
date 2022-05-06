package TJCore.common.recipes;

import TJCore.common.recipes.recipemaps.ArmorInfuserRecipeMap;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import com.brandon3055.draconicevolution.DEFeatures;
import net.minecraft.item.ItemStack;

;

public class ArmorInfuserRecipes {
    //The recipes registered here are only for use in JEI, change the ItemStacks in the 2D array in ArmorInfuserRecipeMap to change the additional inputs.
    public static void register() {
        for (int i=0; i<ArmorInfuserRecipeMap.upgradeItems.length; i++) {
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .inputs(ArmorInfuserRecipeMap.upgradeItems[i])
                    .inputs(new ItemStack(DEFeatures.draconicChest).setStackDisplayName(String.format("Item to Upgrade (Tier %s)", getTierName(i))))
                    .outputs(new ItemStack(DEFeatures.draconicChest).setStackDisplayName("Item with Upgrade Applied"))
                    .EUt(32768)
                    .duration(100)
                    .buildAndRegister();
        }
    }
    
   private static String getTierName(int i) {
       String tierName = "";
       switch (i) {
           case 0:
               tierName = "Basic";
               break;
           case 1:
               tierName = "Wyvern";
               break;
           case 2:
               tierName = "Draconic";
               break;
           default:
               tierName = "o no";
       }
       return tierName;
   }
    
}
