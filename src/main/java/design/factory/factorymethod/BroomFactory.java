package design.factory.factorymethod;


public class BroomFactory extends VehicleFactory {

    @Override
    public Moveable create() {
        System.out.println("########################");
        System.out.println("工厂方法： 生产一个 魔法扫帚...");
        return new Broom();
    }
}
