package design.factory.factorymethod;

public class Broom implements Moveable {
    @Override
    public void run() {
        System.out.println("魔法扫帚，飞...");
    }
}
