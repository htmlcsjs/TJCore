package TJCore.common.recipes.recipemaps;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.sound.GTSounds;

public class TJRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> FSZM_RECIPES = new RecipeMap<>("free_stand_zone_melter", 1,1,1,1,0,1,0,1,new SimpleRecipeBuilder(), false).setSlotOverlay(false,false, GuiTextures.HEATING_OVERLAY_1).setSlotOverlay(true,false,GuiTextures.CRYSTAL_OVERLAY);

    public static final RecipeMap<SimpleRecipeBuilder> COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("component_assembler", 3, 6, 1, 1, 0, 1, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);

    public static final RecipeMap<IntCircuitRecipeBuilder> PRINTER_RECIPES = new RecipeMap<>("printer", 1, 9, 1, 2, 0, 1, 0, 1, new IntCircuitRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> STEAM_COMPONENT_ASSEMBLER_RECIPES = new RecipeMap<>("steam_assembler", 3, 6, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> TREE_FARMER_RECIPES = new RecipeMap<>("tree_farmer", 1, 3, 0, 6, 0, 1, 0, 1, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> DEHYDRATOR_RECIPES = new RecipeMap<>("dehydrator", 0, 1, 0, 1, 0, 1, 0, 1, new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> EXPOSURE_CHAMBER_RECIPES = new RecipeMap<>("exposure_chamber",0,4,0,4,0,2,0,2,new SimpleRecipeBuilder(), false).setProgressBar(GuiTextures.PROGRESS_BAR_MASS_FAB, ProgressWidget.MoveType.HORIZONTAL).setSound(GTSounds.ASSEMBLER);
    public static final RecipeMap<SimpleRecipeBuilder> ARMOR_INFUSER_RECIPES = new ArmorInfuserRecipeMap("armor_infuser", 1, 12, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> MEGA_FUSION_RECIPES = new RecipeMap<>("mega_fusion", 0, 1, 0, 3, 0, 4, 0, 3, new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> SURFACE_ROCK_DRILL_RECIPES = new RecipeMap<>("surface_rock_drill", 0, 12, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder(), false);

    public static final RecipeMap<SimpleRecipeBuilder> LAMINATOR_RECIPES = new RecipeMap<>("laminator", 1, 6, 1, 1, 0, 2, 0, 0, new SimpleRecipeBuilder(), false).setSound(GTSounds.ASSEMBLER);
}
