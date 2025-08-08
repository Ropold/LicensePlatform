package ropold.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "manufacturers")
public record ManufacturerModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String id,

        @Column(name = "name", nullable = false)
        String name
) {
}