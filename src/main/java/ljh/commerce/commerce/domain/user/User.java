package ljh.commerce.commerce.domain.user;

import ljh.commerce.commerce.domain.address.Address;
import ljh.commerce.commerce.domain.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String userName;

    private String password;

    private String email;

    private LocalDateTime createDate;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
}
