package kr.handscope.domain.user.model;

import java.time.LocalDateTime;

public record User(
        long id,
        String email,
        String password,
        String username,
        LocalDateTime birth,
        LocalDateTime createAt
) {
}
