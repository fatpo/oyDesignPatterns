package design.factory.factorymethod;

public class CarFactory extends VehicleFactory {
    @Override
    public Moveable create() {
        System.out.println("########################");
        System.out.println("工厂方法： 生产一个 car...");
        return new Car();
    }
}
