package ropold.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropold.backend.exception.LicenseNotFoundException;
import ropold.backend.model.license.LicenseModel;
import ropold.backend.service.CloudinaryService;
import ropold.backend.service.LicenseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/licenses")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;
    private final CloudinaryService cloudinaryService;

    @GetMapping
    public List<LicenseModel> getAllLicenses() {
        return licenseService.getAllLicenses();
    }

    @GetMapping("/{id}")
    public LicenseModel getLicenseById(@PathVariable UUID id) {
        LicenseModel license = licenseService.getLicenseById(id);
        if (license == null) {
            throw new LicenseNotFoundException("No License found with id: " + id);
        }
        return license;
    }
}
