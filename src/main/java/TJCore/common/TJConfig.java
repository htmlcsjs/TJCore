package TJCore.common;

import TJCore.TJValues;
import gregtech.api.recipes.Recipe;
import net.minecraftforge.common.config.Config;

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


    }

    public static class ClientOptions {

    }


}
