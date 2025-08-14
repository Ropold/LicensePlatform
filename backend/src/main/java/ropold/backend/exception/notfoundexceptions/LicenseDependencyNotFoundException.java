package ropold.backend.exception.notfoundexceptions;

public class LicenseDependencyNotFoundException extends RuntimeException {
    public LicenseDependencyNotFoundException(String message) {
        super(message);
    }
}
