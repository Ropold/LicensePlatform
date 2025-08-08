package ropold.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.backend.exception.InvoiceNotFoundException;
import ropold.backend.model.InvoiceModel;
import ropold.backend.repository.InvoiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final IdService idService;
    private final CloudinaryService cloudinaryService;
    private final InvoiceRepository invoiceRepository;

    public List<InvoiceModel> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public InvoiceModel getInvoiceById(String id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
    }
}

