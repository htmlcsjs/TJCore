package tjcore.common.eventhandlers;


import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tjcore.TJValues;
import tjcore.api.material.materials.TJFirstDegreeMaterials;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class MaterialEvent {

    @SubscribeEvent
    public static void onMaterialsInit(GregTechAPI.MaterialEvent event) {
        TJFirstDegreeMaterials.registerMaterials();
        TJFirstDegreeMaterials.registerProperties();
    }
}
