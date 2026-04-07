package org.example.cafe_kios.models.category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto implements IdName {
	private Integer id;
	private String name;
}
