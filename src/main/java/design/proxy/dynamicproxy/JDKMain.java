package design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class JDKMain {
    public static void main(String[] args) {
        Tank tank = new Tank();

        // > jdk8
        //  System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        // jdk8，把中间的 proxy.class 保存下来
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Moveable m = (Moveable) Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                new Class[]{Moveable.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("start invoke...");
                        Object o = method.invoke(tank, args);
                        System.out.println("end invoke...");
                        return o;
                    }
                });
        m.run();
    }
}


interface Moveable {
    void run();
}

final class Tank implements Moveable {

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("tank run...");
    }
}
