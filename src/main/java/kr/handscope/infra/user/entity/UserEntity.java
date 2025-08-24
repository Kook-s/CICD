package kr.handscope.infra.user.entity;

import jakarta.persistence.*;
import kr.handscope.infra.measurement.entity.MeasurementEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<MeasurementEntity> measurement = new ArrayList<>();

}
