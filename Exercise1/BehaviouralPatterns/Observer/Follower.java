package Exercise1.BehaviouralPatterns.Observer;
// Observer Interface
public interface Follower {
    //Receives and processes the update from the User Profile.
    void receiveUpdate(String userName, String postContent);
}