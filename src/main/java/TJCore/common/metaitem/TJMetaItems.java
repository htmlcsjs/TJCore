package TJCore.common.metaitem;


import gregtech.api.items.metaitem.MetaItem;

import java.util.*;

public class TJMetaItems {

    public static final List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static void init() {
        TJMetaItem items = new TJMetaItem();
        items.setRegistryName("TJMetaItem");
    }

    public static MetaItem<?>.MetaValueItem PRIMITIVE_ASSEMBLY_ULV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_COMPUTER_LV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_MAINFRAME_MV;

    // less tiers of smd, make them upgrading on a *random* pattern
    // have like 4 or 5 tiers of each smd max (giving us a chance to make them more complex on later tiers than just wire, plate, fluid)

    //

}
