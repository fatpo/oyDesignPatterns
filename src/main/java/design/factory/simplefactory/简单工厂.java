package design.factory.simplefactory;

public class 简单工厂 {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        Moveable m = simpleFactory.newCar();
        m.run();

        Moveable m2 = simpleFactory.newPlane();
        m2.run();

        Moveable m3 = simpleFactory.newBroom();
        m3.run();
    }
}
