package tjcore.common.eventhandlers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import tjcore.TJValues;
import tjcore.common.pipelike.rotation.world.WorldAxleFull;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class OnTickEvent {

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event) {
        WorldAxleFull.update();
    }
}
