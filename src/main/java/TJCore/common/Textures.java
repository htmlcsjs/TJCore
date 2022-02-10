package TJCore.common;

import TJCore.TJValues;
import gregtech.api.util.GTLog;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleCubeRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import static gregtech.client.renderer.texture;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Level;

@Mod.EventBusSubscriber(modid = TJValues.MODID, value = Side.CLIENT)
public class TJTextures {
    public static SimpleCubeRenderer Brick;
    public static SimpleOverlayRenderer TreeFarmerController;
    public static OrientedOverlayRenderer STEAM_ASSEMBLER_OVERLAY;

    public static void preInit() {
        Brick = new SimpleCubeRenderer("minecraft:blocks/brick");
        TreeFarmerController = ;
        STEAM_ASSEMBLER_OVERLAY = new OrientedOverlayRenderer("machines/steam_assembler", OrientedOverlayRenderer.OverlayFace.FRONT);
    }
}
