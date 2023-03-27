package tjcore.api.axle;

import tjcore.common.pipelike.rotation.AxleWhole;

public interface IRotationProvider {
    void pushRotation(float rotationSpeed, float torque);
    void joinNet();
    float getRotation();
    void setAxleWhole(AxleWhole axle);
}
