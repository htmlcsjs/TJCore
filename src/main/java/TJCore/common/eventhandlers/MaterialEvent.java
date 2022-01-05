package TJCore.common.eventhandlers;


import TJCore.TJValues;
import TJCore.common.material.materials.TJFirstDegreeMaterials;
import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class MaterialEvent {

    @SubscribeEvent
    public static void onMaterialsInit(GregTechAPI.MaterialEvent event) {

        TJFirstDegreeMaterials.register();
    }


}
