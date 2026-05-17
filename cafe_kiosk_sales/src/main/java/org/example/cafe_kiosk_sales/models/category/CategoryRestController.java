package org.example.cafe_kiosk_sales.models.category;

import org.example.cafe_kiosk_sales.ResponseCode;
import org.example.cafe_kiosk_sales.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/V1/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDto>> insert(@RequestBody CategoryDto categoryDto) {
        CategoryDto result = this.categoryService.insert(categoryDto);
        ApiResponse<CategoryDto> apiResponse = ApiResponse.<CategoryDto>builder()
                .code(ResponseCode.Success)
                .message("OK").responseData(result).build();
        return ResponseEntity.status(201).body(apiResponse);
    }
}
