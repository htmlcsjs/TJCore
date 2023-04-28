package tjcore.common.pipelike.net;

import gregtech.api.pipenet.WorldPipeNet;
import gregtech.api.unification.material.properties.WireProperties;
import net.minecraft.world.World;

public class WorldLongDistanceNet extends WorldPipeNet<WireProperties, EnergyNetLongDistance> {
    private static final String DATA_ID_BASE = "tjcore.long_distance_net";

    public static WorldLongDistanceNet getWorldLongDistanceNet(World world) {
        final String DATA_ID = getDataID(DATA_ID_BASE, world);
        WorldLongDistanceNet eNetWorldData = (WorldLongDistanceNet) world.loadData(WorldLongDistanceNet.class, DATA_ID);
        if (eNetWorldData == null) {
            eNetWorldData = new WorldLongDistanceNet(DATA_ID);
            world.setData(DATA_ID, eNetWorldData);
        }
        eNetWorldData.setWorldAndInit(world);
        return eNetWorldData;
    }

    public WorldLongDistanceNet(String name) {
        super(name);
    }

    protected EnergyNetLongDistance createNetInstance() {
        return new EnergyNetLongDistance(this);
    }


}
