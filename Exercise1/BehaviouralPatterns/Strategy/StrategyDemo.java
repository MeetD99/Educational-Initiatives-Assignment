package Exercise1.BehaviouralPatterns.Strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        FileCompressor fc = new FileCompressor(new ZipCompression());

        fc.executeCompression("video.mp4");

        fc.setStrategy(new RarCompression());
        fc.executeCompression("introduction.ppt");
    }
}
