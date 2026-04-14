package org.example.cookies.models.category;

import org.example.cookies.models.common.IdName;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto implements IdName {
	private Long id;
	private String name;
}
