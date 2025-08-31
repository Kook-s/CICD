package kr.handscope.domain.member.model;

import kr.handscope.infra.member.entity.Role;

import java.time.LocalDateTime;

public record Member(
        long id,
        String email,
        String password,
        String username,
        LocalDateTime birth,
        LocalDateTime createAt,
        Role role
) {
}
