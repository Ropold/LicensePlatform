package ropold.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.backend.exception.notfoundexceptions.LicenseNotFoundException;
import ropold.backend.model.license.LicenseDependencyId;
import ropold.backend.model.license.LicenseDependencyModel;
import ropold.backend.model.license.LicenseModel;
import ropold.backend.model.license.LicensePriceHistoryModel;
import ropold.backend.repository.LicenseDependencyRepository;
import ropold.backend.repository.LicensePriceHistoryRepository;
import ropold.backend.repository.LicenseRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final IdService idService;
    private final CloudinaryService cloudinaryService;
    private final LicenseRepository licenseRepository;
    private final LicensePriceHistoryRepository licensePriceHistoryRepository;
    private final LicenseDependencyRepository licenseDependencyRepository;

    public List<LicensePriceHistoryModel> getAllPriceHistories() {
        return licensePriceHistoryRepository.findAll();
    }

    public LicensePriceHistoryModel getPriceHistoryById(UUID id) {
        return licensePriceHistoryRepository.findById(id)
                .orElseThrow(() -> new LicenseNotFoundException("License Price History not found"));
    }

    public List<LicenseDependencyModel> getAllLicenseDependencies() {
        return licenseDependencyRepository.findAll();
    }

    public LicenseDependencyModel getLicenseDependencyById(UUID parentLicenseId, UUID dependentLicenseId) {
        LicenseDependencyId id = new LicenseDependencyId(parentLicenseId, dependentLicenseId);
        return licenseDependencyRepository.findById(id)
                .orElseThrow(() -> new LicenseNotFoundException("License Dependency not found"));
    }

    public List<LicenseModel> getAllLicenses() {
        return licenseRepository.findAll();
    }

    public LicenseModel getLicenseById(UUID id) {
        return licenseRepository.findById(id)
                .orElseThrow(() -> new LicenseNotFoundException("License not found"));
    }
}
