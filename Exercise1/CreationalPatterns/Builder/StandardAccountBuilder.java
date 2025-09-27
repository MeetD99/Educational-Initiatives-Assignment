package Exercise1.CreationalPatterns.Builder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StandardAccountBuilder implements UserAccountBuilder {
    private static final Logger logger = Logger.getLogger(StandardAccountBuilder.class.getName());

    // State maintained during construction
    private String currentUserId;
    private String currentEmail;
    private String currentPhone;
    private String currentAddress;
    private boolean currentNewsletterOptIn;

    @Override
    public void reset(String userId, String email) {
        // Validation for required fields
        if (userId == null || email == null) {
            logger.log(Level.SEVERE, "Required fields for builder reset are null.");
            throw new IllegalArgumentException("User ID and Email are mandatory.");
        }
        this.currentUserId = userId;
        this.currentEmail = email;
        this.currentPhone = "N/A";       // Default
        this.currentAddress = "N/A";     // Default
        this.currentNewsletterOptIn = false; // Default
        logger.log(Level.INFO, "Standard Account builder reset for: {0}", userId);
    }

    @Override
    public void setPhone(String phone) {
        // Defensive: Basic validation
        if (phone != null && phone.length() > 5) {
            this.currentPhone = phone;
        } else {
            logger.log(Level.WARNING, "Invalid phone provided; using default.");
        }
    }

    @Override
    public void setShippingAddress(String address) {
        this.currentAddress = address;
    }

    @Override
    public void optInToNewsletter(boolean optIn) {
        this.currentNewsletterOptIn = optIn;
    }

    @Override
    public UserAccount getResult() {
        if (currentUserId == null) {
             throw new IllegalStateException("Builder was not reset or built.");
        }
        UserAccount result = UserAccount.FinalAccount.create(
            currentUserId, currentEmail, currentPhone, currentAddress, currentNewsletterOptIn);
        
        // Reset state after returning the product (GoF requirement for reuse)
        this.currentUserId = null; 
        return result; 
    }
}
