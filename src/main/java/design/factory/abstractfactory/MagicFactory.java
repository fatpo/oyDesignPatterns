package design.factory.abstractfactory;

public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        System.out.println("生产魔法世界的食物：蘑菇");
        return new Mushroom();
    }

    @Override
    Vehicle createVehicle() {
        System.out.println("生产魔法世界的交通工具：扫帚");
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        System.out.println("生产魔法世界的武器：魔法棒");
        return new Stick();
    }
}
