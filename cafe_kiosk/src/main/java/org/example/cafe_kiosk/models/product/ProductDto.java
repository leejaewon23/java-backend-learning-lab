package org.example.cafe_kiosk.models.product;

import lombok.*;
import org.example.cafe_kiosk.models.category.CategoryDto;
import org.example.cafe_kiosk.models.category.ICategory;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto implements IProduct{
    private Integer id;
    private String name;
    private Integer price;
    private CategoryDto category = new CategoryDto();
    private String picture;

    @Override
    public void setCategory(ICategory category) {
        this.category.copyMembers(category, true);
    }
}
