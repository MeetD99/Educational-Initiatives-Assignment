package Exercise1.CreationalPatterns.AbstractFactory;

// Concrete Factory
public class EconomyVehicleFactory implements VehicleFactory {
    private static class FourCylinderEngine implements Engine {
        @Override
        public void start() {
            System.out.println("⛽ Economy 4-Cylinder Engine: Quiet and fuel-efficient.");
        }
    }

    private static class BasicTire implements Tire {
        @Override
        public void grip() {
            System.out.println("⚪ Economy Basic Tire: Standard all-weather grip (Low Cost).");
        }
    }
    
    @Override
    public Engine createEngine() {
        return new FourCylinderEngine();
    }

    @Override
    public Tire createTire() {
        return new BasicTire();
    }
}
