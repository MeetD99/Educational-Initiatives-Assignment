package Exercise1.CreationalPatterns.Builder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PremiumAccountBuilder implements UserAccountBuilder {
    private static final Logger logger = Logger.getLogger(PremiumAccountBuilder.class.getName());

    private String currentUserId;
    private String currentEmail;
    private String currentPhone;
    private String currentAddress;
    private boolean currentNewsletterOptIn;
    
    // Premium accounts automatically opt-in for marketing optimization
    private static final boolean PREMIUM_DEFAULT_OPT_IN = true; 

    @Override
    public void reset(String userId, String email) {
        if (userId == null || email == null) {
            throw new IllegalArgumentException("User ID and Email are mandatory.");
        }
        this.currentUserId = userId;
        this.currentEmail = email;
        this.currentPhone = "Priority Contact N/A"; 
        this.currentAddress = "Verified Address N/A";
        this.currentNewsletterOptIn = PREMIUM_DEFAULT_OPT_IN; // Different default
        logger.log(Level.INFO, "Premium Account builder reset for: {0}", userId);
    }

    @Override
    public void setPhone(String phone) {
        // Premium builder applies stronger formatting/validation
        if (phone != null && phone.matches("^\\+91-\\d{10}$")) { 
            this.currentPhone = phone;
        } else {
            logger.log(Level.WARNING, "Invalid phone provided; using Priority default.");
        }
    }

    @Override
    public void setShippingAddress(String address) {
        this.currentAddress = "Verified: " + address; // Adds verification tag
    }

    @Override
    public void optInToNewsletter(boolean optIn) {
        // Premium builder ignores the opt-in flag if false, enforcing the premium default
        if (optIn) {
            this.currentNewsletterOptIn = true;
        } else {
            logger.log(Level.WARNING, "Premium accounts always receive updates (opt-in enforced).");
        }
    }

    @Override
    public UserAccount getResult() {
        if (currentUserId == null) {
             throw new IllegalStateException("Builder was not reset or built.");
        }
        UserAccount result = UserAccount.FinalAccount.create(
            currentUserId, currentEmail, currentPhone, currentAddress, currentNewsletterOptIn);
        this.currentUserId = null;
        return result;
    }
}
