package org.example.swimming_pool.teacher;

import lombok.RequiredArgsConstructor;
import org.example.swimming_pool.swimpool.SwimPoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final SwimPoolRepository swimPoolRepository;

    public TeacherDto insert(TeacherDto insertDto) {
        checkSwimPool(insertDto.getSwimPoolId());
        TeacherEntity saved = this.teacherRepository.save(TeacherEntity.fromDto(insertDto));
        return TeacherDto.fromEntity(saved);
    }

    public List<TeacherDto> findAll() {
        return this.teacherRepository.findAll().stream()
                .map(TeacherDto::fromEntity)
                .toList();
    }

    public TeacherDto findById(Long id) {
        TeacherEntity entity = this.teacherRepository.findById(id).orElseThrow();
        return TeacherDto.fromEntity(entity);
    }

    public TeacherDto update(Long id, TeacherDto updateDto) {
        TeacherEntity entity = this.teacherRepository.findById(id).orElseThrow();
        if (updateDto.getSwimPoolId() != null) {
            checkSwimPool(updateDto.getSwimPoolId());
        }
        entity.update(updateDto);
        TeacherEntity saved = this.teacherRepository.save(entity);
        return TeacherDto.fromEntity(saved);
    }

    public TeacherDto deleteById(Long id) {
        TeacherDto result = this.findById(id);
        this.teacherRepository.deleteById(id);
        return result;
    }

    private void checkSwimPool(Long swimPoolId) {
        if (swimPoolId == null) {
            throw new IllegalArgumentException("swimPoolId is required");
        }
        if (!this.swimPoolRepository.existsById(swimPoolId)) {
            throw new IllegalArgumentException("swimPoolId does not exist: " + swimPoolId);
        }
    }
}
