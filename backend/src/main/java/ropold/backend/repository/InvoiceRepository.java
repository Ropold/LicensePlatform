package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.InvoiceModel;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, String> {
}
