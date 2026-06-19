package org.example.jwt_security_login.conf;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
		Object signObj = session.getAttribute("MJC_LOGIN");
		if ( signObj instanceof String signId) {
			MemberDto find = this.memberService.findBySignId(signId);
			if ( find != null ) {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
						find, null, find.getAuthorities()
				);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
        filterChain.doFilter(request, response);

    }
}
