package Exercise1.CreationalPatterns.AbstractFactory;

// Abstract Factory
public interface VehicleFactory {
    Engine createEngine();
    Tire createTire();
}
