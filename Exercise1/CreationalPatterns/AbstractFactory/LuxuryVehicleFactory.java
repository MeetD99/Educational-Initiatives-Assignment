package Exercise1.CreationalPatterns.AbstractFactory;

// Concrete Factory
public class LuxuryVehicleFactory implements VehicleFactory {
    private static class V8Engine implements Engine {
        @Override
        public void start() {
            System.out.println("🏎️ Luxury V8 Engine: Starts with a powerful roar.");
        }
    }

    private static class SportTire implements Tire {
        @Override
        public void grip() {
            System.out.println("⚫ Luxury Sport Tire: Max performance grip (High Cost).");
        }
    }
    
    @Override
    public Engine createEngine() {
        return new V8Engine();
    }

    @Override
    public Tire createTire() {
        return new SportTire();
    }
}
