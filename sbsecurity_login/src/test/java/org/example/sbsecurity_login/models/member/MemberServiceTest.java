package org.example.sbsecurity_login.models.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.junit.jupiter.api.AfterEach;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    private MemberJpaRepository memberJpaRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberService memberService;

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void isSignedMemberIdReturnsTrueWhenSignIdOwnsMember() throws Exception {
        Method method = MemberService.class.getMethod("isSignedMemberId", Long.class, String.class);
        MemberEntity member = member(10L, "guest01");
        when(memberJpaRepository.findById(10L)).thenReturn(Optional.of(member));

        Boolean result = (Boolean)method.invoke(memberService, 10L, "guest01");

        assertThat(result).isTrue();
    }

    @Test
    void deleteByIdSetsDeleteFieldsWithoutDeletingRow() throws Exception {
        Method method = MemberService.class.getMethod("deleteById", Long.class);
        MemberEntity member = member(10L, "guest01");
        MemberDto signedMember = MemberDto.builder()
                .id(99L)
                .signId("admin01")
                .role("ADMIN")
                .build();
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(signedMember, null, signedMember.getAuthorities())
        );
        when(memberJpaRepository.findById(10L)).thenReturn(Optional.of(member));
        when(memberJpaRepository.save(any(MemberEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Object result = method.invoke(memberService, 10L);

        verify(memberJpaRepository, never()).deleteById(anyLong());
        Method getDeleteId = MemberDto.class.getMethod("getDeleteId");
        Method getDeleteDt = MemberDto.class.getMethod("getDeleteDt");
        assertThat(getDeleteId.invoke(result)).isEqualTo("admin01");
        assertThat(getDeleteDt.invoke(result)).isNotNull();
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
