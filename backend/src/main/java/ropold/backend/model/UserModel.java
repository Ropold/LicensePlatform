package ropold.backend.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public record UserModel(
        @Id
        @GeneratedValue(generator = "UUID")
        String id,

        @Column(name = "microsoft_id", unique = true, nullable = false)
        String microsoftId,

        @Column(name = "username", nullable = false)
        String username,

        @Column(name = "email", unique = true, nullable = false)
        String email,

        @Column(name = "role", nullable = false)
        String role,

        @Column(name = "avatar_url")
        String avatarUrl,

        @ElementCollection
        @CollectionTable(name = "user_customer_wishlist", joinColumns = @JoinColumn(name = "user_id"))
        @Column(name = "customer_id")
        List<String> favoriteCustomers,

        @Column(name = "created_at", nullable = false)
        Instant createdAt,

        @Column(name = "last_login_at")
        Instant lastLoginAt
) {}