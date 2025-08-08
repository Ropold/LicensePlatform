package ropold.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "licenses")
public record LicenseModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String id,

        @Column(name = "name", nullable = false)
        String name,

        @Column(name = "manufacturer_id", nullable = false)
        String manufacturerId,

        @Column(name = "license_type_id", nullable = false)
        String licenseTypeId
) {
}