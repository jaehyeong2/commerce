package ljh.commerce.commerce.domain.user;

import ljh.commerce.commerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
