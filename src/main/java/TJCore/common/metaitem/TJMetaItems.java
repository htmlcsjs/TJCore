package TJCore.common.metaitem;


import TJCore.common.tools.TJToolMetaItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.toolitem.ToolMetaItem;

import java.util.*;

public class TJMetaItems {

    public static final List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static void init() {
        TJMetaItem items = new TJMetaItem();
        items.setRegistryName("TJMetaItem");

        TJToolMetaItem tools = new TJToolMetaItem();
        tools.setRegistryName("TJMetaTool");
    }

    //public static MetaItem<?>.MetaValueItem RESISTOR;
    //public static MetaItem<?>.MetaValueItem TRANSISTOR;
    //public static MetaItem<?>.MetaValueItem DIODE;
    //public static MetaItem<?>.MetaValueItem CAPACITOR;
    //public static MetaItem<?>.MetaValueItem INDUCTOR;

    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_5;

    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_5;

    public static MetaItem<?>.MetaValueItem SMD_DIODE_1;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_2;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_3;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_4;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_5;

    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_1;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_2;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_3;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_4;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_5;

    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_5;

    public static MetaItem<?>.MetaValueItem PRIMITIVE_ASSEMBLY_ULV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_COMPUTER_LV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_MAINFRAME_MV;

    public static MetaItem<?>.MetaValueItem ELECTRONIC_PROCESSOR_ULV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_ASSEMBLY_LV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_COMPUTER_MV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_MAINFRAME_HV;

    public static MetaItem<?>.MetaValueItem INTEGRATED_PROCESSOR_LV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_ASSEMBLY_MV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_COMPUTER_HV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_MAINFRAME_EV;

    public static MetaItem<?>.MetaValueItem MICRO_PROCESSOR_MV;
    public static MetaItem<?>.MetaValueItem MICRO_ASSEMBLY_HV;
    public static MetaItem<?>.MetaValueItem MICRO_COMPUTER_EV;
    public static MetaItem<?>.MetaValueItem MICRO_MAINFRAME_IV;

    public static MetaItem<?>.MetaValueItem NANO_PROCESSOR_HV;
    public static MetaItem<?>.MetaValueItem NANO_ASSEMBLY_EV;
    public static MetaItem<?>.MetaValueItem NANO_COMPUTER_IV;
    public static MetaItem<?>.MetaValueItem NANO_MAINFRAME_LUV;

    public static MetaItem<?>.MetaValueItem IMC_PROCESSOR_EV;
    public static MetaItem<?>.MetaValueItem IMC_ASSEMBLY_IV;
    public static MetaItem<?>.MetaValueItem IMC_COMPUTER_LUV;
    public static MetaItem<?>.MetaValueItem IMC_MAINFRAME_ZPM;

    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_IV;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY_LUV;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER_ZPM;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME_UV;

    public static MetaItem<?>.MetaValueItem CRYSTAL_PROCESSOR_LUV;
    public static MetaItem<?>.MetaValueItem CRYSTAL_ASSEMBLY_ZPM;
    public static MetaItem<?>.MetaValueItem CRYSTAL_COMPUTER_UV;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MAINFRAME_UHV;

    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_ZPM;
    public static MetaItem<?>.MetaValueItem BIOWARE_ASSEMBLY_UV;
    public static MetaItem<?>.MetaValueItem BIOWARE_COMPUTER_UHV;
    public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME_UEV;

    public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR_UV;
    public static MetaItem<?>.MetaValueItem WETWARE_ASSEMBLY_UHV;
    public static MetaItem<?>.MetaValueItem WETWARE_COMPUTER_UEV;
    public static MetaItem<?>.MetaValueItem WETWARE_MAINFRAME_UIV;

    // less tiers of smd, make them upgrading on a *random* pattern
    // have like 4 or 5 tiers of each smd max (giving us a chance to make them more complex on later tiers than just wire, plate, fluid)

    //
    public static ToolMetaItem<?>.MetaToolValueItem LITHOGRAPHY_MASK;
}
