package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.ManufacturerModel;

import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<ManufacturerModel, UUID> {
}
