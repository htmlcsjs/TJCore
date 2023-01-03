package TJCore.common.recipes.compatrecipes;

import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import com.brandon3055.draconicevolution.DEFeatures;
import com.brandon3055.draconicevolution.items.ItemCore;
import com.google.common.collect.ImmutableMap;
import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeBuilder;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;


public class ArmorInfuserRecipes {

    public static void register() {
        RecipeBuilder<?> builder = TJRecipeMaps.ARMOR_INFUSER_RECIPES.recipeBuilder()
                .EUt(GTValues.VA[GTValues.LuV])
                .duration(100);

        for (Map.Entry<ItemCore, String> entry : ImmutableMap.of(DEFeatures.draconicCore, "Basic", DEFeatures.wyvernCore, "Wyvern", DEFeatures.awakenedCore, "Draconic").entrySet()) {
            // Recipe containing only input items (no armor/key) and dummy output for recipe searching. Will always be hidden
            builder.copy()
                    .input(entry.getKey(), 4)
                    .output(Items.BONE)
                    .hidden()
                    .buildAndRegister();

            // Dummy recipe for JEI
            builder.copy()
                    .input(entry.getKey(), 4)
                    .input("itemUpgradeKey", 1)
                    .inputs(new ItemStack(DEFeatures.draconicChest)
                            .setStackDisplayName(String.format("Item to Upgrade (Tier %s)", entry.getValue())))
                    .outputs(new ItemStack(DEFeatures.draconicChest)
                            .setStackDisplayName("Item with Upgrade Applied"))
                    .buildAndRegister();
        }
    }
}
