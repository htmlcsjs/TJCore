package TJCore.api;

import com.brandon3055.draconicevolution.DEFeatures;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class TJOreDictionaryLoader {
    public static void init() {
        for (int i=0; i<12; i++) {
            OreDictionary.registerOre("itemUpgradeKey", new ItemStack(DEFeatures.toolUpgrade, 1, i));
        }
    }
}
