package org.example.cafe_kios.models.product;

import lombok.RequiredArgsConstructor;
import org.example.cafe_kios.ResponseCode;
import org.example.cafe_kios.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/product")
public class ProductRestController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> update(@RequestBody ProductDto newDto) {
        ProductDto result = this.productService.insert(newDto);
        ApiResponse<ProductDto> apiResponse = ApiResponse.<ProductDto>builder()
                .code(ResponseCode.Success)
                .message("OK")
                .responseData(result).build();
        return ResponseEntity.status(201).body(apiResponse);
    }
}
