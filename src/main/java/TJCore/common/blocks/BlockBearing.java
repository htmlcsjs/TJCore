package TJCore.common.blocks;

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
        setTranslationKey("turbine_blades");
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

        GALVANIZED_STEEL_BEARING("galvanized_bearing", 50,2),
        ALUMINUM_BEARING("aluminum_bearing", 100,3),
        STAINLESS_STEEL_BEARING("stainless_bearing", 150,3),
        TITANIUM_BEARING("titanium_bearing", 250,4),
        TUNGSTENSTEEL_BEARING("tungstensteel_bearing", 400,4);

        private final String name;
        private final int harvestLevel;
        private final int rotationCap;

        BearingType(String name, int rotationCap, int harvestLevel) {
            this.rotationCap = rotationCap;
            this.name = name;
            this.harvestLevel = harvestLevel;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }


        public int getRotationCap() {
            return rotationCap;
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
