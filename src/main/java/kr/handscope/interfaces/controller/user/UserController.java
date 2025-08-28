package kr.handscope.interfaces.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.handscope.domain.user.model.User;
import kr.handscope.domain.user.service.UserService;
import kr.handscope.interfaces.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto.LoginRequest request) {
        String token = userService.login(request);

        ResponseCookie cookie = ResponseCookie.from("ACCESS_TOKEN", token)
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(3600)
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie cookie = ResponseCookie.from("ACCESS_TOKEN", "")
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(0)  // 쿠키 즉시 만료
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }


//    @GetMapping("/me")
//    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal User user) {
//        String email = user.email();
//
//        return ResponseEntity.ok();
//    }

}
