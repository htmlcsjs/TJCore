package TJCore.common.recipes;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import com.brandon3055.draconicevolution.DEFeatures;
import gregtech.api.recipes.Recipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;



public class ArmorInfuserRecipes {
    
    // Recipes for each tier. Ranges, in order, from Basic to Awakened
    public static final Recipe[] recipes = {
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .input(DEFeatures.draconicCore, 4)
                    .EUt(32768)
                    .duration(100)
                    .build().getResult(),
                    
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .input(DEFeatures.wyvernCore, 4)
                    .EUt(32768)
                    .duration(100)
                    .build().getResult(),
                    
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .input(DEFeatures.awakenedCore, 4)
                    .EUt(32768)
                    .duration(100)
                    .build().getResult()
                    
    };
    
    public static void register() {
        
        for (int i=0; i<recipes.length; i++) {
            // Recipe containing only input items (no armor/key) and dummy output for recipe searching. Will always be hidden
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .append(recipes[i], 1, false)
                    .output(Items.BONE)
                    .hidden()
                    .buildAndRegister();
            // Dummy recipe for JEI
            TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                    .append(recipes[i], 1, false)
                    //.inputs(CountableIngredient.from("itemUpgradeKey",0))
                    .inputs(new ItemStack(DEFeatures.draconicChest).setStackDisplayName(String.format("Item to Upgrade (Tier %s)", getTierName(i))))
                    .outputs(new ItemStack(DEFeatures.draconicChest).setStackDisplayName("Item with Upgrade Applied"))
                    .buildAndRegister();
        }
    }
    
   private static String getTierName(int i) {
       String tierName;
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
