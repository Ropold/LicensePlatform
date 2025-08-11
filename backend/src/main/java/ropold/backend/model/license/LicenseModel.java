package ropold.backend.model.license;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.ManufacturerModel;

import java.util.UUID;

@Entity
@Table(name = "licenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseModel {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "name", nullable = false)
        private String name;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "manufacturer_id")
        private ManufacturerModel manufacturer;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "license_type_id")
        private LicenseTypeModel licenseType;
}