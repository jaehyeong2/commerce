package ljh.commerce.commerce.domain.order;

import ljh.commerce.commerce.domain.user.User;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
