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
import tjcore.api.block.ITurbineBladeStats;

import javax.annotation.Nonnull;

public class BlockTurbineBlades extends VariantBlock<BlockTurbineBlades.TurbineBladesType> {

    public BlockTurbineBlades() {
        super(Material.IRON);
        setTranslationKey("turbine_blades");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(TurbineBladesType.GALVANIZED_STEEL_BLADES));
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull SpawnPlacementType type) {
        return false;
    }

    public enum TurbineBladesType implements IStringSerializable, IStateHarvestLevel, ITurbineBladeStats {

        GALVANIZED_STEEL_BLADES("galvanized_blades", 50,0, 2),
        ALUMINUM_BLADES("aluminium_blades", 100,1,3),
        STAINLESS_STEEL_BLADES("stainless_blades", 150,2,3),
        TITANIUM_BLADES("titanium_blades", 250,3, 4),
        TUNGSTENSTEEL_BLADES("tungstensteel_blades", 400,4, 4);

        private final String name;
        private final int tier;
        private final int rotationCap;
        private final int harvestLevel;

        TurbineBladesType(String name, int rotationCap, int tier, int harvestLevel) {
            this.rotationCap = rotationCap;
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
