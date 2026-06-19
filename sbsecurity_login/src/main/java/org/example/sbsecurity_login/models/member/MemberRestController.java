package org.example.sbsecurity_login.models.member;

import org.example.sbsecurity_login.common.ComResponseDto;
import org.example.sbsecurity_login.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	@Autowired
	private MemberService memberService;

	@PostMapping("")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<ComResponseDto<MemberDto>> insert(@RequestBody MemberDto memberDto) {
		MemberDto result = this.memberService.insert(memberDto, true);
		return ResponseEntity.status(201).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@PatchMapping("")
	@PreAuthorize("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#updateDto.id, principal.signId)")
	public ResponseEntity<ComResponseDto<MemberDto>> update(@RequestBody MemberDto updateDto) {
		MemberDto result = this.memberService.update(updateDto);
		return ResponseEntity.status(200).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#id, principal.signId)")
	public ResponseEntity<ComResponseDto<MemberDto>> deleteById(@PathVariable Long id) {
		MemberDto result = this.memberService.deleteById(id);
		return ResponseEntity.status(200).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN') or @memberService.isSignedMemberId(#id, principal.signId)")
	public ResponseEntity<ComResponseDto<MemberDto>> findById(@PathVariable Long id) {
		MemberDto result = this.memberService.findById(id);
		return ResponseEntity.status(200).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("")
	public ResponseEntity<ComResponseDto<List<MemberDto>>> findAll() {
		List<MemberDto> result = this.memberService.findAll();
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}
}
