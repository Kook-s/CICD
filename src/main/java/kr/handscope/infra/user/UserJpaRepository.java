package kr.handscope.infra.user;

import io.swagger.v3.oas.annotations.Operation;
import kr.handscope.infra.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
