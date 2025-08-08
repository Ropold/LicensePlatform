package ropold.backend.model;

import java.time.Instant;

public record UserModel(
        String id,
        String microsoftId,
        String username,
        String email,
        String role,
        String avatarUrl,
        Instant createdAt,
        Instant lastLoginAt
) {}
