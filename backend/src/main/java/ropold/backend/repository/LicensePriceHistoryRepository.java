package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.license.LicensePriceHistoryModel;

import java.util.UUID;

public interface LicensePriceHistoryRepository extends JpaRepository<LicensePriceHistoryModel, UUID> {
}
