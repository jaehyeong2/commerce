package ljh.commerce.commerce.domain.delivery;

import ljh.commerce.commerce.domain.address.Address;
import ljh.commerce.commerce.domain.order.Order;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name= "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;


}
