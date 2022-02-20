package TJCore.common.recipes.recipehelpers;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.loaders.recipe.CraftingComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecipeUtils {

    public static void A(CraftingComponent.Component component, ItemStack... items) {
        component.appendIngredients(Stream.of(new Object[][]{
                
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }

}
