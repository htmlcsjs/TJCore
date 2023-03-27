package tjcore.api.axle;

public interface ISpinnable {
    void pushRotation(float rps, float torque);
    float pullTorque();
    void addProvider(IRotationProvider provider);
    float getRPS();
}
