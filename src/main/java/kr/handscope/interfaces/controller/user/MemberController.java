package kr.handscope.interfaces.controller.user;

import kr.handscope.domain.member.service.MemberService;
import kr.handscope.interfaces.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody MemberDto.LoginRequest request) {
        String token = memberService.login(request);

        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {

        return ResponseEntity.ok()
                .build();
    }


//    @GetMapping("/me")
//    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal User user) {
//        String email = user.email();
//
//        return ResponseEntity.ok();
//    }

}
