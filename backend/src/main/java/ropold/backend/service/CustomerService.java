package ropold.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.backend.exception.notfoundexceptions.CustomerNotFoundException;
import ropold.backend.model.customer.CustomerLicenseModel;
import ropold.backend.model.customer.CustomerModel;
import ropold.backend.repository.CustomerLicenseRepository;
import ropold.backend.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final IdService idService;
    private final CloudinaryService cloudinaryService;
    private final CustomerRepository customerRepository;
    private final CustomerLicenseRepository customerLicenseRepository;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

    public List<CustomerLicenseModel> getAllCustomerLicenses(){
        return customerLicenseRepository.findAll();
    }

    public CustomerLicenseModel getCustomerLicenseById(UUID id) {
        return customerLicenseRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer License not found"));
    }
}