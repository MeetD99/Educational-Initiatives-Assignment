package Exercise1.BehaviouralPatterns.Observer;

public class ObserverDemo {
    public static void main(String[] args) {
        UserProfile newUser = new UserProfile("johnwick");
        Follower f1 = new MobileAppFollower("Meet's Iphone");
        Follower f2 = new MobileAppFollower("Pal's Iphone");

        newUser.subscribe(f1);
        newUser.subscribe(f2);

        newUser.postStatus("Hey there, I am back!");

        newUser.unsubscribe(f2);
        newUser.postStatus("Hello People!");
    }
}
