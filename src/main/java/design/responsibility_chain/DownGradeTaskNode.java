package design.responsibility_chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DownGradeTaskNode implements TaskNode {

    public boolean doTask(RecomReq req, RecomRsp rsp, RecomConfig config, TaskNodeChain chain) {
        log.info("进入降级服务的 taskNode...");

        // 判断是否需要降级
        if (isNeedDownGrade()) {
            // false 表示中断后续的责任链，这里返回即可
            return false;
        }

        // 把球传给责任链中的下个节点
        chain.doTask(req, rsp, config);

        log.info("离开降级服务的 taskNode...");
        return true;
    }

    private boolean isNeedDownGrade() {
        return false;
    }
}
