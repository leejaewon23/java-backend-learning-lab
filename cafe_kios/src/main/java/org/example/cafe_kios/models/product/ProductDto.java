package org.example.cafe_kios.models.product;

import lombok.*;
import org.example.cafe_kios.models.category.CategoryDto;
import org.example.cafe_kios.models.category.ICategory;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto implements IProduct {
    private Integer id;
    private String name;
    private Integer price;
    private Integer categoryId;
    private CategoryDto categoryObj;
    private String picture;

    @Override
    public Integer getCategoryId() {
        if ( this.categoryObj != null ) {
            // Dto 와 Entity 형 변환시에 Integer <=> 객체
            return this.categoryObj.getId();
        }
        return this.categoryId;
    }

    @Override
    public void setCategoryId(Integer categoryId) {
        if ( this.categoryObj == null ) {
            // Dto 와 Entity 형 변환시에 Integer <=> 객체
            this.categoryObj = new CategoryDto();
        }
        this.categoryObj.setId(categoryId);
        this.categoryId = categoryId;
    }

    @Override
    public void setCategoryObj(ICategory categoryObj) {
        if ( categoryObj == null ) {
            return;
        }
        if ( this.categoryObj == null ) {
            // Dto 와 Entity 형 변환시에 Integer <=> 객체
            this.categoryObj = new CategoryDto();
        }
        this.categoryObj.copyMembers(categoryObj);
    }
}
