package TJCore.common;

import TJCore.TJValues;
import TJCore.common.recipes.MultiblockHatches;
import TJCore.common.recipes.Ores;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import TJCore.common.recipes.GTComponents;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class CommonProxy {

    public void preInit() {

    }

    @SubscribeEvent
    public static void init(RegistryEvent.Register<IRecipe> event) {



        TJRecipeMaps.initRecipeMaps();

        GTComponents.registerComponents();
        MultiblockHatches.registerIOHatches();
        Ores.RegisterOres();
    }
}
