package ropold.backend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropold.backend.exception.CustomerLicenseNotFoundException;
import ropold.backend.exception.CustomerNotFoundException;
import ropold.backend.model.customer.CustomerLicenseModel;
import ropold.backend.model.customer.CustomerModel;
import ropold.backend.service.CloudinaryService;
import ropold.backend.service.CustomerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CloudinaryService cloudinaryService;

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerModel getCustomerById(@PathVariable UUID id) {
        CustomerModel customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("No Customer found with id: " + id);
        }
        return customer;
    }

    @GetMapping("/licenses")
    public List<CustomerLicenseModel> getAllCustomerLicenses() {
        return customerService.getAllCustomerLicenses();
    }

    @GetMapping("/licenses/{id}")
    public CustomerLicenseModel getCustomerLicenseById(@PathVariable UUID id) {
        CustomerLicenseModel license = customerService.getCustomerLicenseById(id);
        if (license == null) {
            throw new CustomerLicenseNotFoundException("No Customer License found with id: " + id);
        }
        return license;
    }
}
