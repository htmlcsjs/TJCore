package TJCore.common.metaitem;

import TJCore.common.tools.ToolLithographyMask;
import gregtech.api.items.metaitem.*;
import static gregtech.api.unification.material.MarkerMaterials.*;


import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.unification.material.Material;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.ore.OrePrefix;

import static TJCore.common.metaitem.TJMetaItems.*;

public class    TJMetaItem extends StandardMetaItem {

    public TJMetaItem() { super(); }

    @Override
    public void registerSubItems() {

        SMD_RESISTOR_1 = addItem(1, "component.smd_resistor_1").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_1 = addItem(2, "component.smd_transistor_1").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_1 = addItem(3, "component.smd_diode_1").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_1 = addItem(4, "component.smd_capacitor_1").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_1 = addItem(5, "component.smd_inductor_1").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_2 = addItem(6, "component.smd_resistor_2").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_2 = addItem(7, "component.smd_transistor_2").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_2 = addItem(8, "component.smd_diode_2").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_2 = addItem(9, "component.smd_capacitor_2").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_2 = addItem(10, "component.smd_inductor_2").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_3 = addItem(11, "component.smd_resistor_3").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_3 = addItem(12, "component.smd_transistor_3").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_3 = addItem(13, "component.smd_diode_3").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_3 = addItem(14, "component.smd_capacitor_3").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_3 = addItem(15, "component.smd_inductor_3").setUnificationData(OrePrefix.component, Component.Inductor);

        PRIMITIVE_PREBOARD = addItem(50, "primitive_preboard");
        ELECTRONIC_PREBOARD = addItem(51, "electronic_preboard");
        INTEGRATED_PREBOARD = addItem(52, "integrated_preboard");
        MICRO_PREBOARD = addItem(53, "micro_preboard");
        NANO_PREBOARD = addItem(54, "nano_preboard");
        IMC_PREBOARD = addItem(55, "imc_preboard");
        OPTICAL_PREBOARD = addItem(56, "optical_preboard");
        CRYSTAL_PREBOARD = addItem(57, "crystal_preboard");
        BIOWARE_PREBOARD = addItem(58, "bioware_preboard");
        WETWARE_PREBOARD = addItem(59, "wetware_preboard");
        QUANTUM_PREBOARD = addItem(60, "quantum_preboard");
        EXOTIC_PREBOARD = addItem(61, "exotic_preboard");
        COSMIC_PREBOARD = addItem(62, "cosmic_preboard");
        SUPRA_PREBOARD = addItem(63, "supra_preboard");

        PRIMITIVE_BOARD = addItem(64, "primitive_board");
        ELECTRONIC_BOARD = addItem(65, "electronic_board");
        INTEGRATED_BOARD = addItem(66, "integrated_board");
        MICRO_BOARD = addItem(67, "micro_board");
        NANO_BOARD = addItem(68, "nano_board");
        IMC_BOARD = addItem(69, "imc_board");
        OPTICAL_BOARD = addItem(70, "optical_board");
        CRYSTAL_BOARD = addItem(71, "crystal_board");
        BIOWARE_BOARD = addItem(72, "bioware_board");
        WETWARE_BOARD = addItem(73, "wetware_board");
        QUANTUM_BOARD = addItem(74, "quantum_board");
        EXOTIC_BOARD = addItem(75, "exotic_board");
        COSMIC_BOARD = addItem(76, "cosmic_board");
        SUPRA_BOARD = addItem(77, "supra_board");

        PRIMITIVE_ASSEMBLY_ULV = addItem(100, "circuit.primitive_assembly_ulv").setUnificationData(OrePrefix.circuit,   Tier.ULV);
        PRIMITIVE_COMPUTER_LV = addItem(101, "circuit.primitive_computer_lv").setUnificationData(OrePrefix.circuit,    Tier.LV);
        PRIMITIVE_MAINFRAME_MV = addItem(102, "circuit.primitive_mainframe_mv").setUnificationData(OrePrefix.circuit,  Tier.MV);

        ELECTRONIC_PROCESSOR_ULV = addItem(103, "circuit.electronic_processor_ulv").setUnificationData(OrePrefix.circuit,   Tier.ULV);
        ELECTRONIC_ASSEMBLY_LV = addItem(104, "circuit.electronic_assembly_lv").setUnificationData(OrePrefix.circuit,      Tier.LV);
        ELECTRONIC_COMPUTER_MV = addItem(105, "circuit.electronic_computer_mv").setUnificationData(OrePrefix.circuit,      Tier.MV);
        ELECTRONIC_MAINFRAME_HV = addItem(106, "circuit.electronic_mainframe_hv").setUnificationData(OrePrefix.circuit,    Tier.HV);

        INTEGRATED_PROCESSOR_LV = addItem(107, "circuit.integrated_processor_lv").setUnificationData(OrePrefix.circuit,    Tier.LV);
        INTEGRATED_ASSEMBLY_MV = addItem(108, "circuit.integrated_assembly_mv").setUnificationData(OrePrefix.circuit,      Tier.MV);
        INTEGRATED_COMPUTER_HV = addItem(109, "circuit.integrated_computer_hv").setUnificationData(OrePrefix.circuit,      Tier.HV);
        INTEGRATED_MAINFRAME_EV = addItem(110, "circuit.integrated_mainframe_ev").setUnificationData(OrePrefix.circuit,    Tier.EV);

        MICRO_PROCESSOR_MV = addItem(111, "circuit.micro_processor_mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        MICRO_ASSEMBLY_HV = addItem(112, "circuit.micro_assembly_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        MICRO_COMPUTER_EV = addItem(113, "circuit.micro_computer_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        MICRO_MAINFRAME_IV = addItem(114, "circuit.micro_mainframe_iv").setUnificationData(OrePrefix.circuit, Tier.IV);

        NANO_PROCESSOR_HV = addItem(115, "circuit.nano_processor_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        NANO_ASSEMBLY_EV = addItem(116, "circuit.nano_assembly_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        NANO_COMPUTER_IV = addItem(117, "circuit.nano_computer_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        NANO_MAINFRAME_LUV = addItem(118, "circuit.nano_mainframe_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);

        IMC_PROCESSOR_EV = addItem(119, "circuit.imc_processor_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        IMC_ASSEMBLY_IV = addItem(120, "circuit.imc_assembly_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        IMC_COMPUTER_LUV = addItem(121, "circuit.imc_computer_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        IMC_MAINFRAME_ZPM = addItem(122, "circuit.imc_mainframe_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);

        OPTICAL_PROCESSOR_IV = addItem(123, "circuit.optical_processor_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        OPTICAL_ASSEMBLY_LUV = addItem(124, "circuit.optical_assembly_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        OPTICAL_COMPUTER_ZPM = addItem(125, "circuit.optical_computer_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        OPTICAL_MAINFRAME_UV = addItem(126, "circuit.optical_mainframe_uv").setUnificationData(OrePrefix.circuit, Tier.UV);

        CRYSTAL_PROCESSOR_LUV = addItem(127, "circuit.crystal_processor_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        CRYSTAL_ASSEMBLY_ZPM = addItem(128, "circuit.crystal_assembly_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        CRYSTAL_COMPUTER_UV = addItem(129, "circuit.crystal_computer_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        CRYSTAL_MAINFRAME_UHV = addItem(130, "circuit.crystal_mainframe_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);

        WETWARE_PROCESSOR_ZPM = addItem(131, "circuit.wetware_processor_zpm").setUnificationData(OrePrefix.circuit, Tier.UV);
        WETWARE_ASSEMBLY_UV = addItem(132, "circuit.wetware_assembly_uv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        WETWARE_COMPUTER_UHV = addItem(133, "circuit.wetware_computer_uhv").setUnificationData(OrePrefix.circuit, Tier.UEV);
        WETWARE_MAINFRAME_UEV = addItem(134, "circuit.wetware_mainframe_uev").setUnificationData(OrePrefix.circuit, Tier.UIV);

        BIOWARE_PROCESSOR_UV = addItem(135, "circuit.bioware_processor_uv").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        BIOWARE_ASSEMBLY_UHV = addItem(136, "circuit.bioware_assembly_uhv").setUnificationData(OrePrefix.circuit, Tier.UV);
        BIOWARE_COMPUTER_UEV = addItem(137, "circuit.bioware_computer_uev").setUnificationData(OrePrefix.circuit, Tier.UHV);
        BIOWARE_MAINFRAME_UIV = addItem(138,"circuit.bioware_mainframe_uiv");

        QUANTUM_PROCESSOR_UHV = addItem(139,"circuit.quantum_processor_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        QUANTUM_ASSEMBLY_UEV = addItem(140,"circuit.quantum_assembly_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        QUANTUM_COMPUTER_UIV = addItem(141,"circuit.quantum_computer_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        QUANTUM_MAINFRAME_UXV = addItem(142,"circuit.quantum_mainframe_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);

        EXOTIC_PROCESSOR_UEV = addItem(143,"circuit.exotic_processor_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        EXOTIC_ASSEMBLY_UIV = addItem(144,"circuit.exotic_assembly_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        EXOTIC_COMPUTER_UXV = addItem(145,"circuit.exotic_computer_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        EXOTIC_MAINFRAME_OPV = addItem(146,"circuit.exotic_mainframe_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);

        COSMIC_PROCESSOR_UIV = addItem(147,"circuit.cosmic_processor_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        COSMIC_ASSEMBLY_UXV = addItem(148,"circuit.cosmic_assembly_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        COSMIC_COMPUTER_OPV = addItem(149,"circuit.cosmic_computer_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        COSMIC_MAINFRAME_MAX = addItem(150,"circuit.cosmic_mainframe_max").setUnificationData(OrePrefix.circuit, Tier.MAX);

        SUPRA_PROCESSOR_UXV = addItem(151,"circuit.supra_processor_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        SUPRA_ASSEMBLY_OPV = addItem(152,"circuit.supra_assembly_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        SUPRA_COMPUTER_MAX = addItem(153,"circuit.supra_computer_max").setUnificationData(OrePrefix.circuit, Tier.MAX);
        SUPRA_MAINFRAME_ALL = addItem(154,"circuit.supra_mainframe_all")
                .setUnificationData(OrePrefix.circuit, Tier.ULV)
                .setUnificationData(OrePrefix.circuit, Tier.LV)
                .setUnificationData(OrePrefix.circuit, Tier.MV)
                .setUnificationData(OrePrefix.circuit, Tier.HV)
                .setUnificationData(OrePrefix.circuit, Tier.EV)
                .setUnificationData(OrePrefix.circuit, Tier.IV)
                .setUnificationData(OrePrefix.circuit, Tier.LuV)
                .setUnificationData(OrePrefix.circuit, Tier.ZPM)
                .setUnificationData(OrePrefix.circuit, Tier.UV)
                .setUnificationData(OrePrefix.circuit, Tier.UHV)
                .setUnificationData(OrePrefix.circuit, Tier.UEV)
                .setUnificationData(OrePrefix.circuit, Tier.UIV)
                .setUnificationData(OrePrefix.circuit, Tier.UXV)
                .setUnificationData(OrePrefix.circuit, Tier.OpV)
                .setUnificationData(OrePrefix.circuit, Tier.MAX);


        TREATED_CPU_WAFER = addItem(200, "wafer.cpu_treated");
        TREATED_RAM_WAFER = addItem(201, "wafer.ram_treated");
        TREATED_ULPIC_WAFER = addItem(202, "wafer.ulpic_treated");
        TREATED_NANO_CPU_WAFER = addItem(203, "wafer.nano_cpu_treated");

        //METAITEMS FOR CIRCUITS / FRAMEWORKS
        WETPHENOLICPULP = addItem(300, "wetphenolicpulp");
        WETPRESSEDPHENOLICSUBSTRATE = addItem(301, "wetpressedphenolicsubstrate");

        //METAITEMS FOR WAFERS
        SILICON_BOULE = addItem(500, "silicon_boule");
        ANTIMONY_DOPED_SILICON_BOULE = addItem(501, "antimony_doped_silicon_boule");
        BORON_DOPED_SILICON_BOULE = addItem(502, "boron_doped_silicon_boule");
        GALLIUM_ARSENIDE_BOULE = addItem(503, "gallium_arsenide_boule");
        SILVER_GALLIUM_SELENIDE_BOULE = addItem(504, "siliver_gallium_selenide_boule");

        SILICON_WAFER = addItem(505, "silicon_wafter");
        ANTIMONY_DOPED_SILICON_WAFER = addItem(506, "antimony_doped_silicon_wafter");
        BORON_DOPED_SILICON_WAFER = addItem(507, "boron_doped_silicon_wafter");
        GALLIUM_ARSENIDE_WAFER = addItem(508, "gallium_arsenide_wafter");
        SILVER_GALLIUM_SELENIDE_WAFER = addItem(509, "siliver_gallium_selenide_wafter");

        LAYERED_SILICON_WAFER = addItem(505+5, "layered_silicon_wafer");
        LAYERED_ANTIMONY_DOPED_SILICON_WAFER = addItem(506+5, "layered_antimoy_doped_silicon_wafer");
        LAYERED_BORON_DOPED_SILICON_WAFER = addItem(507+5, "layered_boron_doped_silicon_wafer");
        LAYERED_GALLIUM_ARSENIDE_WAFER = addItem(508+5, "layered_gallium_arsenide_wafer");
        LAYERED_SILVER_GALLIUM_SELENIDE_WAFER = addItem(509+5, "layered_silver_gallium_selenide_wafer");

        PREPARED_SILICON_WAFER = addItem(510+5, "prepared_silicon_wafer");
        PREPARED_ANTIMONY_DOPED_SILICON_WAFER = addItem(511+5, "prepared_antimony_doped_silicon_wafer");
        PREPARED_BORON_DOPED_SILICON_WAFER = addItem(512+5, "prepared_boron_doped_silicon_wafer");
        PREPARED_GALLIUM_ARSENIDE_WAFER = addItem(513+5, "prepared_gallium_arsenide_wafer");
        PREPARED_SILVER_GALLIUM_SELENIDE_WAFER = addItem(514+5, "prepared_silver_gallium_selenide_wafer");

        INTEGRATED_WAFER_LITHOGRAPHY_PREP = addItem(515+5, "integrated_wafer_lithography_prep");
        MICRO_WAFER_LITHOGRAPHY_PREP = addItem(516+5, "micro_wafer_lithography_prep");
        NANO_WAFER_LITHOGRAPHY_PREP = addItem(517+5, "nano_wafer_lithography_prep");
        IMC_WAFER_LITHOGRAPHY_PREP = addItem(518+5, "imc_wafer_lithography_prep");
        OPTICAL_WAFER_LITHOGRAPHY_PREP = addItem(519+5, "optical_wafer_lithography_prep");

        PREBAKED_INTEGRATED_WAFER = addItem(520+5, "prebaked_integrated_wafer");
        PREBAKED_MICRO_WAFER = addItem(521+5, "prebaked_micro_wafer");
        PREBAKED_NANO_WAFER = addItem(522+5, "prebaked_nano_wafer");
        PREBAKED_IMC_WAFER = addItem(523+5, "prebaked_imc_wafer");
        PREBAKED_OPTICAL_WAFER = addItem(524+5, "prebaked_optical_wafer");

        TREATED_INTEGRATED_WAFER = addItem(525+5, "treated_integrated_wafer");
        TREATED_MICRO_WAFER = addItem(526+5, "treated_micro_wafer");
        TREATED_NANO_WAFER = addItem(527+5, "treated_nano_wafer");
        TREATED_IMC_WAFER = addItem(528+5, "treated_imc_wafer");
        TREATED_OPTICAL_WAFER = addItem(529+5, "treated_optical_wafer");

        RAW_INTEGRATED_WAFER = addItem(530+5, "raw_integrated_wafer");
        RAW_MICRO_WAFER = addItem(531+5, "raw_micro_wafer");
        RAW_NANO_WAFER = addItem(532+5, "raw_nano_wafer");
        RAW_IMC_WAFER = addItem(533+5, "raw_imc_wafer");
        RAW_OPTICAL_WAFER = addItem(534+5, "raw_optical_wafer");

        BAKED_INTEGRATED_WAFER = addItem(535+5, "baked_integrated_wafer");
        BAKED_MICRO_WAFER = addItem(536+5, "baked_micro_wafer");
        BAKED_NANO_WAFER = addItem(537+5, "baked_nano_wafer");
        BAKED_IMC_WAFER = addItem(538+5, "baked_imc_wafer");
        BAKED_OPTICAL_WAFER = addItem(539+5, "baked_optical_wafer");

        INTEGRATED_WAFER = addItem(540+5, "integrated_wafer");
        MICRO_WAFER = addItem(541+5, "micro_wafer");
        NANO_WAFER = addItem(542+5, "nano_wafer");
        IMC_WAFER = addItem(543+5, "imc_wafer");
        OPTICAL_WAFER = addItem(544+5, "optical_wafer");

        ETCHED_INTEGRATED_WAFER = addItem(545+5, "etched_integrated_wafer");
        ETCHED_MICRO_WAFER = addItem(546+5, "etched_micro_wafer");
        ETCHED_NANO_WAFER = addItem(547+5, "etched_nano_wafer");
        ETCHED_IMC_WAFER = addItem(548+5, "etched_imc_wafer");
        ETCHED_OPTICAL_WAFER = addItem(549+5, "etched_optical_wafer");

        INTEGRATED_CHIP = addItem(550+5, "integrated_chip");
        MICRO_CHIP = addItem(551+5, "micro_chip");
        NANO_CHIP = addItem(552+5, "nano_chip");
        IMC_CHIP = addItem(553+5, "imc_chip");
        OPTICAL_CHIP = addItem(554+5, "optical_chip");

        INTEGRATED_HARD_MASK = addItem(560, "integrated_hard_mask");
        MICRO_HARD_MASK = addItem(561, "micro_hard_mask");
        NANO_HARD_MASK = addItem(562, "nano_hard_mask");
        IMC_HARD_MASK = addItem(563, "imc_hard_mask");
        OPTICAL_HARD_MASK = addItem(564, "optical_hard_mask");

        UVEMITTER_A = addItem(565, "uvemitter_a");
        UVEMITTER_B = addItem(566, "uvemitter_b");
        UVEMITTER_C = addItem(567, "uvemitter_c");
        UVEMITTER_D = addItem(568, "uvemitter_d");
        UVEMITTER_E = addItem(569, "uvemitter_e");

        // Micro-Nano PCB ITEMS
        COPPER_LAMINATED_EPOXID = addItem(570, "copperlaminatedepoxid");
        ELECTRUM_LAMINATED_EPOXID = addItem(571, "electrumlaminatedepoxid");
        GERMANIUM_LAMINATED_EPOXID = addItem(572,"germaniumlaminatedepoxid");
        FIBERGLASS_MESH = addItem(573,"fiberglassmesh");

        // Optical PCB ITEMS
        ZBLANMATRIX = addItem(574,"zblanmatrix");
        OPTICAL_BASE = addItem(575,"opticalbase");
        LAMINATED_OPTICAL_BASE = addItem(576,"laminatedopticalbase");

        // Crystal CHIP ITEMS
        COATED_SAPPHIRE_WAFER = addItem(577,"coatedsapphirewafer");
        DIRTY_COATED_SAPPHIRE_WAFER = addItem(578,"dirtycoatedsapphirewafer");
        CLEANED_COATED_SAPPHIRE_WAFER = addItem(579,"cleanedcoatedsapphirewafer");
        SAPPHIRE_SUBSTRATE_PREP = addItem(580,"sapphiresubstrateprep");
        ETCHED_SAPPHIRE_WAFER = addItem(581,"etchedsapphirewafer");
        SUPERHEATED_SAPPHIRE_WAFER = addItem(582,"superheatedsapphirewafer");
        VIABLE_SAPPHIRE_WAFER = addItem(583,"viablesapphirewafer");
        NONVIABLE_SAPPHIRE_WAFER = addItem(584,"nonviablesapphirewafer");
        RECYCLED_SAPPHIRE_WAFER = addItem(585,"recycledsapphirewafer");
        SINTERED_SAPPHIRE_WAFER = addItem(586,"sinteredsapphirewafer");
        WIRED_SAPPHIRE_WAFER = addItem(587,"wiredsapphirewafer");
        SAPPHIRE_WAFER = addItem(588,"sapphirewafer");
        RAW_SAPPHIRE_CHIP = addItem(601, "raw_crystal_chip");
        SAPPHIRE_CHIP = addItem(589,"sapphirechip");

        // Electronic CHIP ITEMS

        SIMPLE_CPU_WAFER = addItem(590,"simplecpuwafer");
        SIMPLE_CPU = addItem(591, "simplecpu");

        // Crystal PCB Items

        PROCESSED_CRYSTAL_WAFER = addItem(592,"processed_crystal_wafer");
        CRYSTAL_SFET_BUNDLE = addItem(595,"crystal_sfet_bundle");
        CRYSTAL_SFET_WAFER = addItem(596,"crystal_sfet_wafer");
        REFRACTING_SHEET = addItem(598,"refracting_sheet");
        LAMINATED_CRYSTAL_PCB_SHEET = addItem(599,"laminated_crystal_pcb_sheet");
        GAMMA_EMITTING_DIODE = addItem(600,"gamma_emitting_diode");

        // Misc. SMD ITEMS
        FERROUS_INDUCTOR_CORE = addItem(1001, "ferrousinductorcore");
        TUNGSTEN_INDUCTOR_CORE = addItem(1002,"tungsteninductorcore");
    }
}
