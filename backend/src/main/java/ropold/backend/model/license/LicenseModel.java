package ropold.backend.model.license;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.ManufacturerModel;

import java.time.LocalDateTime;
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

        @Column(name = "license_type", length = 50)
        private String licenseType;

        @Column(name = "version", length = 50)
        private String version;

        @Column(name = "license_duration_months")
        private Integer licenseDurationMonths;

        @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
        private LocalDateTime createdAt;

        @Column(name = "updated_at", columnDefinition = "DATETIME2")
        private LocalDateTime updatedAt;

        @Column(name = "image_url", length = 500)
        private String imageUrl;
}