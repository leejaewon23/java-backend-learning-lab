package org.example.petapp.pet.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet_tbl")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String species;

    @Column(length = 100, nullable = false)
    private String breed;

    @Column(length = 1, nullable = false)
    private String gender;

    @Column
    private LocalDate birth;

    @Column(name = "img_file", length = 500, nullable = false)
    private String imgFile;
}
