package TJCore.common;

import TJCore.TJValues;
import TJCore.api.TJComponents;
import TJCore.api.TJOreDictionaryLoader;
import TJCore.common.recipes.*;
import TJCore.common.recipes.polymers.TJPolymers;
import gregtech.api.block.VariantItemBlock;
import gregtech.loaders.recipe.chemistry.PolymerRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Function;

import static TJCore.common.blocks.TJMetaBlocks.*;
import static gregtech.common.blocks.MetaBlocks.BOILER_CASING;

@Mod.EventBusSubscriber(modid = TJValues.MODID)
public class CommonProxy {

    public void preInit() {
        TJOreDictionaryLoader.init();
    }

    @SubscribeEvent
    public static void RegisterBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(DRACONIC_CASING);
        registry.register(TURBINE_BLADES);
        registry.register(BLOCK_BEARING);
    }
    
    @SubscribeEvent
    public static void RegisterItemBlocks(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(TURBINE_BLADES, VariantItemBlock::new));
        registry.register(createItemBlock(BLOCK_BEARING, VariantItemBlock::new));
        registry.register(createItemBlock(DRACONIC_CASING, VariantItemBlock::new));
    }
    
    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        //noinspection ConstantConditions
        itemBlock.setRegistryName(block.getRegistryName());
        return itemBlock;
    }
    
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void init(RegistryEvent.Register<IRecipe> event) {
        TJOreDictionaryLoader.registerRecipes();
        TJComponents.init();
        MaterialProcessing.registerMaterialProcessing();
        CircuitRecipes.registerCircuits();
        TJPolymers.registerPolymers();
        GTComponents.init();

        if (Loader.isModLoaded("draconicevolution")) {
            ArmorInfuserRecipes.register();
        }
        SurfaceRockDrillRecipes.register();
        MultiblockHatches.registerIOHatches();
        Ores.RegisterOres();
        MaterialRecipes.register();
        MachineRecipes.registerMachines();
    }
}
