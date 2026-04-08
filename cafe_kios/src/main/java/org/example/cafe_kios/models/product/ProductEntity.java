package org.example.cafe_kios.models.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.cafe_kios.models.category.CategoryEntity;
import org.example.cafe_kios.models.category.ICategory;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "product")
public class ProductEntity implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Transient // JPA 에 영향을 미치지 않는 멤버변수
    private Integer categoryId;

    @JoinColumn(name="category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity categoryObj;  // 참조테이블의 외래키는 마스터테이블의 Entity 클래스

    @Column(length=500, nullable = true)
    private String picture;

    @Override
    public Integer getCategoryId() {
        if ( this.categoryObj == null ) {
            // Dto 와 Entity 형 변환시에 Integer <=> 객체
            this.categoryObj = new CategoryEntity();
        }
        return this.categoryObj.getId();
    }

    @Override
    public void setCategoryId(Integer categoryId) {
        if ( this.categoryObj == null ) {
            // Dto 와 Entity 형 변환시에 Integer <=> 객체
            this.categoryObj = new CategoryEntity();
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
            this.categoryObj = new CategoryEntity();
        }
        this.categoryObj.copyMembers(categoryObj);
    }
}
