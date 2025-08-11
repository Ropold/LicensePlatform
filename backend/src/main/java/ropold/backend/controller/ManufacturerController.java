package ropold.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ropold.backend.exception.ManufacturerNotFoundException;
import ropold.backend.model.ManufacturerModel;
import ropold.backend.service.CloudinaryService;
import ropold.backend.service.ManufacturerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/manufacturers")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    private final CloudinaryService cloudinaryService;

    @GetMapping
    public List<ManufacturerModel> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/{id}")
    public ManufacturerModel getManufacturerById(@PathVariable UUID id) {
        ManufacturerModel manufacturer = manufacturerService.getManufacturerById(id);
        if (manufacturer == null) {
            throw new ManufacturerNotFoundException("No Manufacturer found with id: " + id);
        }
        return manufacturer;
    }
}
