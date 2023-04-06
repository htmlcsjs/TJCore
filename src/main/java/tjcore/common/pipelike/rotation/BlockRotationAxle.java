package tjcore.common.pipelike.rotation;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.PropertyFloat;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockRotationAxle extends BlockRotatedPillar implements ITileEntityProvider {
    private static final AxisAlignedBB AABB_X = new AxisAlignedBB(0.0D, 0.375D, 0.375D, 1.0D, 0.625D, 0.625D);
    private static final AxisAlignedBB AABB_Y = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);
    private static final AxisAlignedBB AABB_Z = new AxisAlignedBB(0.375D, 0.375D, 0.0D, 0.625D, 0.625D, 1.0D);

    public static final PropertyFloat ROTATION = new PropertyFloat("rotation");
    public BlockRotationAxle()
    {
        super(Material.GRASS, MapColor.YELLOW);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Z));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setTranslationKey("rotation_axle");
    }

    @Override
    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
        return super.canCollideCheck(state, hitIfLiquid);
    }

    protected BlockStateContainer createBlockState() {
        return new ExtendedBlockState(this, new IProperty[]{AXIS}, new IUnlistedProperty[]{ROTATION});
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public @Nonnull AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch(state.getValue(AXIS)) {
            case X:
                return AABB_X;
            case Y:
            default:
                return AABB_Y;
            case Z:
                return AABB_Z;
        }
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (worldIn.getTileEntity(pos) instanceof TileEntityRotationAxle) {
            AxleWhole axleFull =  ((TileEntityRotationAxle) worldIn.getTileEntity(pos)).getAxleWhole();
            super.breakBlock(worldIn, pos, state);
            if(axleFull != null)
                axleFull.deleteNetAndCreateNew(pos);
            //((TileEntityRotationAxle) worldIn.getTileEntity(pos)).deleteAndUpdateNet();
        }
    }

    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollision(worldIn, pos, state, entityIn);

        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof TileEntityRotationAxle) {
            float angle = ((TileEntityRotationAxle)te).anglePerTick;
            entityIn.addVelocity(0, 1.0D, 0);
        }
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        state.withProperty(AXIS, state.getValue(AXIS));
        return true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntityRotationAxle createNewTileEntity(World worldIn, int meta) {
        TileEntityRotationAxle axle =  new TileEntityRotationAxle();
        //axle.updateAxleWhole();
        return axle;
    }
}
