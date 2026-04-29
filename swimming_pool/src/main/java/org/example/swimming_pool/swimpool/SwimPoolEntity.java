package org.example.swimming_pool.swimpool;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "swim_pool")
public class SwimPoolEntity {
    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String tel;

    @Column(length = 200, nullable = false)
    private String addr1;

    @Column(length = 200)
    private String addr2;

    @Column(length = 100, nullable = false)
    private String lanes;

    @Column(length = 50, nullable = false)
    private String size;

    public void update(SwimPoolDto dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getTel() != null) {
            this.tel = dto.getTel();
        }
        if (dto.getAddr1() != null) {
            this.addr1 = dto.getAddr1();
        }
        if (dto.getAddr2() != null) {
            this.addr2 = dto.getAddr2();
        }
        if (dto.getLanes() != null) {
            this.lanes = dto.getLanes();
        }
        if (dto.getSize() != null) {
            this.size = dto.getSize();
        }
    }

    public static SwimPoolEntity fromDto(SwimPoolDto dto) {
        return SwimPoolEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .tel(dto.getTel())
                .addr1(dto.getAddr1())
                .addr2(dto.getAddr2())
                .lanes(dto.getLanes())
                .size(dto.getSize())
                .build();
    }
}
