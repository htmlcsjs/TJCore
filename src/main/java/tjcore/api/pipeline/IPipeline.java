package tjcore.api.pipeline;

public interface IPipeline {

    PipelineManager.PIPELINE getType();
    void setConnection(IPipeline pipeline);
    void setIsSource(boolean source);
    boolean getIsSource();
    void disconnect(boolean recyclePipes);
}
