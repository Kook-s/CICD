package kr.handscope.interfaces.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.handscope.domain.user.model.User;
import kr.handscope.domain.user.service.UserService;
import kr.handscope.interfaces.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto.LoginResponse> login(@RequestBody UserDto.LoginRequest loginUser
                                                     , HttpServletRequest request) {
        User findUser = userService.login(loginUser.email(), loginUser.password());

        return ResponseEntity.ok(UserDto.LoginResponse.of(findUser));
    }

    @GetMapping("/create")
    public void login() {}
}
