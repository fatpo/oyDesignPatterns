package design.responsibility_chain;

import java.util.ArrayList;
import java.util.List;

public class TaskNodeChain {
    List<TaskNode> tasks = new ArrayList<>();
    int pos = 0;

    /**
     * 把工作节点导入责任链中
     *
     * @param node 工作节点
     * @return 当前责任链（可链式编程）
     */
    public TaskNodeChain addNode(TaskNode node) {
        tasks.add(node);
        return this;
    }

    public void doTask(RecomReq req, RecomRsp rsp, RecomConfig config) {
        if (pos == tasks.size()) {
            return;
        }
        TaskNode node = tasks.get(pos);
        pos++;

        node.doTask(req, rsp, config, this);
    }
}
