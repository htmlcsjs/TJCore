package TJCore;

import TJCore.common.metaitem.TJMetaItems;
import TJCore.common.metatileentities.TJMetaTileEntities;
import codechicken.lib.CodeChickenLib;
import gregtech.api.GTValues;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import TJCore.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import com.brandon3055.draconicevolution.DraconicEvolution;

@Mod(modid = TJValues.MODID, name = "TJCore", version = TJValues.VERSION,
        acceptedMinecraftVersions = "[1.12, 1.13)", dependencies = "required:forge@[14.23.5.2847,);" + CodeChickenLib.MOD_VERSION_DEP + GTValues.MOD_VERSION_DEP + DraconicEvolution.DEPENDENCIES + "after:forestry;after:jei@[4.15.0,);after:crafttweaker;before:ctm")

public class TJCore {
    @Mod.Instance("TJCore")
    public static TJCore instance;

    @SidedProxy(modId = "tjcore", clientSide = "TJCore.client.ClientProxy", serverSide = "TJCore.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void onConstruction(FMLConstructionEvent event) {

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TJMetaItems.init();
        TJMetaTileEntities.init();
        TJSounds.registerSounds();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //proxy.init(event);

    }
}
