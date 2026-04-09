package org.example.cafe_kiosk.models.category;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto implements ICategory {
    private Integer id;
    private String name;
}
