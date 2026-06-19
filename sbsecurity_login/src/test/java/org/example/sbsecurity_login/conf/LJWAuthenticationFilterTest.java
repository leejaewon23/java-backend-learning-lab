package org.example.sbsecurity_login.conf;

import jakarta.servlet.ServletException;
import org.example.sbsecurity_login.models.member.MemberDto;
import org.example.sbsecurity_login.models.member.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LJWAuthenticationFilterTest {
    @Mock
    private MemberService memberService;

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void loadsSessionLoginMemberBySignId() throws ServletException, IOException {
        LJWAuthenticationFilter filter = new LJWAuthenticationFilter();
        ReflectionTestUtils.setField(filter, "memberService", memberService);
        MemberDto member = MemberDto.builder()
                .id(1L)
                .signId("guest01")
                .role("USER")
                .build();
        when(memberService.findBySignId("guest01")).thenReturn(member);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.getSession().setAttribute("MJC_LOGIN", "guest01");

        filter.doFilter(request, new MockHttpServletResponse(), new MockFilterChain());

        verify(memberService).findBySignId("guest01");
        assertThat(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).isSameAs(member);
    }
}
