package tjcore.common.pipelike.net;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.pipenet.PipeNetWalker;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.common.metatileentities.electric.MetaTileEntityTransformer;
import gregtech.common.pipelike.cable.net.RoutePath;
import gregtech.common.pipelike.cable.tile.TileEntityCable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;


public class EnergyNetWalkerLongDistance extends PipeNetWalker {

    public static List<RoutePath> createNetData(World world, BlockPos sourcePipe) {
        EnergyNetWalkerLongDistance walker = new EnergyNetWalkerLongDistance(world, sourcePipe, 1, new ArrayList<>());
        walker.traversePipeNet();
        return walker.isFailed() ? null : walker.routes;
    }

    private final List<RoutePath> routes;
    private TileEntityCable[] pipes = {};
    private int loss;

    protected EnergyNetWalkerLongDistance(World world, BlockPos sourcePipe, int walkedBlocks, List<RoutePath> routes) {
        super(world, sourcePipe, walkedBlocks);
        this.routes = routes;
    }

    @Override
    protected PipeNetWalker createSubWalker(World world, EnumFacing facingToNextPos, BlockPos nextPos, int walkedBlocks) {
        EnergyNetWalkerLongDistance walker = new EnergyNetWalkerLongDistance(world, nextPos, walkedBlocks, routes);
        walker.loss = loss;
        walker.pipes = pipes;
        return walker;
    }

    @Override
    protected void checkPipe(IPipeTile<?, ?> pipeTile, BlockPos pos) {
        pipes = ArrayUtils.add(pipes, (TileEntityCable) pipeTile);
        loss += ((TileEntityCable) pipeTile).getNodeData().getLossPerBlock();
    }

    @Override
    protected void checkNeighbour(IPipeTile<?, ?> pipeTile, BlockPos pipePos, EnumFacing faceToNeighbour, @Nullable TileEntity neighbourTile) {
        if (neighbourTile != null) {
            if (neighbourTile instanceof IGregTechTileEntity) {
                MetaTileEntity metaTileEntity = ((IGregTechTileEntity) neighbourTile).getMetaTileEntity();
                if (metaTileEntity instanceof MetaTileEntityTransformer) {
                    routes.add(new RoutePath(new BlockPos(pipePos), faceToNeighbour, pipes, getWalkedBlocks(), loss));
                }
            }
        }
    }

    @Override
    protected boolean isValidPipe(IPipeTile<?, ?> currentPipe, IPipeTile<?, ?> neighbourPipe, BlockPos pipePos, EnumFacing faceToNeighbour) {
        return neighbourPipe instanceof TileEntityCable;
    }
}
