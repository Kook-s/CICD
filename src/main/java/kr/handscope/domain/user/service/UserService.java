package kr.handscope.domain.user.service;

import kr.handscope.domain.user.model.User;
import kr.handscope.domain.user.repository.UserRepository;
import kr.handscope.interfaces.dto.UserDto;
import kr.handscope.support.code.CoreException;
import kr.handscope.support.code.ErrorType;
import kr.handscope.support.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String login(UserDto.LoginRequest request) {
        User findUser = userRepository.findByEmail(request.email());

//        if (!passwordEncoder.matches(request.password(), findUser.password())) {
//            throw new CoreException(ErrorType.MISSING_USER);
//        }

        return jwtTokenProvider.createToken(findUser.email());
    }

//    @Transactional
//    public
}
