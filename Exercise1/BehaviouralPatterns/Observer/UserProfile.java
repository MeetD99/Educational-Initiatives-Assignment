package Exercise1.BehaviouralPatterns.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


// Subject (Observable)
public class UserProfile {
    private static final Logger logger = Logger.getLogger(UserProfile.class.getName());
    private final String userName;
    private String latestPost;
    private final List<Follower> followers = new ArrayList<>();

    public UserProfile(String userName) {
        this.userName = userName;
    }

    public void subscribe(Follower follower) {
        if (!followers.contains(follower)) {
            followers.add(follower);
            logger.log(Level.INFO, "Follower subscribed: {0}", follower.getClass().getSimpleName());
        }
    }

    public void unsubscribe(Follower follower) {
        if (followers.remove(follower)) {
            logger.log(Level.INFO, "Follower unsubscribed: {0}", follower.getClass().getSimpleName());
        }
    }

    private void notifyFollowers() {
        for (Follower follower : followers) {
            follower.receiveUpdate(this.userName, this.latestPost);
        }
    }

    // State Change Logic
    public void postStatus(String newContent) {
        // Validation
        if (newContent == null || newContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Post content cannot be empty.");
        }
        
        this.latestPost = newContent;
        logger.log(Level.INFO, "\n {0} posted a new status: \"{1}...\"", 
            new Object[]{userName, newContent.substring(0, Math.min(newContent.length(), 20))});
        this.notifyFollowers();
    }
}
