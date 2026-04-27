package org.example.cookies.models.attach;

import org.example.cookies.models.common.IdName;
import lombok.*;
import org.example.cookies.models.cookie.CookieDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttachDto implements AttachInterface {
	private Long id;
	private String fileName;
	private Integer size;
	private String ext;
	private String storeName;
	private String path;
	private Long cookieId;
	private CookieDto cookie;

	@Override
	public Long getCookieId() {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		if ( this.cookie == null ) {
			this.cookie = new CookieDto();
		}
		this.cookie.setId(this.cookieId);
		return this.cookie.getId();
	}

	@Override
	public void setCookieId(Long cookieId) {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		if ( this.cookie == null ) {
			this.cookie = new CookieDto();
		}
		this.cookie.setId(cookieId);
		this.cookieId = cookieId;
	}

	@Override
	public void setCookie(IdName cookie) {
		// Long cookieId 랑 cookie.getId() 랑 값이 항상 같도록 해야 한다.
		if ( cookie == null ) {
			return;
		}
		if ( this.cookie == null ) {
			this.cookie = new CookieDto();
		}
		this.cookie.copyMembers(cookie, true);
		this.cookieId = cookie.getId();
	}
}
