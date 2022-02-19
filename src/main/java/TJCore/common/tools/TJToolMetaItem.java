package TJCore.common.tools;

import TJCore.common.metaitem.TJMetaItem;
import TJCore.common.metaitem.TJMetaItems;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.unification.material.Material;

import static TJCore.common.metaitem.TJMetaItems.LITHOGRAPHY_MASK;
import static gregtech.api.unification.material.Materials.*;

public class TJToolMetaItem extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem> {

    @Override
    public void registerSubItems() {
        Material[] lithographyMaskMaterials = new Material[]{
                Polyethylene, PolyvinylChloride, Polytetrafluoroethylene
        };
        int[] durabilities = new int[]{500, 750, 1000};

        LITHOGRAPHY_MASK = (MetaToolValueItem) addItem(1000, "tool.lithography_mask").setToolStats(new ToolLithographyMask()).addOreDict(TJToolDictNames.LithographyMask.name());
        for(int i =0; i< lithographyMaskMaterials.length; i++) {
            LITHOGRAPHY_MASK.setToolData(LITHOGRAPHY_MASK.getStackForm(), lithographyMaskMaterials[i], durabilities[i], 1, 1.0f, 1.0f);
        }
    }

}
