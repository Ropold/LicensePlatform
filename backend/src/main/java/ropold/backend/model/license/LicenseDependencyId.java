package ropold.backend.model.license;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class LicenseDependencyId implements Serializable {
    private UUID parentLicenseId;
    private UUID dependentLicenseId;

    public LicenseDependencyId(UUID parentLicenseId, UUID dependentLicenseId) {
        this.parentLicenseId = parentLicenseId;
        this.dependentLicenseId = dependentLicenseId;
    }
}
