package org.example.jwt_security_login.conf;


import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.jwt_security_login.jwt.JWTUtils;
import org.example.jwt_security_login.jwt.JwtExpireException;
import org.example.jwt_security_login.jwt.JwtIllegalException;
import org.example.jwt_security_login.models.member.MemberDto;
import org.example.jwt_security_login.models.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LJWAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private MemberService memberService;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        try {
            String jwtAccessToken = this.jwtUtils.resolveJwtTokenFromBearerToken(authHeader);
            if ( jwtAccessToken != null ) {
                String signId = this.jwtUtils.getSignId(jwtAccessToken);
                MemberDto find = this.memberService.findBySignId(signId);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        find, null, find.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (JwtExpireException | JwtIllegalException | JwtException e) {
        }
        filterChain.doFilter(request, response);
    }
}

