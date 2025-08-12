package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.user.UserModel;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
