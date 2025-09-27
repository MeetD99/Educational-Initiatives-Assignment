package Exercise1.BehaviouralPatterns.Strategy;

public class RarCompression implements CompressionStrategy {
     @Override
    public String compress(String fileName) {
        // Optimization: RAR often offers better compression but is slower
        try {
            Thread.sleep(50); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long compressionRatio = (long) (Math.random() * 5 + 90); // 90-95%
        System.out.printf("  [RAR Strategy]: Compressing file %s. Size reduction: %d%%%n", 
            fileName, compressionRatio);
        return fileName + ".rar";
    }
}
