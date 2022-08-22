package TJCore.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class DraconicCasings extends VariantBlock<DraconicCasings.CasingType> {
    
    public DraconicCasings() {
        super(Material.IRON);
        this.setTranslationKey("draconic_casing");
        setHardness(3.0f);
        setSoundType(SoundType.METAL);
        setResistance(9.0f);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(DraconicCasings.CasingType.DRACONIUM_CASING));
        
    }
    
    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }
    
    public enum CasingType implements IStringSerializable {
        
        DRACONIUM_CASING("draconic_casing_normal");
        CasingType(String name) {
            this.name = name;
        }
        
        private final String name;
        
        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }
    }
}
