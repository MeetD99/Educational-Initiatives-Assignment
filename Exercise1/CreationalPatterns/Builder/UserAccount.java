package Exercise1.CreationalPatterns.Builder;

public class UserAccount {
    // Final fields ensure the object is immutable once built
    private final String userId;          
    private final String email;           
    private final String phone;           
    private final String shippingAddress; 
    private final boolean newsletterOptIn; 

    // Private constructor ensures creation only via the Builder
    private UserAccount(String userId, String email, String phone, String shippingAddress, boolean newsletterOptIn) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.shippingAddress = shippingAddress;
        this.newsletterOptIn = newsletterOptIn;
    }
    
    // Getters for external access
    public String getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public boolean isNewsletterOptIn() { return newsletterOptIn; }
    public String getShippingAddress() { return shippingAddress; }
    
    // ... display method for testing ...
    public void displayInfo() {
        System.out.println("  ID: " + userId + ", Email: " + email + ", Phone: " + phone + 
                           ", Newsletter: " + newsletterOptIn + ", Address: " + shippingAddress);
    }
    
    // --- Inner Builder Class to facilitate construction ---
    public static class FinalAccount {
        // This is used by the Concrete Builders to pass final parts back to the private constructor
        public static UserAccount create(String userId, String email, String phone, String address, boolean optIn) {
            return new UserAccount(userId, email, phone, address, optIn);
        }
    }
}
