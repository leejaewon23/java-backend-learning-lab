package org.example.swimming_pool.teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.swimming_pool.swimpool.SwimPoolEntity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "main", length = 50, nullable = false)
    private String main;

    @Column(nullable = false)
    private Integer birthYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "swim_pool_id", nullable = false)
    @ToString.Exclude
    private SwimPoolEntity swimPool;

    public Long getSwimPoolId() {
        if (this.swimPool == null) {
            return null;
        }
        return this.swimPool.getId();
    }

    public void setSwimPoolId(Long swimPoolId) {
        if (swimPoolId == null) {
            this.swimPool = null;
            return;
        }
        this.swimPool = SwimPoolEntity.builder().id(swimPoolId).build();
    }

    public void update(TeacherDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getMain() != null) {
            this.main = dto.getMain();
        }
        if (dto.getBirthYear() != null) {
            this.birthYear = dto.getBirthYear();
        }
        if (dto.getSwimPoolId() != null) {
            this.setSwimPoolId(dto.getSwimPoolId());
        }
    }

    public static TeacherEntity fromDto(TeacherDto dto) {
        TeacherEntity entity = TeacherEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .main(dto.getMain())
                .birthYear(dto.getBirthYear())
                .build();
        entity.setSwimPoolId(dto.getSwimPoolId());
        return entity;
    }
}
