package org.example.cafe_kiosk.models.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto insert(CategoryDto categoryDto) {
        CategoryEntity newData = new CategoryEntity();
        newData.setName(categoryDto.getName());
        newData.setId(categoryDto.getId());

        CategoryEntity resEntity = this.categoryRepository.save(newData);

        CategoryDto result = new CategoryDto();
        result.setId(resEntity.getId());
        result.setName(resEntity.getName());
        return result;
    }

    public CategoryDto update(CategoryDto categoryDto) {
        CategoryEntity newData = new CategoryEntity();
        newData.setId(categoryDto.getId());
        newData.setName(categoryDto.getName());
        CategoryEntity resEntity = this.categoryRepository.save(newData);
        CategoryDto result = new CategoryDto();
        result.setId(resEntity.getId());
        result.setName(resEntity.getName());
        return result;
    }

    public CategoryDto deleteById(Integer id) {
        CategoryEntity resEntity = this.categoryRepository.findById(id).orElseThrow();
        CategoryDto result = new CategoryDto();
        result.setId(resEntity.getId());
        result.setName(resEntity.getName());
        this.categoryRepository.deleteById(id);
        return result;
    }

    public CategoryDto findById(Integer id) {
        CategoryEntity resEntity = this.categoryRepository.findById(id).orElseThrow();
        CategoryDto result = new CategoryDto();
        result.setId(resEntity.getId());
        result.setName(resEntity.getName());
        this.categoryRepository.findById(id);
        return result;
    }

    public Slice<CategoryDto> findByNameContains(String name, Pageable pageable) {
        Slice<CategoryEntity> list = this.categoryRepository.findByNameContains(name, pageable);
        return list.map(category -> {
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            return dto;
        });
    }
}
