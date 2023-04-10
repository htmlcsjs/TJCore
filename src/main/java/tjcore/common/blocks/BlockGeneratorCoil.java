package tjcore.common.blocks;

import gregtech.api.block.IStateHarvestLevel;
import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockGeneratorCoil extends VariantBlock<BlockGeneratorCoil.CoilType> {

    public BlockGeneratorCoil() {
        super(Material.IRON);
        setTranslationKey("generator_coil");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(CoilType.COPPER));
    }
    public enum CoilType implements IStringSerializable, IStateHarvestLevel {

        TIN("tin", 0, 2),
        COPPER("copper", 1,2),
        ELECTRUM("electrum", 2, 2),
        ALUMINIUM("aluminium", 3, 2),
        PLATINUM("platinum", 4, 2);


        private final String name;
        private final int harvestLevel;
        private final int tier;

        CoilType(String name, int tier, int harvestLevel) {
            this.tier = tier;
            this.name = name;
            this.harvestLevel = harvestLevel;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }


        public int getTier() {
            return tier;
        }

        @Override
        public int getHarvestLevel(IBlockState state) {
            return harvestLevel;
        }

        @Override
        public String getHarvestTool(IBlockState state) {
            return "wrench";
        }
    }
}
