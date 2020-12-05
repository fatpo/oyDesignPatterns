package design.factory.abstractfactory;

public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        System.out.println("生产现实世界的食物：面包");
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        System.out.println("生产现实世界的交通工具：汽车");
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        System.out.println("生产现实世界的武器：AK47");
        return new AK47();
    }
}
