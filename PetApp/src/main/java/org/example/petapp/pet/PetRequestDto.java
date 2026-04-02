package org.example.petapp.pet;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PetRequestDto {
    private Integer rowCount;
    private String searchName;
}
