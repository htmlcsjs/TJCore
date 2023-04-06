package tjcore.api.axle;

import tjcore.common.pipelike.rotation.AxleWhole;

import javax.annotation.Nullable;

public interface IRotationConsumer {
    void consume();
    void joinNet();

    void setAxleWhole(@Nullable AxleWhole axle);
}
