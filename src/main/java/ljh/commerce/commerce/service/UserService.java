package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.user.User;
import ljh.commerce.commerce.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User join(User user) {
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
