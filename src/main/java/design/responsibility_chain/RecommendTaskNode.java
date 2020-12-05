package design.responsibility_chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

@Service
@Slf4j
public class RecommendTaskNode implements TaskNode {
    @Override
    public boolean doTask(RecomReq req, RecomRsp rsp, RecomConfig config, TaskNodeChain chain) {
        // 真正推荐业务逻辑
        log.info("进入真正推荐业务逻辑的 taskNode...");
        // do recommend()

        // 把球传给责任链中的下个节点
        chain.doTask(req, rsp, config);

        log.info("离开真正推荐业务逻辑的 taskNode...");
        return true;
    }
}
