package tjcore.common;

import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleCubeRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import tjcore.TJValues;

@Mod.EventBusSubscriber(modid = TJValues.MODID, value = Side.CLIENT)
public class TJTextures {
    public static SimpleCubeRenderer Brick;
    public static SimpleOverlayRenderer TreeFarmerController;
    public static OrientedOverlayRenderer STEAM_ASSEMBLER_OVERLAY;
    public static SimpleOverlayRenderer ROTATION_OVERLAY;

    // Casings
    public static SimpleOverlayRenderer DRACONIC_CASING;

    public static void preInit() {
        Brick = new SimpleCubeRenderer("minecraft:blocks/brick");
        TreeFarmerController = Textures.FROST_PROOF_CASING;
        STEAM_ASSEMBLER_OVERLAY = new OrientedOverlayRenderer("machines/steam_assembler", OrientedOverlayRenderer.OverlayFace.FRONT);
        ROTATION_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_rotation");

        // Casings
        DRACONIC_CASING = new SimpleOverlayRenderer("casings/draconic_casing/draconic_casing_normal");
    }
}
