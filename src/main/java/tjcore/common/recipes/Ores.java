package tjcore.common.recipes;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.ore.OrePrefix;

public class Ores {

    public static void RegisterOres() {

        //removeTinyAndReplaceWithChance(Magnetite);

    }


    private static void removeTinyAndReplaceWithChance(OrePrefix orePrefix, Material material, OreProperty property) {
        /*
        Material byproductMaterial = GTUtility.selectItemInList(0, material, property.getOreByProducts(), Material.class);
        ItemStack byproductStack = OreDictUnifier.get(OrePrefix.gem, byproductMaterial);
        if (byproductStack.isEmpty()) byproductStack = OreDictUnifier.get(OrePrefix.dust, byproductMaterial);
        ItemStack crushedStack = OreDictUnifier.get(OrePrefix.crushed, material);
        ItemStack ingotStack;
        Material smeltingMaterial = property.getDirectSmeltResult() == null ? material : property.getDirectSmeltResult();
        double amountOfCrushedOre = property.getOreMultiplier();
        if (smeltingMaterial.hasProperty(PropertyKey.INGOT)) {
            ingotStack = OreDictUnifier.get(OrePrefix.ingot, smeltingMaterial);
        } else if (smeltingMaterial.hasProperty(PropertyKey.GEM)) {
            ingotStack = OreDictUnifier.get(OrePrefix.gem, smeltingMaterial);
        } else {
            ingotStack = OreDictUnifier.get(OrePrefix.dust, smeltingMaterial);
        }
        int oreTypeMultiplier = orePrefix == OrePrefix.oreNetherrack || orePrefix == OrePrefix.oreEndstone ? 2 : 1;
        ingotStack.setCount(ingotStack.getCount() * property.getOreMultiplier() * oreTypeMultiplier);
        crushedStack.setCount(crushedStack.getCount() * property.getOreMultiplier());

        if (!crushedStack.isEmpty()) {
            RecipeBuilder<?> builder = RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
                    .input(orePrefix, material)
                    .duration(10).EUt(16);
            if (material.hasProperty(PropertyKey.GEM) && !OrePrefix.gem.isIgnored(material)) {
                builder.outputs(GTUtility.copyAmount((int) Math.ceil(amountOfCrushedOre) * oreTypeMultiplier, OreDictUnifier.get(OrePrefix.gem, material, crushedStack.getCount())));
            } else {
                builder.outputs(GTUtility.copyAmount((int) Math.ceil(amountOfCrushedOre) * oreTypeMultiplier, crushedStack));
            }
            builder.buildAndRegister();

            builder = RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
                    .input(orePrefix, material)
                    .outputs(GTUtility.copyAmount((int) Math.round(amountOfCrushedOre) * 2 * oreTypeMultiplier, crushedStack))
                    .chancedOutput(byproductStack, 1400, 850)
                    .duration(400);
            for (MaterialStack secondaryMaterial : orePrefix.secondaryMaterials) {
                if (secondaryMaterial.material.hasProperty(PropertyKey.DUST)) {
                    ItemStack dustStack = OreDictUnifier.getGem(secondaryMaterial);
                    builder.chancedOutput(dustStack, 6700, 800);
                }
            }

            builder.buildAndRegister();
        }

        //do not try to add smelting recipes for materials which require blast furnace
        if (!ingotStack.isEmpty() && doesMaterialUseNormalFurnace(smeltingMaterial)) {
            ModHandler.addSmeltingRecipe(new UnificationEntry(orePrefix, material), ingotStack);
        }

         */
            /*
        mainDust.getProperty(OreByProductCategory)
        Recipe result = MACERATOR_RECIPES.findRecipe(2, Arrays.asList(OreDictUnifier.get(crushed, mainDust)), null, 0, IGNORE_FLUIDS);

        GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(crushed, mainDust));
        if(result != null)
            MACERATOR_RECIPES.removeRecipe(result);
        */
        //GTRecipeHandler.removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(dust, mainDust), OreDictUnifier.get(dust, secondaryDust));


    }


}
