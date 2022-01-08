package TJCore.client;

import TJCore.common.CommonProxy;
import TJCore.common.Textures;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
        Textures.preInit();
    }
}
