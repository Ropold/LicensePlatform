package ropold.backend.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.customer.CustomerModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_customer_wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserCustomerWishlistModel.UserCustomerWishlistId.class)
public class UserCustomerWishlistModel {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCustomerWishlistId implements Serializable {
        private UUID user;
        private UUID customer;
    }
}