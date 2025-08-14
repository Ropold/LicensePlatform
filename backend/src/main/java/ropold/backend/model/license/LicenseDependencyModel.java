package ropold.backend.model.license;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "license_dependencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseDependencyModel {

    @EmbeddedId
    private LicenseDependencyId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("parentLicenseId")
    @JoinColumn(name = "parent_license_id")
    private LicenseModel parentLicense;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dependentLicenseId")
    @JoinColumn(name = "dependent_license_id")
    private LicenseModel dependentLicense;
}