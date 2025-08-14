package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.license.LicenseModel;

import java.util.UUID;

public interface LicenseRepository extends JpaRepository<LicenseModel, UUID> {
}
