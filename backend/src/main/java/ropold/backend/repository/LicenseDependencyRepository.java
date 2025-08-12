package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.license.LicenseDependencyId;
import ropold.backend.model.license.LicenseDependencyModel;

public interface LicenseDependencyRepository extends JpaRepository<LicenseDependencyModel, LicenseDependencyId> {
}
