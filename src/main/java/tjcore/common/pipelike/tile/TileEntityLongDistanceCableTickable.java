package tjcore.common.pipelike.tile;

import net.minecraft.util.ITickable;

public class TileEntityLongDistanceCableTickable extends TileEntityLongDistanceCable implements ITickable {
    public TileEntityLongDistanceCableTickable() {

    }

    @Override
    public void update() { getCoverableImplementation().update();}

    @Override
    public boolean supportsTicking() {return true;}
}
