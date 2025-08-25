package kr.handscope.domain.user.service;

import kr.handscope.domain.user.model.User;
import kr.handscope.domain.user.repository.UserRepository;
import kr.handscope.support.code.CoreException;
import kr.handscope.support.code.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User login(String email, String password) {
        User findUser = userRepository.findByEmail(email);

        if (!passwordEncoder.matches(password, findUser.password())) {
            throw new CoreException(ErrorType.MISSING_USER);
        }

        return findUser;
    }
}
