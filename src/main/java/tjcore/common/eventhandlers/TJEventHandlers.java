package tjcore.common.eventhandlers;

import gregtech.api.GregTechAPI;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import tjcore.TJValues;
import tjcore.api.material.materials.TJFirstDegreeMaterials;

import tjcore.common.pipelike.rotation.world.WorldAxleFull;

import static tjcore.common.CommonProxy.PipelineManager;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class TJEventHandlers {

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event) {
        WorldAxleFull.update();
    }

    @SubscribeEvent
    public static void onMaterialsInit(GregTechAPI.MaterialEvent event) {
        TJFirstDegreeMaterials.registerMaterials();
        TJFirstDegreeMaterials.registerProperties();
    }

    @SubscribeEvent
    public static void onWorldLoadEvent(WorldEvent.Load event) {
        PipelineManager.clean(event.getWorld());
    }
}
