package ropold.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

        @Column(name = "name")
        private String name;

        @Column(name = "base_discount_percent", precision = 5, scale = 2)
        private BigDecimal baseDiscountPercent;

        @Column(name = "business_model", length = 50)
        private String businessModel;

        @Column(name = "contact_person")
        private String contactPerson;

        @Column(name = "notes", columnDefinition = "TEXT")
        private String notes;
}