package TJCore.common.EventHandlers;


import TJCore.TJValues;
import TJCore.api.TJLog;
import TJCore.api.material.materials.TJFirstDegreeMaterials;
import TJCore.common.recipes.MaterialRecipes;
import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class MaterialEvent {

    @SubscribeEvent
    public static void onMaterialsInit(GregTechAPI.MaterialEvent event) {
        TJFirstDegreeMaterials.registerMaterials();
        TJFirstDegreeMaterials.registerProperties();


    }


}
