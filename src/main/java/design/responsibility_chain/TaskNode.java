package design.responsibility_chain;

public interface TaskNode {
    boolean doTask(RecomReq req, RecomRsp rsp, RecomConfig config, TaskNodeChain chain);
}
