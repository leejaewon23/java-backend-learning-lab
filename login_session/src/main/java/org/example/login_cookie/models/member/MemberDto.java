package org.example.login_cookie.models.member;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto implements IMember {
    private Long id;
    private String signId;
    private String password;
    private String email;
    private String role;
    private Boolean isValidEmail;
    private String validText;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private LocalDateTime deleteDt;
}
