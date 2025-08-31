package kr.handscope.infra.member.impl;

import kr.handscope.domain.member.model.Member;
import kr.handscope.domain.member.repository.MemberRepository;
import kr.handscope.infra.member.MemberJpaRepository;
import kr.handscope.infra.member.entity.MemberEntity;
import kr.handscope.support.code.CoreException;
import kr.handscope.support.code.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository userJpaRepository;

    //유저 조회
    @Override
    public Member findById(long id) {
        return userJpaRepository.findById(id).map(MemberEntity::toMember)
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));
    }

    @Override
    public Member findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(MemberEntity::toMember)
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));
    }

    //비번 조회
    @Override
    public Member findByPassword(String password) {
        return null;
    }

    //회원 가입
    @Override
    public Long createUser(Member member) {
        MemberEntity createUser = userJpaRepository.save(MemberEntity.fromMember(member));
        return createUser.getId();
    }

    //회원 정보 수정
    @Override
    public void updateUser(Member member) {
        MemberEntity findUser = userJpaRepository.findByEmail(member.email())
                .orElseThrow(() -> new CoreException(ErrorType.MISSING_USER));

        findUser.updateMember(member.email(), member.password(), member.birth());

    }
}
