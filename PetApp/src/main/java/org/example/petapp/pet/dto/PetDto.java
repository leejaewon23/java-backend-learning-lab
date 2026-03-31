package org.example.petapp.pet.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private LocalDate birth;
    private String imgFile;
}
