package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.user.UserCustomerWishlistModel;

import java.util.UUID;

public interface UserCustomerWishlistRepository extends JpaRepository<UserCustomerWishlistModel, UUID> {
}
