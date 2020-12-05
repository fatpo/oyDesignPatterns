package design.factory.simplefactory;

public class SimpleFactory {
    public Car newCar() {
        System.out.println("简单工厂：生产汽车...");
        return new Car();
    }

    public Plane newPlane() {
        System.out.println("简单工厂：生产飞机...");
        return new Plane();
    }

    public Broom newBroom() {
        System.out.println("简单工厂：生产扫帚...");
        return new Broom();
    }
}
