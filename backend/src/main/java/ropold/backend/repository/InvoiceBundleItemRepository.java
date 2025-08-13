package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.invoice.InvoiceBundleItemModel;

import java.util.UUID;

public interface InvoiceBundleItemRepository extends JpaRepository<InvoiceBundleItemModel, UUID> {
}
