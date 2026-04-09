package org.example.cafe_kiosk.models.product;

import org.example.cafe_kiosk.models.category.CategoryDto;
import org.example.cafe_kiosk.models.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDto insert(ProductDto newDto) {
        ProductEntity newEntity = ProductEntity.builder()
                .id(null) //화면에 id 값이 있더라도 null로 해서 확실하게 insert 시킨다.
                .name(newDto.getName())
                .price(newDto.getPrice())
                .category(new CategoryEntity()) // CategoryEntity 객체를 만들어서 Dto로 형변환
                .picture(newDto.getPicture())
                .build();
        newEntity.getCategory().setId(newDto.getCategory().getId());

        ProductEntity save = this.productRepository.save(newEntity);

        ProductDto result = ProductDto.builder()
                .id(save.getId())
                .name(save.getName())
                .price(save.getPrice())
                .category(new CategoryDto()) // => 단순 객체 복사가 아니라 형변환을 해야 한다.
                .picture(save.getPicture())
                .build();
        result.getCategory().setId(save.getCategory().getId());
        result.getCategory().setName(save.getCategory().getName());
        return result;
    }

}
