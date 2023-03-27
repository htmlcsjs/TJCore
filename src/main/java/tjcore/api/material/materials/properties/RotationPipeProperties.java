package tjcore.api.material.materials.properties;

import gregtech.api.unification.material.properties.IMaterialProperty;
import gregtech.api.unification.material.properties.MaterialProperties;
import gregtech.api.unification.material.properties.PropertyKey;

public class RotationPipeProperties implements IMaterialProperty<RotationPipeProperties> {

    private float torque;

    public RotationPipeProperties(float maxTorque) {
        this.torque = maxTorque;
    }

    @Override
    public void verifyProperty(MaterialProperties materialProperties) {
        materialProperties.ensureSet(PropertyKey.INGOT, true);
    }

    public float getMaxTorque() {return this.torque;}
}
