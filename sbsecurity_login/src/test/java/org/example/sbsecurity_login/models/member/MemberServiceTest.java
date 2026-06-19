package org.example.sbsecurity_login.models.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberJpaRepository memberJpaRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberService memberService;

    @Test
    void isSignedMemberIdReturnsTrueWhenSignIdOwnsMember() throws Exception {
        Method method = MemberService.class.getMethod("isSignedMemberId", Long.class, String.class);
        MemberEntity member = member(10L, "guest01");
        when(memberJpaRepository.findById(10L)).thenReturn(Optional.of(member));

        Boolean result = (Boolean)method.invoke(memberService, 10L, "guest01");

        assertThat(result).isTrue();
    }

    private MemberEntity member(Long id, String signId) {
        return MemberEntity.builder()
                .id(id)
                .signId(signId)
                .password("encoded-password")
                .email(signId + "@example.com")
                .role("USER")
                .isValidEmail(true)
                .createDt(LocalDateTime.now())
                .build();
    }
}
