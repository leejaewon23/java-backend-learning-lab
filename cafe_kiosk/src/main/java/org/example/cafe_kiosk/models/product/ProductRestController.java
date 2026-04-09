package org.example.cafe_kiosk.models.product;

import org.example.cafe_kiosk.common.ApiResponse;
import org.example.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/prd")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> insert(@RequestBody ProductDto newDto) {
        ProductDto result = this.productService.insert(newDto);
        return ResponseEntity.status(201).body(
                ApiResponse.make(CafeResponse.select_success, "ok", result)
        );
    }

}
