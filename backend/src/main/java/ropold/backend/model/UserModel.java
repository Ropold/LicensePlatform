package ropold.backend.model;

import java.time.Instant;
import java.util.List;

public record UserModel(
        String id,
        String microsoftId,
        String username,
        String email,
        String role,
        String avatarUrl,
        List<String> favoriteCustomers,
        Instant createdAt,
        Instant lastLoginAt
) {}
