package org.example.login_cookie.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComResponseDto<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ComResponseDto<T> make(ResponseCode resCode, T data) {
        return new ComResponseDto<T>(resCode.getCode(), resCode.name(), data);
    }
}
