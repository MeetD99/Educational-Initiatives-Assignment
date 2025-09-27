package Exercise1.StructuralPatterns.Adapter;

import java.util.logging.Level;
import java.util.logging.Logger;

// Adaptee (The incompatible class)
public class FahrenheitSensor {
    private static final Logger logger = Logger.getLogger(FahrenheitSensor.class.getName());
    
    
    public double getFahrenheitReading() {
        logger.log(Level.INFO, "🌡️ Sensor reading temperature in Fahrenheit...");
        if (Math.random() < 0.1) {
            // Transient error handling simulation
            logger.log(Level.WARNING, "Sensor reading failed. Retrying...");
            return 75.0; // Return a default on successful retry
        }
        return 75.0 + Math.random() * 5.0; // Random value between 75 and 80 F
    }
}
