package org.example.login_cookie.biz;

import org.example.login_cookie.common.ComResponseDto;
import org.example.login_cookie.common.ResponseCode;
import org.example.login_cookie.models.auth.SignUpDto;
import org.example.login_cookie.models.member.MemberDto;
import org.example.login_cookie.models.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class CookieSignRestController {
	@Autowired
	private MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<ComResponseDto<SignUpDto>> signUp(@RequestBody SignUpDto signUpDto) {
		MemberDto memberDto = (MemberDto)new MemberDto().clone(signUpDto, true);
		this.memberService.insert(memberDto);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, signUpDto)
		);
	}

}
