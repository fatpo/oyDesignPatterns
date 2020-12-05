package design.factory.abstractfactory;

/**
 * 灵活扩展产品一族！
 * 目前产品：
 * 现代人： 开汽车 + 吃面包 + 武器 AK47
 * 魔法人： 骑扫帚 + 吃蘑菇 + 魔法棒
 */
public class 抽象工厂 {
    public static void main(String[] args) {
        AbstractFactory f = new ModernFactory();
        Vehicle v = f.createVehicle();
        Food food = f.createFood();
        Weapon weapon = f.createWeapon();

        AbstractFactory f2 = new MagicFactory();
        Vehicle v2 = f2.createVehicle();
        Food food2 = f2.createFood();
        Weapon weapon2 = f2.createWeapon();
    }
}
