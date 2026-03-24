package org.example.chapter_20.gamecrud;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class GameDto {
    private Integer id;
    private String name;
    private String genre;
    private String grade;
    private Integer price;
    private String imgUrl;
}

//    id: maxId
//      , name: $("#name").val()
//      , genre: $("#genre").val()
//      , grade: $("#grade").val()
//      , price: $("#price").val() * 1
//            , imgUrl: $("#imgUrl").val()


