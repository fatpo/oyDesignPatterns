package design.responsibility_chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiControlChain {

    @Autowired
    private DownGradeTaskNode downGradeTaskNode;

    @Autowired
    private ResultCacheTaskNode resultCacheTaskNode;

    @Autowired
    private FallbackTaskNode fallbackTaskNode;

    @Autowired
    private RecommendTaskNode recommendTaskNode;

    public void doRecommend(RecomReq req) {
        TaskNodeChain chain = new TaskNodeChain();

        // 定制责任链的节点顺序，有些业务 chain 可能要用户缓存，有些可能不需要，有些要热度兜底，有些不需要
        log.info("定制责任链的节点顺序...");
        chain.addNode(downGradeTaskNode)
                .addNode(resultCacheTaskNode)
                .addNode(recommendTaskNode)
                .addNode(fallbackTaskNode);

        log.info("开始推荐...");
        chain.doTask(req, new RecomRsp(), new RecomConfig());
    }
}
