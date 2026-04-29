package org.example.swimming_pool.swimpool;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimPoolDto {
    private Long id;
    private String name;
    private String tel;
    private String addr1;
    private String addr2;
    private String lanes;
    private String size;

    public static SwimPoolDto fromEntity(SwimPoolEntity entity) {
        return SwimPoolDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .tel(entity.getTel())
                .addr1(entity.getAddr1())
                .addr2(entity.getAddr2())
                .lanes(entity.getLanes())
                .size(entity.getSize())
                .build();
    }
}
