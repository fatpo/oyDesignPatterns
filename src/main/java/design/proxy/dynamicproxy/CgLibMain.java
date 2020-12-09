package design.proxy.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank2.class);
        enhancer.setCallback(new TimeProxy());

        Tank2 t = (Tank2) enhancer.create();
        t.run();
    }
}


class Tank2 {
    public void run() {
        System.out.println("坦克跑路...");
    }
}

class TimeProxy implements MethodInterceptor {


    private void before() {
        System.out.println("before...");
    }

    private void after() {
        System.out.println("after...");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();

        Object result = methodProxy.invokeSuper(o, objects);

        after();

        return result;
    }
}