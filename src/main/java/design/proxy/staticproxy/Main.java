package design.proxy.staticproxy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new LogTankProxy(new TimeTankProxy(new Tank())).run();
    }
}


interface Moveable {
    void run();
}

class Tank implements Moveable {

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

class TimeTankProxy implements Moveable {
    private Moveable tank;

    public TimeTankProxy(Moveable tank) {
        this.tank = tank;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        this.tank.run();

        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end - start));
    }
}


class LogTankProxy implements Moveable {
    private Moveable tank;

    public LogTankProxy(Moveable tank) {
        this.tank = tank;
    }

    @Override
    public void run() {
        System.out.println("开始跑...");

        this.tank.run();

        System.out.println("结束跑...");
    }
}