package org.example.cafe_kiosk_sales.models.category;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDto implements ICategory {
	private Integer id;
	private String name;
}
