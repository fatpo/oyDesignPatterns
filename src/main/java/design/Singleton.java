package design;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Singleton {
    private Singleton() {
    }

    // volatile 禁止指令重排序，否则高并发下会返回一个半初始化的对象给业务层使用，就完了
    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }

        }
        return singleton;
    }

    public static void main(String[] args) throws InterruptedException {
        int clientNum = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(clientNum);

        Set<Integer> hashCodes = new HashSet<>(16);
        hashCodes.add(Singleton.getInstance().hashCode());
        for (int i = 0; i < clientNum; i++) {
            Thread t = new Thread(() -> {
                int a = Singleton.getInstance().hashCode();
                if (!hashCodes.contains(a)) {
                    System.out.println("找到不同的hashCode!!!!");
                }
                countDownLatch.countDown();
            });
            t.start();
        }

        countDownLatch.await();
        System.out.println("ok!");
    }
}
