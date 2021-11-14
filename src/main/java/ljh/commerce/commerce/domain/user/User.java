package ljh.commerce.commerce.domain.user;
import ljh.commerce.commerce.domain.order.Order;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, length = 20)
    private String username; //아이디

    private String realName; // 이름

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    private String role; //USER,ADMIN

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
