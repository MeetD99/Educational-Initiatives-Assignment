package Exercise1.CreationalPatterns.Builder;

public interface UserAccountBuilder {
    // Step 1: Initialize/Reset the product
    void reset(String userId, String email);

    // Step 2: Build optional parts
    void setPhone(String phone);
    void setShippingAddress(String address);
    
    // Step 3: Set flags
    void optInToNewsletter(boolean optIn);

    // Step 4: Finalize and return the product
    UserAccount getResult();
}