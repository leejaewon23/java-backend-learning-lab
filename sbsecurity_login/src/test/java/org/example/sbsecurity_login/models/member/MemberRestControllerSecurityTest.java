package org.example.sbsecurity_login.models.member;

import org.junit.jupiter.api.Test;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRestControllerSecurityTest {
    @Test
    void insertRequiresAdminOnly() throws NoSuchMethodException {
        Method method = MemberRestController.class.getMethod("insert", MemberDto.class);

        PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);

        assertThat(preAuthorize).isNotNull();
        assertThat(preAuthorize.value()).isEqualTo("hasAuthority('ADMIN')");
    }

    @Test
    void updateAllowsAdminOrSameMemberOnly() throws NoSuchMethodException {
        Method method = MemberRestController.class.getMethod("update", MemberDto.class);

        PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);

        assertThat(preAuthorize).isNotNull();
        assertThat(preAuthorize.value())
                .isEqualTo("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#updateDto.id, principal.signId)");
    }

    @Test
    void deleteAllowsAdminOrSameMemberOnly() throws NoSuchMethodException {
        Method method = MemberRestController.class.getMethod("deleteById", Long.class);

        PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);

        assertThat(preAuthorize).isNotNull();
        assertThat(preAuthorize.value())
                .isEqualTo("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#id, principal.signId)");
    }

    @Test
    void findByIdAllowsAdminOrSameMemberOnly() throws NoSuchMethodException {
        Method method = MemberRestController.class.getMethod("findById", Long.class);

        PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);

        assertThat(preAuthorize).isNotNull();
        assertThat(preAuthorize.value())
                .isEqualTo("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#id, principal.signId)");
    }
}
