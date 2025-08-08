package ropold.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public record CustomerModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        String id,

        @Column(name = "name")
        String name
) {
}