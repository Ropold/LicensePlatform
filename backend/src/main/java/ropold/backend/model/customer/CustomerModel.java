package ropold.backend.model.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "name")
        private String name;

        @Column(name = "contact_person")
        private String contactPerson;

        @Column(name = "notes", columnDefinition = "TEXT")
        private String notes;

        @Column(name = "image_url", length = 500)
        private String imageUrl;
}