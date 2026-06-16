package org.example.session_login.biz;

import org.example.session_login.common.LoginException;
import org.example.session_login.models.auth.SignInDto;
import org.example.session_login.models.auth.ValidEmailDto;
import org.example.session_login.models.member.MemberEntity;
import org.example.session_login.models.member.MemberJpaRepository;
import org.example.session_login.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

	public Boolean checkValidEmail(ValidEmailDto validEmailDto) {
		MemberEntity find = this.memberJpaRepository.findBySignId(validEmailDto.getSignId()).orElseThrow();
		if ( validEmailDto.getValidText().equals(find.getValidText()) ) {
			find.setIsValidEmail(true);
			find.setRole(Role.USER.toString());
			this.memberJpaRepository.save(find);
			return true;
		} else {
			return false;
		}
	}

	public Boolean signMember(SignInDto signInDto) throws LoginException {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
		if ( !find.getIsValidEmail() ) {
			throw new LoginException("not valid email");
		}
		if ( find.getRole().equals(Role.GUEST.toString()) ) {
			throw new LoginException("doesn't need login");
		}
		if ( signInDto.getPassword().equals(find.getPassword()) ) {
			return true;
		}
		return false;
	}
}
