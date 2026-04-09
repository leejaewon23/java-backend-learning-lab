package org.example.cafe_kiosk.models.product;

import lombok.*;
import org.example.cafe_kiosk.models.category.CategoryDto;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private CategoryDto category;
    private String picture;
}
