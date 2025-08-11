package ropold.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropold.backend.exception.InvoiceNotFoundException;
import ropold.backend.model.InvoiceModel;
import ropold.backend.repository.InvoiceRepository;
import ropold.backend.service.CloudinaryService;
import ropold.backend.service.InvoiceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final CloudinaryService cloudinaryService;
    private final InvoiceRepository invoiceRepository;

    @GetMapping
    public List<InvoiceModel> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/huhu")
    public String huhu() {
        return "Huhu from InvoiceController!";
    }

    @GetMapping("/{id}")
    public InvoiceModel getInvoiceById(@PathVariable UUID id) {
        InvoiceModel invoice = invoiceService.getInvoiceById(id);
        if (invoice == null) {
            throw new InvoiceNotFoundException("No Invoice found with id: " + id);
        }
        return invoice;
    }

}
