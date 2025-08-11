package ropold.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerModel{
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "name", nullable = false)
        private String name;

}