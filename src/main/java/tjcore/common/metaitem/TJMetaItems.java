package tjcore.common.metaitem;


import gregtech.api.items.metaitem.MetaItem;

import java.util.List;

public class TJMetaItems {

    public static final List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

    public static void init() {
        TJMetaItem items = new TJMetaItem();
        items.setRegistryName("TJMetaItem");
    }

    //public static MetaItem<?>.MetaValueItem RESISTOR;
    //public static MetaItem<?>.MetaValueItem TRANSISTOR;
    //public static MetaItem<?>.MetaValueItem DIODE;
    //public static MetaItem<?>.MetaValueItem CAPACITOR;
    //public static MetaItem<?>.MetaValueItem INDUCTOR;

    //Components + Microcrafting

    public static MetaItem<?>.MetaValueItem STEAM_MOTOR;
    public static MetaItem<?>.MetaValueItem STEAM_PISTON;
    public static MetaItem<?>.MetaValueItem STEAM_PUMP;
    public static MetaItem<?>.MetaValueItem CLEANROOM_FILTER;
    public static MetaItem<?>.MetaValueItem EVACUATED_TUBE;
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE;

    //CIRCUITFRAMEWORK
    public static MetaItem<?>.MetaValueItem WETPHENOLICPULP;
    public static MetaItem<?>.MetaValueItem WETPRESSEDPHENOLICSUBSTRATE;

    public static MetaItem<?>.MetaValueItem UVEMITTER_A;
    public static MetaItem<?>.MetaValueItem UVEMITTER_B;
    public static MetaItem<?>.MetaValueItem UVEMITTER_C;
    public static MetaItem<?>.MetaValueItem UVEMITTER_D;
    public static MetaItem<?>.MetaValueItem UVEMITTER_E;

    //SMDs

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

    //Boules + Wafers

    public static MetaItem<?>.MetaValueItem SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem ANTIMONY_DOPED_SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem BORON_DOPED_SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem GALLIUM_ARSENIDE_BOULE;
    public static MetaItem<?>.MetaValueItem SILVER_GALLIUM_SELENIDE_BOULE;

    public static MetaItem<?>.MetaValueItem SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem LAYERED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem PREPARED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem MICRO_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem NANO_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem IMC_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem OPTICAL_WAFER_LITHOGRAPHY_PREP;

    public static MetaItem<?>.MetaValueItem PREBAKED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem TREATED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem RAW_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem BAKED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem NANO_WAFER;
    public static MetaItem<?>.MetaValueItem IMC_WAFER;
    public static MetaItem<?>.MetaValueItem OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem ETCHED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_CHIP;
    public static MetaItem<?>.MetaValueItem MICRO_CHIP;
    public static MetaItem<?>.MetaValueItem NANO_CHIP;
    public static MetaItem<?>.MetaValueItem IMC_CHIP;
    public static MetaItem<?>.MetaValueItem OPTICAL_CHIP;

    public static MetaItem<?>.MetaValueItem INTEGRATED_HARD_MASK;
    public static MetaItem<?>.MetaValueItem MICRO_HARD_MASK;
    public static MetaItem<?>.MetaValueItem NANO_HARD_MASK;
    public static MetaItem<?>.MetaValueItem IMC_HARD_MASK;
    public static MetaItem<?>.MetaValueItem OPTICAL_HARD_MASK;

    public static MetaItem<?>.MetaValueItem BALLAST;
    public static MetaItem<?>.MetaValueItem EMPTY_GEISSLER_TUBE;

    public static MetaItem<?>.MetaValueItem EMPTY_ARC_LAMP;

    public static MetaItem<?>.MetaValueItem LASER_TUBE;

    //Circuit Boards
    public static MetaItem<?>.MetaValueItem PRIMITIVE_PREBOARD;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem INTEGRATED_PREBOARD;
    public static MetaItem<?>.MetaValueItem MICRO_PREBOARD;
    public static MetaItem<?>.MetaValueItem NANO_PREBOARD;
    public static MetaItem<?>.MetaValueItem IMC_PREBOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_PREBOARD;
    public static MetaItem<?>.MetaValueItem CRYSTAL_PREBOARD;
    public static MetaItem<?>.MetaValueItem BIOWARE_PREBOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_PREBOARD;
    public static MetaItem<?>.MetaValueItem QUANTUM_PREBOARD;
    public static MetaItem<?>.MetaValueItem EXOTIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem COSMIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem SUPRA_PREBOARD;

    public static MetaItem<?>.MetaValueItem PRIMITIVE_BOARD;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem INTEGRATED_BOARD;
    public static MetaItem<?>.MetaValueItem MICRO_BOARD;
    public static MetaItem<?>.MetaValueItem NANO_BOARD;
    public static MetaItem<?>.MetaValueItem IMC_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem CRYSTAL_BOARD;
    public static MetaItem<?>.MetaValueItem BIOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_BOARD;
    public static MetaItem<?>.MetaValueItem QUANTUM_BOARD;
    public static MetaItem<?>.MetaValueItem EXOTIC_BOARD;
    public static MetaItem<?>.MetaValueItem COSMIC_BOARD;
    public static MetaItem<?>.MetaValueItem SUPRA_BOARD;

    //Circuits
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

    public static MetaItem<?>.MetaValueItem QUANTUM_PROCESSOR_ZPM;
    public static MetaItem<?>.MetaValueItem QUANTUM_ASSEMBLY_UV;
    public static MetaItem<?>.MetaValueItem QUANTUM_COMPUTER_UHV;
    public static MetaItem<?>.MetaValueItem QUANTUM_MAINFRAME_UEV;

    public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR_UV;
    public static MetaItem<?>.MetaValueItem WETWARE_ASSEMBLY_UHV;
    public static MetaItem<?>.MetaValueItem WETWARE_COMPUTER_UEV;
    public static MetaItem<?>.MetaValueItem WETWARE_MAINFRAME_UIV;

    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_UHV;
    public static MetaItem<?>.MetaValueItem BIOWARE_ASSEMBLY_UEV;
    public static MetaItem<?>.MetaValueItem BIOWARE_COMPUTER_UIV;
    public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME_UXV;

    public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_UEV;
    public static MetaItem<?>.MetaValueItem EXOTIC_ASSEMBLY_UIV;
    public static MetaItem<?>.MetaValueItem EXOTIC_COMPUTER_UXV;
    public static MetaItem<?>.MetaValueItem EXOTIC_MAINFRAME_OPV;

    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_UIV;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY_UXV;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER_OPV;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME_MAX;

    public static MetaItem<?>.MetaValueItem SUPRA_PROCESSOR_UXV;
    public static MetaItem<?>.MetaValueItem SUPRA_ASSEMBLY_OPV;
    public static MetaItem<?>.MetaValueItem SUPRA_COMPUTER_MAX;
    public static MetaItem<?>.MetaValueItem SUPRA_MAINFRAME_ALL;

    public static MetaItem<?>.MetaValueItem STENCILING_CUTHEAD;
    public static MetaItem<?>.MetaValueItem COPPER_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem ELECTRUM_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem GERMANIUM_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem FIBERGLASS_MESH;
    public static MetaItem<?>.MetaValueItem ZBLANMATRIX;
    public static MetaItem<?>.MetaValueItem OPTICAL_BASE;
    public static MetaItem<?>.MetaValueItem LAMINATED_OPTICAL_BASE;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem DIRTY_COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem CLEANED_COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_SUBSTRATE_PREP;
    public static MetaItem<?>.MetaValueItem ETCHED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SUPERHEATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem VIABLE_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem NONVIABLE_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem RECYCLED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SINTERED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem WIRED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_SAPPHIRE_CHIP;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_CHIP;
    public static MetaItem<?>.MetaValueItem PROCESSED_CRYSTAL_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SFET_BUNDLE;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SFET_WAFER;
    public static MetaItem<?>.MetaValueItem REFRACTING_SHEET;
    public static MetaItem<?>.MetaValueItem REFLECTING_SHEET;
    public static MetaItem<?>.MetaValueItem LAMINATED_CRYSTAL_PCB_SHEET;
    public static MetaItem<?>.MetaValueItem GAMMA_EMITTING_DIODE;
    public static MetaItem<?>.MetaValueItem SIMPLE_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem SIMPLE_CPU_WAFER;
    public static MetaItem<?>.MetaValueItem SIMPLE_CPU;
    public static MetaItem<?>.MetaValueItem FERROUS_INDUCTOR_CORE;
    public static MetaItem<?>.MetaValueItem TUNGSTEN_INDUCTOR_CORE;
    public static MetaItem<?>.MetaValueItem LANGMUIR_HOUSING;
    public static MetaItem<?>.MetaValueItem TRANSMON_SUPPORT;
    public static MetaItem<?>.MetaValueItem SQUID_BASE;
    public static MetaItem<?>.MetaValueItem LANGMUIR_OSCILATOR;
    public static MetaItem<?>.MetaValueItem GRAPHENE_ALUMINOSILICATE_AEROGEL;
    public static MetaItem<?>.MetaValueItem CNT_SHORT;
    public static MetaItem<?>.MetaValueItem CNT_LONG;
    public static MetaItem<?>.MetaValueItem STERILE_POLYMER_FOIL;
    public static MetaItem<?>.MetaValueItem LAYERED_POLYMER_FOIL;


    // Chips - Post Wetware

    public static MetaItem<?>.MetaValueItem WETWARE_CPU;
    public static MetaItem<?>.MetaValueItem BIOWARE_CPU;
    //already technically exists, do we want to use that item and change lang?
    public static MetaItem<?>.MetaValueItem QUANTUM_CPU;
    public static MetaItem<?>.MetaValueItem EXOTIC_CPU;
    public static MetaItem<?>.MetaValueItem COSMIC_CPU;
    public static MetaItem<?>.MetaValueItem SUPRA_CPU;
    public static MetaItem<?>.MetaValueItem SPUN_POLYACRYLONITRILE;
    public static MetaItem<?>.MetaValueItem WASHED_POLYACRLONITRILE;
    public static MetaItem<?>.MetaValueItem BAKED_POLYACRLONITRILE;
    public static MetaItem<?>.MetaValueItem OXIDIZED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem ETCHED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem COATED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem WOVEN_CARBON_FIBER;
    public static MetaItem<?>.MetaValueItem THIN_WOVEN_CARBON_FIBER;
    public static MetaItem<?>.MetaValueItem CARBON_FIBER_PLATE;
    public static MetaItem<?>.MetaValueItem CARBON_FIBER_FOIL;

    public static MetaItem<?>.MetaValueItem EVACUATED_SYNTHETIC_DIAMOND;
    public static MetaItem<?>.MetaValueItem ANNEALED_NVC_PREPARATION;
    public static MetaItem<?>.MetaValueItem STRESSED_NVC_SHEET;
    public static MetaItem<?>.MetaValueItem NVC_CHIP;
    public static MetaItem<?>.MetaValueItem RABI_SENSOR;
    public static MetaItem<?>.MetaValueItem NVC_SENSOR;
    public static MetaItem<?>.MetaValueItem NVC_STORAGE_MODULE;
    public static MetaItem<?>.MetaValueItem MICROTUBE_INVERSE_FORM;
    public static MetaItem<?>.MetaValueItem COPPER_MICROTUBE_MATRIX;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_RADIATOR;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_PORT;
    public static MetaItem<?>.MetaValueItem LAYERED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem DATA_TRANSFER_MASK;
    public static MetaItem<?>.MetaValueItem MASKED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem ETCHED_MASKED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem ETCHED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem UNITARY_MAPPING_SHEET;
    public static MetaItem<?>.MetaValueItem UNITARY_MEASUREMENT_MODULE;
    public static MetaItem<?>.MetaValueItem ANYON_BIT_REGISTER;
    public static MetaItem<?>.MetaValueItem WAVEFORM_LOGISTICS_BRIDGE;
    public static MetaItem<?>.MetaValueItem SMALL_GAAS_WAFER;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_WAFER;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_CHIP;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_COMPLEX;
    public static MetaItem<?>.MetaValueItem NON_ABELIAN_ANYON_STRANDPLATE;
    public static MetaItem<?>.MetaValueItem MAGNETIC_STRANDPLATE_FORM;
    public static MetaItem<?>.MetaValueItem PRECISION_MAG_STIMULATION_SHEET;
    public static MetaItem<?>.MetaValueItem ANYON_BRAIDING_STRUCTURE;



    // Material Items

    public static MetaItem<?>.MetaValueItem ALUMINA_MOLD;
    public static MetaItem<?>.MetaValueItem FULL_ALUMINA_MOLD;
    public static MetaItem<?>.MetaValueItem HOT_ALUMINA_MOLD;
}
