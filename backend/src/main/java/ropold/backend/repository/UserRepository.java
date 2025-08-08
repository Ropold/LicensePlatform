package ropold.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ropold.backend.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,String> {
}
