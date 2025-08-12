package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.invoice.InvoiceModel;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, UUID> {
}
