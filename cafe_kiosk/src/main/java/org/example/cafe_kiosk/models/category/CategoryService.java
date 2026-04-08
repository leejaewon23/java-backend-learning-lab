package org.example.cafe_kiosk.models.category;

import org.springframework.beans.factory.annotation.Autowired;
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
}
