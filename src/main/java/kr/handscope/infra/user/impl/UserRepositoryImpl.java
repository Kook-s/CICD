package kr.handscope.infra.user.impl;

import kr.handscope.domain.user.model.User;
import kr.handscope.domain.user.repository.UserRepository;
import kr.handscope.infra.user.UserJpaRepository;
import kr.handscope.infra.user.entity.UserEntity;
import kr.handscope.support.code.CoreException;
import kr.handscope.support.code.ErrorCode;
import kr.handscope.support.code.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    //유저 조회
    @Override
    public User findById(long id) {
        return userJpaRepository.findById(id).map(UserEntity::toUser)
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));
    }

    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(UserEntity::toUser)
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));
    }

    //비번 조회
    @Override
    public User findByPassword(String password) {
        return null;
    }

    //회원 가입
    @Override
    public Long createUser(User user) {
        UserEntity createUser = userJpaRepository.save(UserEntity.fromUser(user));
        return createUser.getId();
    }

    //회원 정보 수정
    @Override
    public void updateUser(User user) {
        UserEntity findUser = userJpaRepository.findByEmail(user.email())
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));

        findUser.updateUser(user.email(), user.password(), user.birth());

    }
}
