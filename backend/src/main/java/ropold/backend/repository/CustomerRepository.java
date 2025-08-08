package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel,String> {
}
