package ropold.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ropold.backend.model.customer.CustomerLicenseModel;

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

        @Column(name = "invoice_number")
        private String invoiceNumber;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "customer_license_id")
        private CustomerLicenseModel customerLicense;
}