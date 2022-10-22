package TJCore.api;

import TJCore.TJValues;
import TJCore.api.material.TJMaterials;
import TJCore.api.material.materials.info.TJMaterialIconTypes;
import com.brandon3055.draconicevolution.DEFeatures;
import gregtech.api.GTValues;
import gregtech.api.items.materialitem.MetaPrefixItem;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.oredict.OreDictionary;
import org.jline.builtins.Nano;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class TJOreDictionaryLoader {

    public static final OrePrefix nanoWire = new OrePrefix("nanowire", (long)GTValues.M / 144, null, TJMaterialIconTypes.nanoWireIcon, ENABLE_UNIFICATION, null);

    public static void init() {
        registerOrePrefixes();
        if (Loader.isModLoaded("draconicevolution")) {
            initDE();
        }
    }

    @Optional.Method(modid = "draconicevolution")
    private static void initDE() {
        for (int i = 0; i < 12; i++) {
            OreDictionary.registerOre("itemUpgradeKey", new ItemStack(DEFeatures.toolUpgrade, 1, i));
        }
    }

    public static final MaterialFlag GENERATE_NANOWIRE = new MaterialFlag.Builder("generate_nanowire")
            .requireProps(PropertyKey.FLUID)
            .build();


    public static void registerOrePrefixes() {
        nanoWire.setGenerationCondition(material -> ((material.isElement() && material.isSolid() && material.hasFluid())) || material.hasFlag(GENERATE_NANOWIRE));
        createMaterialItem(nanoWire);
    }

    public static void createMaterialItem(OrePrefix orePrefix) {
        MetaPrefixItem item = new MetaPrefixItem(orePrefix);
        item.setRegistryName(TJValues.MODID, orePrefix.name());
    }
}
