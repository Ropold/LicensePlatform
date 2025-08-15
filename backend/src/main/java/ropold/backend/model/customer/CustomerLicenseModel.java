package ropold.backend.model.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.license.LicenseModel;
import ropold.backend.model.license.LicenseTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer_licenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLicenseModel {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "license_id")
    private LicenseModel license;

    @Enumerated(EnumType.STRING)
    @Column(name = "license_type", nullable = false, length = 50)
    private LicenseTypeEnum licenseType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "billing_date")
    private LocalDate billingDate;

    @Column(name = "cancellation_period_days")
    private Integer cancellationPeriodDays;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "manufacturer_reference")
    private String manufacturerReference;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "version", length = 50)
    private String version;

    @Column(name = "purchase_price", precision = 10, scale = 2)
    private BigDecimal purchasePrice;

    @Column(name = "discount_percent", precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(name = "sale_price", precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "profit", precision = 10, scale = 2)
    private BigDecimal profit;

    @Column(name = "created_at", columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime createdAt;
}