package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.LicenseModel;

public interface LicenseRepository extends JpaRepository<LicenseModel,String> {
}
