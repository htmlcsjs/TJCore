package TJCore.common.recipes;

import TJCore.common.metaitem.TJMetaItems;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import com.brandon3055.draconicevolution.DEFeatures;
import gregtech.api.recipes.CountableIngredient;
import gregtech.api.recipes.Recipe;
import gregtech.common.items.MetaItem1;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SurfaceRockDrillRecipes {
    public static void register() {
        TJRecipeMaps.SURFACE_ROCK_DRILL_RECIPES.recipeBuilder()
                .inputs(TJMetaItems.SMD_DIODE_2.getStackForm(3))
                .output(TJMetaItems.CRYSTAL_PROCESSOR_LUV)
                .EUt(32768)
                .duration(100)
                .buildAndRegister();
    }
}
