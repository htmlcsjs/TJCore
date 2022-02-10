package TJCore.client;

import TJCore.common.CommonProxy;
import TJCore.common.TJTextures;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
        TJTextures.preInit();
    }
}
