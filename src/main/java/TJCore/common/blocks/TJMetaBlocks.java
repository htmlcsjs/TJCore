package TJCore.common.blocks;

import TJCore.common.pipelike.BlockCableLongDistance;
import TJCore.common.pipelike.tile.TileEntityLongDistanceCable;
import TJCore.common.pipelike.tile.TileEntityLongDistanceCableTickable;
import com.sun.jna.platform.win32.WinDef;
import gregtech.api.block.machines.BlockMachine;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.client.model.SimpleStateMapper;
import gregtech.client.renderer.handler.MetaTileEntityRenderer;
import gregtech.client.renderer.pipe.CableRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import TJCore.common.blocks.BlockTurbineBlades;
import TJCore.common.blocks.BlockBearing;
import gregtech.common.pipelike.cable.BlockCable;
import gregtech.common.pipelike.cable.Insulation;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gregtech.common.blocks.MetaBlocks;

import static TJCore.TJValues.MODID;
import static gregtech.common.blocks.MetaBlocks.MACHINE;

public class TJMetaBlocks {

    public static DraconicCasings DRACONIC_CASING;
    public static BlockBearing BLOCK_BEARING;
    public static BlockTurbineBlades TURBINE_BLADES;

    public static final BlockCableLongDistance[] LONG_DIST_CABLES = new BlockCableLongDistance[10];
    
    public static void init() {
        DRACONIC_CASING = new DraconicCasings();
        DRACONIC_CASING.setRegistryName("draconic_casing");
        TURBINE_BLADES = new BlockTurbineBlades();
        TURBINE_BLADES.setRegistryName("turbine_blades");
        BLOCK_BEARING = new BlockBearing();
        BLOCK_BEARING.setRegistryName("block_bearing");
        for (Insulation ins : Insulation.values()) {
            LONG_DIST_CABLES[ins.ordinal()] = new BlockCableLongDistance(ins);
            LONG_DIST_CABLES[ins.ordinal()].setRegistryName(ins.getName());
        }
    }

    public static void registerTileEntity() {
        GameRegistry.registerTileEntity(TileEntityLongDistanceCable.class, new ResourceLocation(MODID, "cable_long_distance"));
        GameRegistry.registerTileEntity(TileEntityLongDistanceCableTickable.class, new ResourceLocation(MODID, "cable_long_distance_tickable"));
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(MACHINE), stack -> MetaTileEntityRenderer.MODEL_LOCATION);
        for (BlockCableLongDistance cable : LONG_DIST_CABLES)
            ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(cable), stack -> CableRenderer.INSTANCE.getModelLocation());
        registerItemModel(DRACONIC_CASING);
        registerItemModel(TURBINE_BLADES);
        registerItemModel(BLOCK_BEARING);
    }

    @SideOnly(Side.CLIENT)
    public static void registerStateMappers() {
        ModelLoader.setCustomStateMapper(MACHINE, new SimpleStateMapper(MetaTileEntityRenderer.MODEL_LOCATION));
        IStateMapper normalStateMapper = new SimpleStateMapper(CableRenderer.INSTANCE.getModelLocation());
        for (BlockCableLongDistance cable : LONG_DIST_CABLES) ModelLoader.setCustomStateMapper(cable, normalStateMapper);
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            MetaBlocks.statePropertiesToString(state.getProperties())));
        }
    }

    public static void registerOreDict() {
        for (BlockCableLongDistance cable : LONG_DIST_CABLES) {
            for (Material pipeMaterial : cable.getEnabledMaterials()) {
                ItemStack itemStack = cable.getItem(pipeMaterial);
                OreDictUnifier.registerOre(itemStack, cable.getPrefix(), pipeMaterial);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String getPropertyName(IProperty<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
