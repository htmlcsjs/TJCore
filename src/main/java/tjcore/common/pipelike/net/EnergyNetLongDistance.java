package tjcore.common.pipelike.net;

import gregtech.api.pipenet.Node;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import gregtech.api.unification.material.properties.WireProperties;
import gregtech.common.pipelike.cable.net.RoutePath;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;

public class EnergyNetLongDistance extends PipeNet<WireProperties> {

    private long lastEnergyFluxPerSec;
    private long energyFluxPerSec;
    private long lastTime;
    private final Map<BlockPos, List<RoutePath>> NET_DATA = new HashMap<>();

    protected EnergyNetLongDistance(WorldPipeNet<WireProperties, EnergyNetLongDistance> world) {
        super(world);
    }

    public List<RoutePath> getNetData(BlockPos pipePos) {
        List<RoutePath> data = this.NET_DATA.get(pipePos);
        if (data == null) {
            data = EnergyNetWalkerLongDistance.createNetData(this.getWorldData(), pipePos);
            if (data == null) {
                return Collections.emptyList();
            }

            data.sort(Comparator.comparingInt(RoutePath::getDistance));
            this.NET_DATA.put(pipePos, data);
        }

        return data;
    }

    public long getEnergyFluxPerSec() {
        World world = this.getWorldData();
        if (world != null && !world.isRemote && world.getTotalWorldTime() - this.lastTime >= 20L) {
            this.lastTime = world.getTotalWorldTime();
            this.clearCache();
        }

        return this.lastEnergyFluxPerSec;
    }

    public void addEnergyFluxPerSec(long energy) {
        this.energyFluxPerSec += energy;
    }

    public void clearCache() {
        this.lastEnergyFluxPerSec = this.energyFluxPerSec;
        this.energyFluxPerSec = 0L;
    }

    public void onNeighbourUpdate(BlockPos fromPos) {
        this.NET_DATA.clear();
    }

    public void onPipeConnectionsUpdate() {
        this.NET_DATA.clear();
    }

    protected void transferNodeData(Map<BlockPos, Node<WireProperties>> transferredNodes, PipeNet<WireProperties> parentNet) {
        super.transferNodeData(transferredNodes, parentNet);
        this.NET_DATA.clear();
        ((EnergyNetLongDistance)parentNet).NET_DATA.clear();
    }

    protected void writeNodeData(WireProperties nodeData, NBTTagCompound tagCompound) {
        tagCompound.setInteger("voltage", nodeData.getVoltage());
        tagCompound.setInteger("amperage", nodeData.getAmperage());
        tagCompound.setInteger("loss", nodeData.getLossPerBlock());
    }

    protected WireProperties readNodeData(NBTTagCompound tagCompound) {
        int voltage = tagCompound.getInteger("voltage");
        int amperage = tagCompound.getInteger("amperage");
        int lossPerBlock = tagCompound.getInteger("loss");
        return new WireProperties(voltage, amperage, lossPerBlock);
    }

}
