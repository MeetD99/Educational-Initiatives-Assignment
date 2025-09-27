package Exercise1.BehaviouralPatterns.Strategy;


// Concrete Strategy
public class ZipCompression implements CompressionStrategy {
    @Override
    public String compress(String fileName) {
        long compressionRatio = (long) (Math.random() * 20 + 70); // 70-90%
        System.out.printf("  [ZIP Strategy]: Zipping file %s. Size reduction: %d%%%n", 
            fileName, compressionRatio);
        return fileName + ".zip";
    }
}
