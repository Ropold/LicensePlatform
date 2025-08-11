package ropold.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.backend.exception.LicenseNotFoundException;
import ropold.backend.model.license.LicenseModel;
import ropold.backend.repository.LicenseRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final IdService idService;
    private final CloudinaryService cloudinaryService;
    private final LicenseRepository licenseRepository;

    public List<LicenseModel> getAllLicenses() {
        return licenseRepository.findAll();
    }

    public LicenseModel getLicenseById(UUID id) {
        return licenseRepository.findById(id)
                .orElseThrow(() -> new LicenseNotFoundException("License not found"));
    }
}
