package org.example.login_cookie.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComResponseDto {
    private Integer code;
    private String message;
    private Object data;

    public static ComResponseDto make(Integer code, String message, Object data) {
        return new ComResponseDto(code, message, data);
    }
}
