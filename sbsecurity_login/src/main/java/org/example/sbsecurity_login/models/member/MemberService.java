package org.example.sbsecurity_login.models.member;

import org.example.sbsecurity_login.common.Util;
import org.example.sbsecurity_login.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	public MemberDto insert(MemberDto memberDto, boolean bAdminMode) {
		MemberEntity memberEntity = (MemberEntity)new MemberEntity().clone(memberDto, true);
		memberEntity.setId(null);
		memberEntity.setCreateDt(LocalDateTime.now());
		if ( bAdminMode ) {
			memberEntity.setIsValidEmail(true);
			memberEntity.setRole(Role.USER.toString());
		} else {
			memberEntity.setIsValidEmail(false);
			memberEntity.setRole(Role.GUEST.toString());
			memberEntity.setValidText(Util.getRandomAllString(12));
		}
        memberEntity.setPassword(this.passwordEncoder.encode(memberEntity.getPassword()));
		MemberEntity saved = this.memberJpaRepository.save(memberEntity);
		MemberDto result = (MemberDto)new MemberDto().clone(saved, true);
		return result;
	}

	public MemberDto findById(String id) {
		return this.findById(Long.parseLong(id));
	}

	public MemberDto findById(Long id) {
		MemberEntity findById = this.memberJpaRepository.findById(id)
				.filter(member -> member.getDeleteId() == null && member.getDeleteDt() == null)
				.orElseThrow();
		MemberDto result = (MemberDto)new MemberDto().clone(findById, true);
		return result;
	}

	public MemberDto update(MemberDto updateDto) {
		MemberEntity find = this.memberJpaRepository.findById(updateDto.getId()).orElseThrow();
		MemberEntity memberEntity = (MemberEntity)new MemberEntity().clone(find, true);
		memberEntity.setUpdateDt(LocalDateTime.now());
		memberEntity.clone(updateDto, false);
		MemberEntity saved = this.memberJpaRepository.save(memberEntity);
		MemberDto result = (MemberDto)new MemberDto().clone(saved, true);
		return result;
	}

	public boolean isSignedMemberId(Long memberId, String signId) {
		if ( memberId == null || signId == null ) {
			return false;
		}
		return this.memberJpaRepository.findById(memberId)
				.map(member -> signId.equals(member.getSignId()))
				.orElse(false);
	}

	public MemberDto deleteById(Long id) {
		MemberEntity find = this.memberJpaRepository.findById(id).orElseThrow();
		MemberEntity memberEntity = (MemberEntity)new MemberEntity().clone(find, true);
		memberEntity.setDeleteId(this.getSignedSignId());
		memberEntity.setDeleteDt(LocalDateTime.now());
		MemberEntity saved = this.memberJpaRepository.save(memberEntity);
		MemberDto result = (MemberDto)new MemberDto().clone(saved, true);
		return result;
	}

	public List<MemberDto> findAll() {
		List<MemberEntity> all = this.memberJpaRepository.findAll().stream()
				.filter(member -> member.getDeleteId() == null && member.getDeleteDt() == null)
				.toList();
		List<MemberDto> result = this.transfer(all);
		return result;
	}

	private List<MemberDto> transfer(List<MemberEntity> all) {
		return all.stream()
			.map( x -> (MemberDto)new MemberDto().clone(x, true))
			.toList();
	}

	public MemberDto findBySignId(String signId) {
		Optional<MemberEntity> bySignId = this.memberJpaRepository.findBySignId(signId);
		if ( bySignId.isPresent() ) {
			MemberEntity member = bySignId.get();
			MemberDto result = (MemberDto)new MemberDto().clone(member, true);
			return result;
		} else {
			return null;
		}
	}

	private String getSignedSignId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if ( authentication == null ) {
			return null;
		}
		Object principal = authentication.getPrincipal();
		if ( principal instanceof IMember signedMember ) {
			return signedMember.getSignId();
		}
		return authentication.getName();
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findBySignId(username);
    }
}
