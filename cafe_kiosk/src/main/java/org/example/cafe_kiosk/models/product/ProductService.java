package org.example.cafe_kiosk.models.product;

import org.example.cafe_kiosk.models.category.CategoryDto;
import org.example.cafe_kiosk.models.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDto insert(ProductDto newDto) {
        ProductEntity newEntity = (ProductEntity) new ProductEntity().copyMembers(newDto, true);
        newEntity.setId(null);

        ProductEntity save = this.productRepository.save(newEntity);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save, true);
        return result;
    }

    public ProductDto update(ProductDto updateDto) {
        ProductEntity findEntity = this.productRepository.findById(updateDto.getId()).orElseThrow();
        ProductEntity data = (ProductEntity) new ProductEntity().copyMembers(findEntity, true);
        data.copyMembers(updateDto, false);

        ProductEntity save = this.productRepository.save(data);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save, true);
        return result;
    }

    public ProductDto deleteById(Integer id) {
        ProductDto find = this.findById(id);
        this.productRepository.deleteById(id);
        return find;
    }

    public ProductDto findById(Integer id) {
        ProductEntity find = this.productRepository.findById(id).orElseThrow();
        ProductDto result = (ProductDto) new ProductDto().copyMembers(find, true);
        return result;
    }

    public Slice<ProductDto> findByNameContains(String name, Pageable pageable) {
         Slice<ProductEntity> list = this.productRepository.findByNameContains(name, pageable);
        return list.map(category -> {
            ProductDto dto = new ProductDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dto.setCategory(category.getCategory());
            dto.setPrice(category.getPrice());
            dto.setPicture(category.getPicture());
            return dto;
        });
    }

}
