package ljh.commerce.commerce.service;

import ljh.commerce.commerce.domain.user.User;
import ljh.commerce.commerce.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User join(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        user.setPassword(encPassword);
        user.setRole("Role_USER");
        User userEntity = userRepository.save(user);
        return userEntity;
    }
}
