package ropold.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.backend.exception.notfoundexceptions.ManufacturerNotFoundException;
import ropold.backend.model.ManufacturerModel;
import ropold.backend.repository.ManufacturerRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    private final IdService idService;
    private final CloudinaryService cloudinaryService;
    private final ManufacturerRepository manufacturerRepository;

    public List<ManufacturerModel> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public ManufacturerModel getManufacturerById(UUID id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException("Manufacturer not found with id: " + id));
    }
}
