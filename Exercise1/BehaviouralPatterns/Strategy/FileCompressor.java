package Exercise1.BehaviouralPatterns.Strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCompressor {
    private static final Logger logger = Logger.getLogger(FileCompressor.class.getName());
    private CompressionStrategy strategy;

    public FileCompressor(CompressionStrategy defaultStrategy) {
        this.strategy = defaultStrategy;
    }

    public void setStrategy(CompressionStrategy newStrategy) {
        this.strategy = newStrategy;
        logger.log(Level.INFO, "Compression strategy switched to: {0}", newStrategy.getClass().getSimpleName());
    }

    public String executeCompression(String fileName) {
        // Validation / Defensive Programming
        if (fileName == null || !fileName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name provided.");
        }
        
        System.out.printf("\nStarting compression for %s using %s...%n", 
            fileName, this.strategy.getClass().getSimpleName());
            
        try {
            return this.strategy.compress(fileName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Compression failed! Reverting to original file.", e);
            return fileName; // Return original file on failure
        }
    }
}
