package TJCore.common;

import TJCore.TJValues;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = TJValues.MODID, value = Side.CLIENT)
public class Textures {
    public static OrientedOverlayRenderer STEAM_ASSEMBLER_OVERLAY;

    public static void preInit() {
        STEAM_ASSEMBLER_OVERLAY = new OrientedOverlayRenderer("machines/steam_assembler", OrientedOverlayRenderer.OverlayFace.FRONT);
    }
}
