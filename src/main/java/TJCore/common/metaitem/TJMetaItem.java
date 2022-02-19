package TJCore.common.metaitem;

import TJCore.common.tools.ToolLithographyMask;
import gregtech.api.items.metaitem.*;
import static gregtech.api.unification.material.MarkerMaterials.*;


import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.ore.OrePrefix;

import static TJCore.common.metaitem.TJMetaItems.*;

public class TJMetaItem extends StandardMetaItem {

    public TJMetaItem() { super(); }

    @Override
    public void registerSubItems() {
        SMD_RESISTOR_1      = addItem(1, "component.smd_resistor_1").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_1    = addItem(2, "component.smd_transistor_1").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_1         = addItem(3, "component.smd_diode_1").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_1     = addItem(4, "component.smd_capacitor_1").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_1      = addItem(5, "component.smd_inductor_1").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_2      = addItem(6, "component.smd_resistor_2").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_2    = addItem(7, "component.smd_transistor_2").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_2         = addItem(8, "component.smd_diode_2").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_2     = addItem(9, "component.smd_capacitor_2").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_2      = addItem(10, "component.smd_inductor_2").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_3      = addItem(11, "component.smd_resistor_3").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_3    = addItem(12, "component.smd_transistor_3").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_3         = addItem(13, "component.smd_diode_3").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_3     = addItem(14, "component.smd_capacitor_3").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_3      = addItem(15, "component.smd_inductor_3").setUnificationData(OrePrefix.component, Component.Inductor);

        PRIMITIVE_ASSEMBLY_ULV = addItem(100, "circuit.primitive_assembly").setUnificationData(OrePrefix.circuit, Tier.Primitive);
        PRIMITIVE_COMPUTER_LV = addItem(101, "circuit.primitive_computer").setUnificationData(OrePrefix.circuit, Tier.Basic);
        PRIMITIVE_MAINFRAME_MV = addItem(102, "circuit.primitive_mainframe").setUnificationData(OrePrefix.circuit, Tier.Good);

        ELECTRONIC_PROCESSOR_ULV = addItem(103,"circuit.electronic_processor").setUnificationData(OrePrefix.circuit, Tier.Primitive);
        ELECTRONIC_ASSEMBLY_LV = addItem(104, "circuit.electronic_assembly").setUnificationData(OrePrefix.circuit, Tier.Basic);
        ELECTRONIC_COMPUTER_MV = addItem(105, "circuit.electronic_computer").setUnificationData(OrePrefix.circuit, Tier.Good);
        ELECTRONIC_MAINFRAME_HV = addItem(106,"circuit.electronic_mainframe").setUnificationData(OrePrefix.circuit, Tier.Advanced);

        INTEGRATED_PROCESSOR_LV = addItem(107, "circuit.integrated_processor").setUnificationData(OrePrefix.circuit, Tier.Basic);
        INTEGRATED_ASSEMBLY_MV  = addItem(108, "circuit.integrated_assembly").setUnificationData(OrePrefix.circuit, Tier.Good);
        INTEGRATED_COMPUTER_HV  = addItem(109, "circuit.integrated_computer").setUnificationData(OrePrefix.circuit, Tier.Advanced);
        INTEGRATED_MAINFRAME_EV = addItem(110, "circuit.integrated_mainframe").setUnificationData(OrePrefix.circuit, Tier.Extreme);

        MICRO_PROCESSOR_MV      = addItem(111, "circuit.micro_processor").setUnificationData(OrePrefix.circuit, Tier.Good);
        MICRO_ASSEMBLY_HV       = addItem(112, "circuit.micro_assembly").setUnificationData(OrePrefix.circuit, Tier.Advanced);
        MICRO_COMPUTER_EV       = addItem(113, "circuit.micro_computer").setUnificationData(OrePrefix.circuit, Tier.Extreme);
        MICRO_MAINFRAME_IV      = addItem(114, "circuit.micro_mainframe").setUnificationData(OrePrefix.circuit, Tier.Elite);

        NANO_PROCESSOR_HV       = addItem(115, "circuit.nano_processor").setUnificationData(OrePrefix.circuit, Tier.Advanced);
        NANO_ASSEMBLY_EV        = addItem(116, "circuit.nano_assembly").setUnificationData(OrePrefix.circuit, Tier.Extreme);
        NANO_COMPUTER_IV        = addItem(117, "circuit.nano_computer").setUnificationData(OrePrefix.circuit, Tier.Elite);
        NANO_MAINFRAME_LUV      = addItem(118, "circuit.nano_mainframe").setUnificationData(OrePrefix.circuit, Tier.Master);

        IMC_PROCESSOR_EV        = addItem(119, "circuit.imc_processor").setUnificationData(OrePrefix.circuit, Tier.Extreme);
        IMC_ASSEMBLY_IV         = addItem(120, "circuit.imc_assembly").setUnificationData(OrePrefix.circuit, Tier.Elite);
        IMC_COMPUTER_LUV        = addItem(121, "circuit.imc_computer").setUnificationData(OrePrefix.circuit, Tier.Master);
        IMC_MAINFRAME_ZPM       = addItem(122, "circuit.imc_mainframe").setUnificationData(OrePrefix.circuit, Tier.Ultimate);

        OPTICAL_PROCESSOR_IV    = addItem(123, "circuit.optical_processor").setUnificationData(OrePrefix.circuit, Tier.Elite);
        OPTICAL_ASSEMBLY_LUV    = addItem(124, "circuit.optical_assembly").setUnificationData(OrePrefix.circuit, Tier.Master);
        OPTICAL_COMPUTER_ZPM    = addItem(125, "circuit.optical_computer").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        OPTICAL_MAINFRAME_UV    = addItem(126, "circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, Tier.Super);

        CRYSTAL_PROCESSOR_LUV   = addItem(127, "circuit.crystal_processor").setUnificationData(OrePrefix.circuit, Tier.Master);
        CRYSTAL_ASSEMBLY_ZPM    = addItem(128, "circuit.crystal_assembly").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        CRYSTAL_COMPUTER_UV     = addItem(129, "circuit.crystal_computer").setUnificationData(OrePrefix.circuit, Tier.Super);
        CRYSTAL_MAINFRAME_UHV   = addItem(130, "circuit.crystal_mainframe").setUnificationData(OrePrefix.circuit, Tier.Infinite);

        BIOWARE_PROCESSOR_ZPM   = addItem(131, "circuit.bioware_processor").setUnificationData(OrePrefix.circuit, Tier.Ultimate);
        BIOWARE_ASSEMBLY_UV     = addItem(132, "circuit.bioware_assembly").setUnificationData(OrePrefix.circuit, Tier.Super);
        BIOWARE_COMPUTER_UHV    = addItem(133, "circuit.bioware_computer").setUnificationData(OrePrefix.circuit, Tier.Infinite);
        BIOWARE_MAINFRAME_UEV   = addItem(134, "circuit.bioware_mainframe").setUnificationData(OrePrefix.circuit, Tier.Ultra);

        WETWARE_PROCESSOR_UV    = addItem(135, "circuit.wetware_processor").setUnificationData(OrePrefix.circuit, Tier.Super);
        WETWARE_ASSEMBLY_UHV    = addItem(136, "circuit.wetware_assembly").setUnificationData(OrePrefix.circuit, Tier.Infinite);
        WETWARE_COMPUTER_UEV    = addItem(137, "circuit.wetware_computer").setUnificationData(OrePrefix.circuit, Tier.Ultra);
        WETWARE_MAINFRAME_UIV   = addItem(138, "circuit.wetware_mainframe").setUnificationData(OrePrefix.circuit, Tier.Insane);
    }

}
