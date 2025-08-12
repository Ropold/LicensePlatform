package ropold.backend.exception;

public class CustomerLicenseNotFoundException extends RuntimeException {
    public CustomerLicenseNotFoundException(String message) {
        super(message);
    }
}
