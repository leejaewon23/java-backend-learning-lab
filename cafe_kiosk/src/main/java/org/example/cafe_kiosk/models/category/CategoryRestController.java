package org.example.cafe_kiosk.models.category;

import org.example.cafe_kiosk.common.ApiResponse;
import org.example.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cat")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDto>> insert(@RequestBody CategoryDto data) {
        CategoryDto result = this.categoryService.insert(data);
        return ResponseEntity.status(201).body(
                ApiResponse.make(CafeResponse.insert_success, "ok", result));


    }

}
