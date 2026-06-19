package org.example.sbsecurity_login.models.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IMemberTest {
    @Test
    void getUsernameReturnsSignId() {
        MemberDto member = MemberDto.builder()
                .signId("guest01")
                .build();

        assertThat(member.getUsername()).isEqualTo("guest01");
    }
}
