package design.factory.staticfactory;

public class CarStaticFactory {
    public static Car createBigCar() {
        Car car = new Car();
        car.weight = 1000;
        System.out.println("静态工厂：创建一个大车子");
        return car;
    }

    public static Car createCheapCar() {
        Car car = new Car();
        car.price = 1;
        System.out.println("静态工厂：创建一个便宜车子");
        return car;
    }
}
