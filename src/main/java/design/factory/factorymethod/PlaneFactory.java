package design.factory.factorymethod;


public class PlaneFactory extends VehicleFactory {
    public Plane create() {
        System.out.println("########################");
        System.out.println("工厂方法： 生产一个 plane...");
        return new Plane();
    }
}
