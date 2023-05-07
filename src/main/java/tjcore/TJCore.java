package tjcore;

import codechicken.lib.CodeChickenLib;
import gregicality.science.GregicalityScience;
import gregicality.science.api.utils.GCYSLog;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.items.GCYSMetaItems;
import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tjcore.common.CommonProxy;
import tjcore.common.blocks.TJMetaBlocks;
import tjcore.common.metaitem.TJMetaItems;
import tjcore.common.metatileentities.TJMetaTileEntities;

@Mod(
        modid = TJValues.MODID,
        name = "tjcore",
        version = TJValues.VERSION,
        acceptedMinecraftVersions = "[1.12, 1.13)",
        dependencies = "required:forge@[14.23.5.2847,);" + CodeChickenLib.MOD_VERSION_DEP + GTValues.MOD_VERSION_DEP + "after:gcys;after:forestry;after:jei@[4.15.0,);after:crafttweaker;before:ctm;after:draconicevolution")
public class TJCore {

    @SidedProxy(modId = "tjcore", clientSide = "tjcore.client.ClientProxy", serverSide = "tjcore.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TJMetaItems.init();
        TJMetaTileEntities.init();
        TJSounds.registerSounds();
        TJMetaBlocks.init();
        proxy.preInit();


        // Initialize GCYS Dependencies until an updated release is functional
        // TODO: Remove this when the time comes
        GCYSLog.init(event.getModLog());

        GCYSMetaItems.initMetaItems();
        GCYSMetaBlocks.init();

        GregicalityScience.proxy.preLoad();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //proxy.init(event);

    }
}
