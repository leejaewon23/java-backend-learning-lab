package org.example.swimming_pool.swimpool;

import lombok.RequiredArgsConstructor;
import org.example.swimming_pool.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/swim-pools")
public class SwimPoolRestController {
    private final SwimPoolService swimPoolService;

    @PostMapping
    public ResponseEntity<ApiResponse<SwimPoolDto>> insert(@RequestBody SwimPoolDto insertDto) {
        SwimPoolDto result = this.swimPoolService.insert(insertDto);
        return ResponseEntity.status(201).body(ApiResponse.make("insert_ok", "ok", result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SwimPoolDto>>> findAll() {
        List<SwimPoolDto> result = this.swimPoolService.findAll();
        return ResponseEntity.ok(ApiResponse.make("select_ok", "ok", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> findById(@PathVariable Long id) {
        SwimPoolDto result = this.swimPoolService.findById(id);
        return ResponseEntity.ok(ApiResponse.make("select_ok", "ok", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> update(@PathVariable Long id, @RequestBody SwimPoolDto updateDto) {
        SwimPoolDto result = this.swimPoolService.update(id, updateDto);
        return ResponseEntity.ok(ApiResponse.make("update_ok", "ok", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SwimPoolDto>> deleteById(@PathVariable Long id) {
        SwimPoolDto result = this.swimPoolService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.make("delete_ok", "ok", result));
    }
}
