package design.observer.v2;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeup();
    }
}

class Child {
    private boolean isCry = false;

    /**
     * 每多一个观察者（如多一个爷爷奶奶），都要改 被观察者（小孩）的代码
     */
    private final Dad dad = new Dad();
    private final Mom mom = new Mom();
    private final Dog dog = new Dog();

    public boolean isCry() {
        return isCry;
    }

    /**
     * 观察孩子哭了，观察者们（爸爸、妈妈、小狗）就开始做动作
     */
    public void wakeup() {
        isCry = true;

        dad.feed();
        mom.hug();
        dog.wang();
    }
}

class Dad {
    public void feed() {
        System.out.println("爸爸 冲奶粉...");
    }
}

class Mom {
    public void hug() {
        System.out.println("妈妈 抱抱...");
    }
}


class Dog {
    public void wang() {
        System.out.println("小狗 汪汪...");
    }
}