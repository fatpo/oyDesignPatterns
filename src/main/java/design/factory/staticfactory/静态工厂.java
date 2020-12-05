package design.factory.staticfactory;

public class 静态工厂 {
    public static void main(String[] args) {
        Car c1 = CarStaticFactory.createBigCar();
        Car c2 = CarStaticFactory.createCheapCar();
    }
}
