package ropold.backend.model;

public record InvoiceModel(
        String id,
        String invoiceNumber,
        String customerLicenseId
) {
}
