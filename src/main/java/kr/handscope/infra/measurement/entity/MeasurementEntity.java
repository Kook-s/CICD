package kr.handscope.infra.measurement.entity;

import jakarta.persistence.*;
import kr.handscope.infra.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "measurement")
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime measurementAt;
    private Long score;
    private String description;
    private LocalDateTime createAt;
    private String createBy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
