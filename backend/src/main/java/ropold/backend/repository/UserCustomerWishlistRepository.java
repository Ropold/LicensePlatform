package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.user.UserCustomerWishlistId;
import ropold.backend.model.user.UserCustomerWishlistModel;

public interface UserCustomerWishlistRepository extends JpaRepository<UserCustomerWishlistModel, UserCustomerWishlistId> {
}