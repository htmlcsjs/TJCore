package tjcore.common;

import net.minecraftforge.common.config.Config;
import stanhebben.zenscript.annotations.ZenMethod;
import tjcore.TJValues;

@Config(modid = TJValues.MODID)
public class TJConfig {

    @Config.Comment("Config options for client features")
    @Config.Name("Client Options")
    public static ClientOptions client = new ClientOptions();

    @Config.Comment("Config options for client features")
    @Config.Name("Client Options")
    @Config.RequiresMcRestart
    public static RecipeOptions recipes = new RecipeOptions();





    public static class RecipeOptions {
        public boolean harderFrames = false;

        public boolean harderMetalCasings = false;

        @Config.Comment("harder AE recipes")
        public boolean harderAERecipes = false;


    }

    @ZenMethod
    public static boolean isHarderAERecipes() {
        return recipes.harderAERecipes;
    }

    public static class ClientOptions {

    }


}
