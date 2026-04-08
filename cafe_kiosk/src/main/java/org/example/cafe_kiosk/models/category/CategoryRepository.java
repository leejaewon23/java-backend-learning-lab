package org.example.cafe_kiosk.models.category;

import jakarta.persistence.Id;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Slice<CategoryEntity> findByNameContains(String name, Pageable pageable);

}
