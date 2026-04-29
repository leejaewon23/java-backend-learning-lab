package org.example.swimming_pool.teacher;

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
@RequestMapping("/api/v1/teachers")
public class TeacherRestController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherDto>> insert(@RequestBody TeacherDto insertDto) {
        TeacherDto result = this.teacherService.insert(insertDto);
        return ResponseEntity.status(201).body(ApiResponse.make("insert_ok", "ok", result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherDto>>> findAll() {
        List<TeacherDto> result = this.teacherService.findAll();
        return ResponseEntity.ok(ApiResponse.make("select_ok", "ok", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> findById(@PathVariable Long id) {
        TeacherDto result = this.teacherService.findById(id);
        return ResponseEntity.ok(ApiResponse.make("select_ok", "ok", result));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> update(@PathVariable Long id, @RequestBody TeacherDto updateDto) {
        TeacherDto result = this.teacherService.update(id, updateDto);
        return ResponseEntity.ok(ApiResponse.make("update_ok", "ok", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherDto>> deleteById(@PathVariable Long id) {
        TeacherDto result = this.teacherService.deleteById(id);
        return ResponseEntity.ok(ApiResponse.make("delete_ok", "ok", result));
    }
}
