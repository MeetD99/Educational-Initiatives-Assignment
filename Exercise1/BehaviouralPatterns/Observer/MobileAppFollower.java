package Exercise1.BehaviouralPatterns.Observer;
import java.io.IOException;

// Concrete Observer
public class MobileAppFollower implements Follower {
    private final String deviceName;

    public MobileAppFollower(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void receiveUpdate(String userName, String postContent) {
        try {
            displayNotification(userName, postContent);
        } catch (IOException e) {
             // Exception Handling / Transient Error Simulation
            System.err.printf("[%s]: Notification display failed. Queueing retry...%n", deviceName);
        }
    }
    
    // Simulate an I/O operation (like displaying a notification)
    private void displayNotification(String userName, String postContent) throws IOException {
        if (Math.random() < 0.05) { // 5% chance of I/O failure
            throw new IOException("Device screen buffer full.");
        }
        System.out.printf("  [%s Notification]: New post from %s: %s%n", 
            deviceName, userName, postContent.substring(0, Math.min(postContent.length(), 30)) + "...");
    }
}
