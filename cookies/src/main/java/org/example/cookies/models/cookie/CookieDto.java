package org.example.cookies.models.cookie;

import org.example.cookies.models.common.IdName;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookieDto implements IdName {
	private Long id;
	private String name;
}
