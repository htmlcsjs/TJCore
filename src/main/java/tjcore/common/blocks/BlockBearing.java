package tjcore.common.blocks;

import gregtech.api.block.IStateHarvestLevel;
import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockBearing extends VariantBlock<BlockBearing.BearingType> {

    public BlockBearing() {
        super(Material.IRON);
        setTranslationKey("turbine_bearing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(BearingType.GALVANIZED_STEEL_BEARING));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull SpawnPlacementType type) {
        return false;
    }

    public enum BearingType implements IStringSerializable, IStateHarvestLevel {

        GALVANIZED_STEEL_BEARING("galvanized_bearing", 0,2),
        ALUMINUM_BEARING("aluminium_bearing", 1,3),
        STAINLESS_STEEL_BEARING("stainless_bearing", 2,3),
        TITANIUM_BEARING("titanium_bearing", 3,4),
        TUNGSTENSTEEL_BEARING("tungstensteel_bearing", 4,4);

        private final String name;
        private final int harvestLevel;
        private final int tier;

        BearingType(String name, int tier, int harvestLevel) {
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
