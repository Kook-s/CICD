package kr.handscope.infra.member.entity;

import jakarta.persistence.*;
import kr.handscope.domain.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private String username;
    private LocalDateTime birth;
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<MeasurementEntity> measurement = new ArrayList<>();

    public MemberEntity(long id, String email, String password, String username, LocalDateTime birth, LocalDateTime at, Role role) {
    }

    public Member toMember(){
        return new Member(id, email, password, username, birth, createAt, role);
    }

    public static MemberEntity fromMember(Member member){
        return new MemberEntity(
                member.id(),
                member.email(),
                member.password(),
                member.username(),
                member.birth(),
                member.createAt(),
                member.role()
                );
    }

    public void updateMember(String password, String username, LocalDateTime birth){
        this.password = password;
        this.username = username;
        this.birth = birth;
    }


}
