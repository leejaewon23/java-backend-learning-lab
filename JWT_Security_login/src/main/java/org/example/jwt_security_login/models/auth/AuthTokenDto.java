package org.example.jwt_security_login.models.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class AuthTokenDto {
    private String accessToken;
    private String refreshToken;
}
