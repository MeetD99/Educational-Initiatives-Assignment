package Exercise1.CreationalPatterns.Builder;

public class BuilderDemo {
    public static void main(String[] args) {
        UserAccountBuilder b1 = new PremiumAccountBuilder();
        UserAccountBuilder b2 = new StandardAccountBuilder();

        b1.reset("meet_dholakia", "meetd@gmail.com");
        b1.setPhone("+91-9313741505");
        b1.setShippingAddress("Gift City, Gandhinagar");
        b1.optInToNewsletter(true);

        b2.reset("meet_dholakia99", "meet@xyz.com");
        b2.setPhone("123456");
        

        UserAccount u1 = b1.getResult();
        u1.displayInfo();

        UserAccount u2 = b2.getResult();
        u2.displayInfo();
    }
}
