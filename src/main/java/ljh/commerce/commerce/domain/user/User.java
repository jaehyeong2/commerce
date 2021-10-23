package ljh.commerce.commerce.domain.user;

import ljh.commerce.commerce.domain.order.Order;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String userName;

    private String password;

    private String email;

    private LocalDateTime createDate;

    @OneToMany
    private List<Order> orderList;
}
