package org.example.swimming_pool.teacher;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    private Long id;
    private String name;
    private String main;
    private Integer birthYear;
    private Long swimPoolId;

    public static TeacherDto fromEntity(TeacherEntity entity) {
        return TeacherDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .main(entity.getMain())
                .birthYear(entity.getBirthYear())
                .swimPoolId(entity.getSwimPoolId())
                .build();
    }
}
