package tjcore.api.pipeline;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.World;
import tjcore.common.metatileentities.multi.pipeline.MetaTileEntityFluidPipeline;

import java.util.HashMap;
import java.util.Map;

public class PipelineManager {

    public Map<Integer, IPipeline> fluidPartialMap = new HashMap<>();
    public Map<Integer, IPipeline> itemPartialMap = new HashMap<>();
    public Map<Integer, IPipeline> energyPartialMap = new HashMap<>();

    public Map<Integer, IPipeline[]> fluidConnectionMap = new HashMap<>();
    public Map<Integer, IPipeline[]> itemConnectionMap = new HashMap<>();
    public Map<Integer, IPipeline[]> energyConnectionMap = new HashMap<>();

    public void clean(World worldIn) {
        if(!worldIn.isRemote) {
            fluidPartialMap.clear();
            itemPartialMap.clear();
            energyPartialMap.clear();
            fluidConnectionMap.clear();
            itemConnectionMap.clear();
            energyConnectionMap.clear();
        }
    }

    public void tryConnect(int frequency, IPipeline pipeline) {
        PIPELINE type = pipeline.getType();
        Map<Integer, IPipeline> partialMap = getPartialMap(type);
        Map<Integer, IPipeline[]> connectionMap = getConnectionMap(type);
        assert partialMap != null;
        if (partialMap.get(frequency) == null && connectionMap.get(frequency) == null) {
            partialMap.put(frequency, pipeline);
        } else if (connectionMap.get(frequency) == null){
            IPipeline partner = partialMap.get(frequency);
            partialMap.remove(frequency);
            connectionMap.put(frequency, new IPipeline[]{pipeline, partner});
            pipeline.setConnection(partner);
            partner.setConnection(pipeline);
        }
        else {

        }
    }



    public void disconnect(int freq, IPipeline toRemove) {
        PIPELINE type = toRemove.getType();
        Map<Integer, IPipeline> partialMap = getPartialMap(type);
        Map<Integer, IPipeline[]> connectionMap = getConnectionMap(type);
        if (partialMap.get(freq) == toRemove) {
            partialMap.remove(freq);
        } else if (connectionMap.get(freq) != null){
            IPipeline[] pair = connectionMap.get(freq);
            IPipeline toInsert = pair[0] == toRemove ? pair[1] : pair[0];
            partialMap.put(freq, toInsert);
            pair[0].disconnect(toRemove == pair[0]);
            pair[1].disconnect(toRemove != pair[0]);
            connectionMap.remove(freq);

        }
    }

    private Map<Integer, IPipeline> getPartialMap(PIPELINE type) {
        switch(type) {
            case FLUID:
                return fluidPartialMap;
            case ITEM:
                return itemPartialMap;
            case ENERGY:
                return energyPartialMap;
            default:
                return null;
        }
    }

    private Map<Integer, IPipeline[]> getConnectionMap(PIPELINE type) {
        switch(type) {
            case FLUID:
                return fluidConnectionMap;
            case ITEM:
                return itemConnectionMap;
            case ENERGY:
                return energyConnectionMap;
            default:
                return null;
        }
    }

    public enum PIPELINE {
        FLUID,
        ITEM,
        ENERGY
    }
}
