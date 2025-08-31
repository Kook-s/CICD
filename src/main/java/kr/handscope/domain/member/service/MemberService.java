package kr.handscope.domain.member.service;

import kr.handscope.domain.member.model.Member;
import kr.handscope.domain.member.repository.MemberRepository;
import kr.handscope.interfaces.dto.MemberDto;
import kr.handscope.support.jwt.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    @Transactional
    public String login(MemberDto.LoginRequest request) {
        Member findMember = memberRepository.findByEmail(request.email());

//        if (!passwordEncoder.matches(request.password(), findUser.password())) {
//            throw new CoreException(ErrorType.MISSING_USER);
//        }

        return jwtTokenUtil.createToken(findMember);
    }

//    @Transactional
//    public
}
