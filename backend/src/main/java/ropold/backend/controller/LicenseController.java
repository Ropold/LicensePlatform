package ropold.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropold.backend.exception.notfoundexceptions.LicenseDependencyNotFoundException;
import ropold.backend.exception.notfoundexceptions.LicenseNotFoundException;
import ropold.backend.exception.notfoundexceptions.LicensePriceHistoryNotFoundException;
import ropold.backend.model.license.LicenseDependencyModel;
import ropold.backend.model.license.LicenseModel;
import ropold.backend.model.license.LicensePriceHistoryModel;
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

    @GetMapping("/price-history")
    public List<LicensePriceHistoryModel> getAllPriceHistories() {
        return licenseService.getAllPriceHistories();
    }

    @GetMapping("/price-history/{id}")
    public LicensePriceHistoryModel getPriceHistoryById(@PathVariable UUID id) {
        LicensePriceHistoryModel priceHistory = licenseService.getPriceHistoryById(id);
        if (priceHistory == null) {
            throw new LicensePriceHistoryNotFoundException("No License Price History found with id: " + id);
        }
        return priceHistory;
    }

    @GetMapping("/dependencies")
    public List<LicenseDependencyModel> getAllLicenseDependencies() {
        return licenseService.getAllLicenseDependencies();
    }

    @GetMapping("/dependencies/{parentId}/{dependentId}")
    public LicenseDependencyModel getDependencyById(@PathVariable UUID parentId, @PathVariable UUID dependentId) {
        LicenseDependencyModel dependency = licenseService.getLicenseDependencyById(parentId, dependentId);
        if (dependency == null) {
            throw new LicenseDependencyNotFoundException("No License Dependency found with parentId: " + parentId + " and dependentId: " + dependentId);
        }
        return dependency;
    }

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
