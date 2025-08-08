package ropold.backend.model;

public record LicenseModel(
        String id,
        String name,
        String manufacturerId,
        String licenseTypeId
) {
}
