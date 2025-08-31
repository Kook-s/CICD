package kr.handscope.interfaces.dto;

import kr.handscope.domain.member.model.Member;
import lombok.Builder;

public class MemberDto {

    public record LoginRequest(String email, String password) {}

    @Builder
    public record LoginResponse(String email) {
        public static LoginResponse of(Member member) {
            return LoginResponse.builder()
                    .email(member.email())
                    .build();
        }
    }


}
