package design.factory.factorymethod;


public class 工厂方法 {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.run();

        Moveable m2 = new PlaneFactory().create();
        m2.run();

        Moveable m3 = new BroomFactory().create();
        m3.run();
    }
}
