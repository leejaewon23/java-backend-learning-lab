package org.example.jwt_security_login.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.example.jwt_security_login.models.member.IMember;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto implements IMember {
	@JsonIgnore
	private Long id;

	private String signId;
	private String password;
	private String email;

	@JsonIgnore
	private String role;

	@JsonIgnore
	private Boolean isValidEmail;

	@JsonIgnore
	private String validText;

	@JsonIgnore
	private LocalDateTime createDt;

	@JsonIgnore
	private LocalDateTime updateDt;

	@JsonIgnore
	private String deleteId;

	@JsonIgnore
	private LocalDateTime deleteDt;
}
