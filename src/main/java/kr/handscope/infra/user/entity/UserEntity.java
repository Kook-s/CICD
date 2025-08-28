package kr.handscope.infra.user.entity;

import jakarta.persistence.*;
import kr.handscope.domain.user.model.User;
import kr.handscope.infra.measurement.entity.MeasurementEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String password;
    private String username;
    private LocalDateTime birth;
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<MeasurementEntity> measurement = new ArrayList<>();

    public UserEntity(long id, String email, String password, String username, LocalDateTime birth, LocalDateTime at) {
    }

    public User toUser(){
        return new User(id, email, password, username, birth, createAt);
    }

    public static UserEntity fromUser(User user){
        return new UserEntity(
                user.id(),
                user.email(),
                user.password(),
                user.username(),
                user.birth(),
                user.createAt()
                );
    }

    public void updateUser(String password, String username, LocalDateTime birth){
        this.password = password;
        this.username = username;
        this.birth = birth;
    }


}
