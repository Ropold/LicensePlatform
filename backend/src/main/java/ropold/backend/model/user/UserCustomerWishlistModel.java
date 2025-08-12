package ropold.backend.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ropold.backend.model.customer.CustomerModel;

@Entity
@Table(name = "user_customer_wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCustomerWishlistModel {

    @EmbeddedId
    private UserCustomerWishlistId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;
}