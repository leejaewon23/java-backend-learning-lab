package org.example.cafe_kiosk.models.product;

import lombok.*;

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
    private Integer categoryId;
    private String picture;
}
