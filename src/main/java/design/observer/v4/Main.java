package design.observer.v4;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void wakeupAction(WakeUpEvent event);
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.addObserver(new Dad());
        child.addObserver(new Mom());
        child.addObserver(new Dog());

        child.wakeup();
    }
}

/**
 * 当新增观察者时，至少这个被观察者的 class 代码无需更改，不违反开闭原则。
 * <p>
 * 但是被观察者，场景可能比较复杂，比如在床上醒来，和在沙发上醒来，要采取不同的动作。
 * 比如床上醒来爸爸冲奶粉，沙发上醒来爸爸拿毛巾盖着。
 * <p>
 * 在早上醒来，在晚上醒来也不一样。
 * 比如早上醒来换尿布，晚上醒来冲奶粉。
 *
 * <p>
 * 我们需要把孩子醒来的地点发给观察者！！！
 */
class Child {
    List<Observer> observers = new ArrayList<>();
    private boolean isCry = false;
    private final String name = "baobao";

    public String getName() {
        return name;
    }

    /**
     * 添加观察者
     *
     * @param observer 被添加的观察者
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public boolean isCry() {
        return isCry;
    }

    /**
     * 观察孩子哭了，观察者们（爸爸、妈妈、小狗）就开始做动作
     */
    public void wakeup() {
        isCry = true;

        WakeUpEvent wakeUpEvent = new WakeUpEvent("sofa", System.currentTimeMillis(), this);
        for (Observer observer : observers) {
            observer.wakeupAction(wakeUpEvent);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class WakeUpEvent extends Event<Child> {
    String location;
    long timestamp;
    Child source;

    public WakeUpEvent(String location, long timestamp, Child source) {
        this.location = location;
        this.timestamp = timestamp;
        this.source = source;
    }

    @Override
    Child getSource() {
        return this.source;
    }
}

class Dad implements Observer {
    public void feed() {
        System.out.println("爸爸 冲奶粉...");
    }

    public void quilt() {
        System.out.println("爸爸 盖被子...");
    }

    @Override
    public void wakeupAction(WakeUpEvent event) {
        System.out.println("这是哪个宝宝醒了：" + event.getSource().getName());
        if (event.location.equals("bed")) {
            feed();
        } else if (event.location.equals("sofa")) {
            quilt();
        }
    }
}

class Mom implements Observer {
    public void hug() {
        System.out.println("妈妈 抱抱...");
    }

    @Override
    public void wakeupAction(WakeUpEvent event) {
        hug();
    }
}


class Dog implements Observer {
    public void wang() {
        System.out.println("小狗 汪汪...");
    }

    @Override
    public void wakeupAction(WakeUpEvent event) {
        wang();
    }
}