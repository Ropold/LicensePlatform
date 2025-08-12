package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.customer.CustomerLicenseModel;

import java.util.UUID;

public interface CustomerLicenseRepository extends JpaRepository<CustomerLicenseModel, UUID> {
}
