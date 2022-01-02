package TJCore;

import codechicken.lib.CodeChickenLib;
import gregtech.api.GTValues;
import net.minecraftforge.fml.common.*;
import TJCore.client.ClientProxy;
import TJCore.common.ServerProxy;

@Mod(modid = "TJCore", name = "TJCore", acceptedMinecraftVersions = "[1.12, 1.13)", dependencies = "required:forge@[14.23.5.2847,);" + CodeChickenLib.MOD_VERSION_DEP + GTValues.MOD_VERSION_DEP + "after:forestry;after:jei@[4.15.0,);after:crafttweaker;before:ctm")

public class TJCore {
    @Mod.Instance("TJCore")
    public static TJCore instance;

    @SidedProxy(modId = "TJCore", clientSide = "TJCore.client.ClientProxy", serverSide = "TJCore.common.ServerProxy")
    public static ServerProxy proxy;

}
