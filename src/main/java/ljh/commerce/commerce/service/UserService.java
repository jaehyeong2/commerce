package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.user.User;
import ljh.commerce.commerce.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User join(User user) {
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
