package kr.handscope.domain.member.repository;

import kr.handscope.domain.member.model.Member;

public interface MemberRepository {

    Member findById(long id);
    Member findByEmail(String email);
    Member findByPassword(String password);
    Long createUser(Member member);
    void updateUser(Member member);
}
