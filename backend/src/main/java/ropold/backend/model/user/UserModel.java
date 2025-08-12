package ropold.backend.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "microsoft_id", unique = true, nullable = false)
        private String microsoftId;

        @Column(name = "username", nullable = false)
        private String username;

        @Column(name = "email", unique = true, nullable = false)
        private String email;

        @Column(name = "role", nullable = false, length = 50)
        private String role;

        @Column(name = "avatar_url")
        private String avatarUrl;

        @ElementCollection
        @CollectionTable(name = "user_customer_wishlist", joinColumns = @JoinColumn(name = "user_id"))
        @Column(name = "customer_id")
        private List<UUID> favoriteCustomers;

        @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
        private LocalDateTime createdAt;

        @Column(name = "last_login_at", columnDefinition = "DATETIME2")
        private LocalDateTime lastLoginAt;
}