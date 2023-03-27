package tjcore.common.pipelike.rotation;

import gregtech.api.metatileentity.IDataInfoProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.block.BlockRotatedPillar.AXIS;

public class TileEntityRotationAxle extends TileEntity implements IDataInfoProvider {

    private boolean foundNet = false;
    public float anglePerTick = 0f;
    public float startAngle = 0f;
    public AxleWhole axleWhole;
    TileEntityRotationAxle() {
        super();
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    public void update(float newSpeed, float newAngle) {
        startAngle = newAngle;
        anglePerTick = newSpeed;
        if (world != null) {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 2);
        }
        markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        anglePerTick = compound.getFloat("deltaanglepertick");
        startAngle = compound.getFloat("angleStart");
        markDirty();
    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setFloat("deltaanglepertick", anglePerTick);
        compound.setFloat("angleStart", startAngle);
        return compound;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if(!world.isRemote) connectToNet();
        markDirty();
    }

    public void connectToNet() {
        axleWhole = null;
        BlockPos pos = this.getPos();
        World world = this.getWorld();
        Axis a = world.getBlockState(pos).getValue(AXIS);
        foundNet = findNetToAttach(a);
        if (!foundNet) {
            axleWhole = new AxleWhole(a);
            axleWhole.addAxle(this);
            foundNet = true;
        }
    }

    private boolean findNetToAttach(Axis axis) {
        AxleWhole toJoinA = getAdjacent(world, pos, axis == Axis.X ?  1 : 0, axis == Axis.Y ?  1 : 0, axis == Axis.Z ?  1 : 0);
        AxleWhole toJoinB = getAdjacent(world, pos, axis == Axis.X ? -1 : 0, axis == Axis.Y ? -1 : 0, axis == Axis.Z ? -1 : 0);
        if (toJoinA != null && toJoinB != null) {
            if (toJoinA.getSize() < toJoinB.getSize()) {
                toJoinB.addAxle(this);
                toJoinB.incorperate(toJoinA);
                return true;
            } else {
                toJoinA.addAxle(this);
                toJoinA.incorperate(toJoinB);
                return true;
            }
        } else if (toJoinA != null) {
            toJoinA.addAxle(this);
            return true;
        } else if (toJoinB != null) {
            toJoinB.addAxle(this);
            return true;
        }
        return false;
    }

    private @Nullable AxleWhole getAdjacent(World worldIn, BlockPos thisPos, int xChange, int yChange, int zChange) {
        BlockPos nextPos = new BlockPos(thisPos.getX() + xChange, thisPos.getY() + yChange, thisPos.getZ() + zChange);
        IBlockState nextState = worldIn.getBlockState(nextPos);

        IBlockState currentState = worldIn.getBlockState(thisPos);

        if (nextState.getBlock() instanceof BlockRotationAxle) {
            if(nextState.getValue(AXIS) == currentState.getValue(AXIS)) {
                TileEntityRotationAxle axle = ((TileEntityRotationAxle) worldIn.getTileEntity(nextPos));
                return axle.getAxleWhole();
            }
        }
        return null;
    }

    //@NotNull
    //@Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> list = new ArrayList<>();
        //list.add(new TextComponentTranslation("behavior.tricorder.torque",
        //new TextComponentTranslation(GTUtility.formatNumbers(this.getTorque())).setStyle(new Style().setColor(TextFormatting.DARK_PURPLE))
        //));
        return list;
    }

    @Override
    public boolean hasFastRenderer() {
        return true;
    }

    public AxleWhole getAxleWhole() {
        return axleWhole;
    }
}
