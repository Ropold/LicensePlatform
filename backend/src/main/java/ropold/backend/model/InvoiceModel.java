package ropold.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public record InvoiceModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String id,

        @Column(name = "invoice_number", unique = true, nullable = false)
        String invoiceNumber,

        @Column(name = "customer_license_id", nullable = false)
        String customerLicenseId
) {
}