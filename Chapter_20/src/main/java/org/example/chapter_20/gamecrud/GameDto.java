package org.example.chapter_20.gamecrud;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private Integer id;
    private String name;
    private String genre;
    private String grade;
    private Integer price;
    private String imgUrl;
}


