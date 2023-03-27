package tjcore.common.pipelike.rotation;

import tjcore.api.axle.IRotationConsumer;
import tjcore.api.axle.IRotationProvider;
import tjcore.api.axle.ISpinnable;
import tjcore.common.pipelike.rotation.world.WorldAxleFull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.*;

public class AxleWhole implements ISpinnable {
    private List<TileEntityRotationAxle> components = new ArrayList<>();
    private List<IRotationProvider> providers = new ArrayList<>();
    private List<IRotationConsumer> consumers = new ArrayList<>();
    private final float speedDecrement = 0.025f;
    public float revolutionsPerSecond = 0.0f;
    private float torque;
    public float angle;
    EnumFacing.Axis axis;
    public AxleWhole(EnumFacing.Axis axis) {
        this.axis = axis;
        WorldAxleFull.addAxleWhole(this);
    }

    public void addAxle(TileEntityRotationAxle axle){
        axle.axleWhole = this;
        components.add(axle);
        updateAll();
    }

    //TODO: we get there when we get there
    public void updateAll() {
        for (TileEntityRotationAxle axle: components) {
            axle.update(revolutionsPerSecond * (float) Math.PI * 2 / 20, angle);
        }
        angle += revolutionsPerSecond * (float) Math.PI * 2 / 20;
        boolean shouldDecrement = true;
        for (IRotationProvider provider : providers) {
            if ((Math.abs(provider.getRotation()) >= Math.abs(revolutionsPerSecond))) {
                shouldDecrement = false;
            }
        }
        if (shouldDecrement) {
            if (revolutionsPerSecond > speedDecrement) revolutionsPerSecond -= speedDecrement;
            else if (revolutionsPerSecond < 0 - speedDecrement) revolutionsPerSecond += speedDecrement;
            else revolutionsPerSecond = 0;
        }
    }

    public int getSize() {
        return components.size();
    }

    public void incorperate(AxleWhole toAdd) {
        if (toAdd == this) {return;}
        float maxSpeed = Math.max(revolutionsPerSecond, toAdd.revolutionsPerSecond);
        torque = (toAdd.torque * (toAdd.revolutionsPerSecond / maxSpeed)) + (torque * (revolutionsPerSecond / maxSpeed));
        revolutionsPerSecond = maxSpeed;
        for(TileEntityRotationAxle axle : toAdd.getComponents()) {
            addAxle(axle);
        }
        providers.addAll(toAdd.providers);
        toAdd.components.clear();
    }

    public List<TileEntityRotationAxle> getComponents() {
        return components;
    }

    public void destroyAll() {

    }

    @Override
    public void pushRotation(float newSpeed, float newTorque) {
        float maxSpeed = Math.max(revolutionsPerSecond, newSpeed);
        torque = (newTorque * (newSpeed / maxSpeed)) + (torque * (revolutionsPerSecond / maxSpeed));
        revolutionsPerSecond = maxSpeed;
    }

    @Override
    public float pullTorque() {
        float torq = torque;
        torque = 0;
        return torq;
    }


    public void addProvider(IRotationProvider provider) {
        providers.add(provider);
    }

    public float getRPS() {
        return revolutionsPerSecond;
    }

    public void deleteNetAndCreateNew(BlockPos posIn) {
        for (TileEntityRotationAxle te : components) {
            te.axleWhole = null;
        }


        for (TileEntityRotationAxle te : components) {
            if (!te.getPos().equals(posIn))  {
                te.connectToNet();
            }
        }
        components.clear();

        for (IRotationProvider provider : providers) {
            //Problem is this is getting called on the wrong provider. Providers looks to be full at the time of the error though.
            //This also ISNT hit when you break the axle connected after it is incorperated into another net. What the fuck
            provider.setAxleWhole(null);
        }
    }
}
