package org.example.jwt_security_login.biz;

import org.example.jwt_security_login.common.LoginException;
import org.example.jwt_security_login.models.auth.SignInDto;
import org.example.jwt_security_login.models.member.MemberEntity;
import org.example.jwt_security_login.models.member.MemberJpaRepository;
import org.example.jwt_security_login.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberJpaRepository memberJpaRepository;

	public Boolean signMember(SignInDto signInDto) throws LoginException {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
		if ( !find.getIsValidEmail() ) {
			throw new LoginException("not valid email");
		}
		if ( find.getRole().equals(Role.GUEST.toString()) ) {
			throw new LoginException("doesn't need login");
		}
		if ( this.passwordEncoder.matches(signInDto.getPassword(), find.getPassword()) ) {
			return true;
		}
		return false;
	}
}
