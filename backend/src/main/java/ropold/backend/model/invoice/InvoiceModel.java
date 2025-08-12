package ropold.backend.model.invoice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ropold.backend.model.customer.CustomerLicenseModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        @Column(name = "invoice_number", nullable = false, length = 100)
        private String invoiceNumber;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "customer_license_id")
        private CustomerLicenseModel customerLicense;

        @Column(name = "invoice_date", nullable = false)
        private LocalDate invoiceDate;

        @Column(name = "due_date")
        private LocalDate dueDate;

        @Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
        private BigDecimal subtotal;

        @Column(name = "tax_amount", precision = 12, scale = 2)
        private BigDecimal taxAmount;

        @Column(name = "total_amount", nullable = false, precision = 12, scale = 2)
        private BigDecimal totalAmount;

        @Column(name = "notes", columnDefinition = "TEXT")
        private String notes;

        @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
        private LocalDateTime createdAt;

        @Column(name = "updated_at", columnDefinition = "DATETIME2")
        private LocalDateTime updatedAt;
}