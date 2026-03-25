package org.example.chapter_20.userscrud;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer userid;
    private String username;
    private String userpassword;
    private Integer userage;
    private String useremail;

}
