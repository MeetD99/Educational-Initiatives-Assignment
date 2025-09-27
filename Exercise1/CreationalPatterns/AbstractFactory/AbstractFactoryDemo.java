package Exercise1.CreationalPatterns.AbstractFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory f1 = new LuxuryVehicleFactory();
        VehicleFactory f2 = new EconomyVehicleFactory();

        Engine e1 = f1.createEngine();
        e1.start();
        Tire t1 = f1.createTire();
        t1.grip();

        Engine e2 = f2.createEngine();
        e2.start();
        Tire t2 = f2.createTire();
        t2.grip();
    }
}
