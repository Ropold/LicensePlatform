package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.ManufacturerModel;

public interface ManufacturerRepository extends JpaRepository<ManufacturerModel,String> {
}
