package kr.handscope.interfaces.dto;

import kr.handscope.domain.user.model.User;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDto {

    public record LoginRequest(String email, String password) {}

    @Builder
    public record LoginResponse(String email) {
        public static LoginResponse of(User user) {
            return LoginResponse.builder()
                    .email(user.email())
                    .build();
        }
    }


}
