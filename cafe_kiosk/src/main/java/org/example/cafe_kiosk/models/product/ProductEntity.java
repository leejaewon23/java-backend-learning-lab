package org.example.cafe_kiosk.models.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.cafe_kiosk.models.category.CategoryDto;
import org.example.cafe_kiosk.models.category.CategoryEntity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private CategoryEntity category;

    @Column(length = 500, nullable = true)
    private String picture;
}
