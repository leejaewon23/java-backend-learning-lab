package org.example.swimming_pool.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private String code;
    private String message;
    private T responseData;

    public static <T> ApiResponse<T> make(String code, String message, T responseData) {
        return new ApiResponse<>(code, message, responseData);
    }
}
