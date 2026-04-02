package org.example.petapp.pet.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PetDto implements IPet {
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private LocalDate birth;
    private String imgFile;
}
