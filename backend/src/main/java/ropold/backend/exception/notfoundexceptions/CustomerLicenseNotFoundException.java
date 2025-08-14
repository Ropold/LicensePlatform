package ropold.backend.exception.notfoundexceptions;

public class CustomerLicenseNotFoundException extends RuntimeException {
    public CustomerLicenseNotFoundException(String message) {
        super(message);
    }
}
