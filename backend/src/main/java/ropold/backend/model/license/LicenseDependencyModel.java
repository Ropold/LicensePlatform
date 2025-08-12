package ropold.backend.model.license;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "license_dependencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDependencyModel {

    @EmbeddedId
    private LicenseDependencyId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("parentLicenseId")
    @JoinColumn(name = "parent_license_id")
    private LicenseModel parentLicense;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dependentLicenseId")
    @JoinColumn(name = "dependent_license_id")
    private LicenseModel dependentLicense;

    @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime createdAt;
}