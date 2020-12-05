package design.responsibility_chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FallbackTaskNode implements TaskNode {
    public boolean doTask(RecomReq req, RecomRsp rsp, RecomConfig config, TaskNodeChain chain) {
        // do 热度兜底的业务逻辑 fallback
        // 返回 false 表示不能有后续结点了
        log.info("进入热度兜底服务的 taskNode...");
        log.info("离开热度兜底服务的 taskNode...");
        return false;
    }

}
