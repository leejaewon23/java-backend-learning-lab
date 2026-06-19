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
}
