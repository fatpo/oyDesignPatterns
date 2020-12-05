package design.responsibility_chain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiControlChainTest {
    @Autowired
    ApiControlChain apiControlChain;

    @Test
    public void testRec() {
        apiControlChain.doRecommend(new RecomReq());
    }
}