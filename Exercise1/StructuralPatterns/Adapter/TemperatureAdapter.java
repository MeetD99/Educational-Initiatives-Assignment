package Exercise1.StructuralPatterns.Adapter;

// Adapter Class
public class TemperatureAdapter implements CelsiusTemperatureReader {
    private final FahrenheitSensor sensor;

    public TemperatureAdapter(FahrenheitSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public double getTemperatureC() {
        // Step 1: Get the incompatible data
        double fahrenheit = sensor.getFahrenheitReading();
        
        // Step 2: Adapt (convert) the data
        // C = (F - 32) * 5/9
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        
        // Defensive Programming: Ensure calculated value is reasonable
        if (celsius < -100 || celsius > 100) {
            throw new RuntimeException("Adapter produced an extreme temperature value: " + celsius);
        }
        
        System.out.printf("🔄 ADAPTER: Converted %.2f°F to %.2f°C.%n", fahrenheit, celsius);
        return celsius;
    }
}
