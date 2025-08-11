package ropold.backend.model.license;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "license_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true)
    private LicenseTypeEnum type;
}