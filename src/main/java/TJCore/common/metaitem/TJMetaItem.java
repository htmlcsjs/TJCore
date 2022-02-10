package TJCore.common.metaitem;

import gregtech.api.items.metaitem.*;
import static gregtech.api.unification.material.MarkerMaterials.*;
import gregtech.api.unification.ore.OrePrefix;

import static TJCore.common.metaitem.TJMetaItems.*;

public class TJMetaItem extends StandardMetaItem {

    public TJMetaItem() { super(); }

    @Override
    public void registerSubItems() {
        PRIMITIVE_ASSEMBLY_ULV = addItem(100, "circuit.primitive_assembly").setUnificationData(OrePrefix.circuit, Tier.Primitive);
        PRIMITIVE_COMPUTER_LV = addItem(101, "circuit.primitive_computer").setUnificationData(OrePrefix.circuit, Tier.Basic);
        PRIMITIVE_MAINFRAME_MV = addItem(102, "circuit.primitive_mainframe").setUnificationData(OrePrefix.circuit, Tier.Good);
    }

}
