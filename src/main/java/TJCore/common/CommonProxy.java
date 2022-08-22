package TJCore.common;

import TJCore.TJValues;
import TJCore.common.recipes.*;
import TJCore.common.recipes.recipemaps.TJRecipeMaps;
import gregtech.api.block.VariantItemBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static TJCore.common.blocks.TJMetaBlocks.*;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class CommonProxy {

    public void preInit() {

    }
    
    @SubscribeEvent
    public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(DRACONIC_CASING);
    }
    
    @SubscribeEvent
    public static void RegisterItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(DRACONIC_CASING, VariantItemBlock::new));
    }
    
    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }
    
    @SubscribeEvent()
    public static void init(RegistryEvent.Register<IRecipe> event) {

        TJRecipeMaps.initRecipeMaps();
        CircuitRecipes.registerCircuits();
        GTComponents.registerComponents();
        GTComponents.registerHullsCasings();
        ArmorInfuserRecipes.register();
        SurfaceRockDrillRecipes.register();
        MultiblockHatches.registerIOHatches();
        Ores.RegisterOres();
        MaterialRecipes.register();
    
       
    }
}
