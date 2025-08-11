package ropold.backend.model.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.license.LicenseModel;

import java.util.UUID;

@Entity
@Table(name = "customer_licenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLicenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "license_id")
    private LicenseModel license;
}