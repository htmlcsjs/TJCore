package gregicality.science;

import gregicality.science.api.utils.GCYSLog;
import gregicality.science.common.CommonProxy;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.items.GCYSMetaItems;
import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;

public class GregicalityScience {

    public static final String MODID = "gcys";
    public static final String NAME = "Gregicality Science";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(modId = MODID, clientSide = "gregicality.science.common.ClientProxy", serverSide = "gregicality.science.common.CommonProxy")
    public static CommonProxy proxy = new CommonProxy();

    @Mod.EventHandler
    public void onPreInit(@Nonnull FMLPreInitializationEvent event) {
        GCYSLog.init(event.getModLog());

        GCYSMetaItems.initMetaItems();
        GCYSMetaBlocks.init();

        proxy.preLoad();
    }
}
