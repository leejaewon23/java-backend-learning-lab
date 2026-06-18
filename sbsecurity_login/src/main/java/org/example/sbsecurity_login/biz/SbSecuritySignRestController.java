package org.example.sbsecurity_login.biz;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.sbsecurity_login.common.ComResponseDto;
import org.example.sbsecurity_login.common.LoginException;
import org.example.sbsecurity_login.common.ResponseCode;
import org.example.sbsecurity_login.models.auth.SignInDto;
import org.example.sbsecurity_login.models.auth.SignUpDto;
import org.example.sbsecurity_login.models.member.IMember;
import org.example.sbsecurity_login.models.member.MemberDto;
import org.example.sbsecurity_login.models.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class SbSecuritySignRestController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

	@PostMapping("/signup")
	public ResponseEntity<ComResponseDto<IMember>> signUp(@RequestBody SignUpDto signUpDto) {
		MemberDto memberDto = (MemberDto)new MemberDto().clone(signUpDto, true);
		MemberDto inserted = this.memberService.insert(memberDto, false);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, inserted)
		);
	}

	@GetMapping("/emailtest/{id}")
	public ResponseEntity<ComResponseDto<MemberDto>> emailTest(@PathVariable String id) {
		MemberDto find = this.memberService.findById(id);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, find)
		);
	}


	@PostMapping("/signin")
	public ResponseEntity<ComResponseDto<Boolean>> signin(@RequestBody SignInDto signInDto
            , HttpSession session) {
        Authentication auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDto.getSignId(), signInDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        session.setAttribute("MJC_LOGIN", signInDto.getSignId());
        session.setMaxInactiveInterval(1200);
        return ResponseEntity.status(200).body(
                ComResponseDto.make(ResponseCode.SUCCESS, true)
        );
	}

	@GetMapping("/signout")
	public ResponseEntity<ComResponseDto<Boolean>> signout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, true)
		);
	}
}
