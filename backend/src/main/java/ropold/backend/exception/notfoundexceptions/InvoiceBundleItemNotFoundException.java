package ropold.backend.exception.notfoundexceptions;

public class InvoiceBundleItemNotFoundException extends RuntimeException {
    public InvoiceBundleItemNotFoundException(String message) {
        super(message);
    }
}
