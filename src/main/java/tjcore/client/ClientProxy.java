package tjcore.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import tjcore.common.CommonProxy;
import tjcore.common.TJTextures;
import tjcore.common.blocks.TJMetaBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
        TJTextures.preInit();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        TJMetaBlocks.registerStateMappers();
        TJMetaBlocks.registerItemModels();
    }
}
