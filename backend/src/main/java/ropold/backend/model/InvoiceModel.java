package ropold.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceModel {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "invoice_number", unique = true, nullable = false)
        private String invoiceNumber;

        @Column(name = "customer_license_id", nullable = false)
        private String customerLicenseId;

}