package design.responsibility_chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResultCacheTaskNode implements TaskNode {
    public boolean doTask(RecomReq req, RecomRsp rsp, RecomConfig config, TaskNodeChain chain) {
        log.info("进入用户结果缓存逻辑的 taskNode...");

        // 判断是否需要降级
        if (canRunCache()) {
            // false 表示中断后续的责任链，这里返回即可
            return false;
        }

        // 把球传给责任链中的下个节点
        chain.doTask(req, rsp, config);


        // 更新用户结果缓存
        updateResultCache();
        log.info("离开用户结果缓存逻辑的 taskNode...");
        return true;
    }

    private boolean canRunCache() {
        log.info("判断下用户结果缓存是否满足...");
        return false;
    }


    private void updateResultCache() {
        log.info("更新用户缓存...");
    }
}
