package ropold.backend.model.license;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "license_price_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicensePriceHistoryModel {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "license_id")
    private LicenseModel license;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "manufacturer_purchase_price", precision = 10, scale = 2)
    private BigDecimal manufacturerPurchasePrice;

    @Column(name = "manufacturer_discount_percent", precision = 5, scale = 2)
    private BigDecimal manufacturerDiscountPercent;

    @Column(name = "actual_purchase_price", precision = 10, scale = 2)
    private BigDecimal actualPurchasePrice;

    @Column(name = "standard_sale_price", precision = 10, scale = 2)
    private BigDecimal standardSalePrice;

    @Column(name = "customer_discount_percent", precision = 5, scale = 2)
    private BigDecimal customerDiscountPercent;

    @Column(name = "actual_sale_price", precision = 10, scale = 2)
    private BigDecimal actualSalePrice;

    @Column(name = "price_change_percentage", precision = 5, scale = 2)
    private BigDecimal priceChangePercentage;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime createdAt;
}