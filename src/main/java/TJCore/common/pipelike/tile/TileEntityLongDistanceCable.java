package TJCore.common.pipelike.tile;

import TJCore.common.pipelike.net.EnergyNetLongDistance;
import TJCore.common.pipelike.net.LongDistanceNetHandler;
import TJCore.common.pipelike.net.WorldLongDistanceNet;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.common.pipelike.cable.tile.TileEntityCable;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import scala.Long;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.EnumMap;

public class TileEntityLongDistanceCable extends TileEntityCable {

    private final IEnergyContainer clientCapability = IEnergyContainer.DEFAULT;
    private LongDistanceNetHandler defaultHandler;
    private final EnumMap<EnumFacing, LongDistanceNetHandler> handlers = new EnumMap<>(EnumFacing.class);
    private WeakReference<EnergyNetLongDistance> currentEnergyNet = new WeakReference<>(null);

    private void initHandlers() {
        EnergyNetLongDistance net = getEnergyNet();
        if (net == null) {
            return;
        }
        for (EnumFacing facing : EnumFacing.VALUES) {
            handlers.put(facing, new LongDistanceNetHandler(net, this, facing));
        }
        defaultHandler = new LongDistanceNetHandler(net, this, null);
    }

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER) {
            if (world.isRemote)
                return GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER.cast(clientCapability);
            if (handlers.size() == 0)
                initHandlers();
            checkNetwork();
            return GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER.cast(handlers.getOrDefault(facing, defaultHandler));
        }
        return super.getCapabilityInternal(capability, facing);
    }


    public void checkNetwork() {
        if (defaultHandler != null) {
            EnergyNetLongDistance current = getEnergyNet();
            if (defaultHandler.getNet() != current) {
                defaultHandler.updateNetwork(current);
                for (LongDistanceNetHandler handler : handlers.values()) {
                    handler.updateNetwork(current);
                }
            }
        }
    }

    private EnergyNetLongDistance getEnergyNet() {
        if (world == null || world.isRemote)
            return null;
        EnergyNetLongDistance currentEnergyNet = this.currentEnergyNet.get();
        if (currentEnergyNet != null && currentEnergyNet.isValid() &&
                currentEnergyNet.containsNode(getPos()))
            return currentEnergyNet; //return current net if it is still valid
        WorldLongDistanceNet worldENet = WorldLongDistanceNet.getWorldLongDistanceNet(getWorld());
        currentEnergyNet = worldENet.getNetFromPos(getPos());
        if (currentEnergyNet != null) {
            this.currentEnergyNet = new WeakReference<>(currentEnergyNet);
        }
        return currentEnergyNet;
    }
}
