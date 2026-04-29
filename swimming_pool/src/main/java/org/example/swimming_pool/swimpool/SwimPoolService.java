package org.example.swimming_pool.swimpool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwimPoolService {
    private final SwimPoolRepository swimPoolRepository;

    public SwimPoolDto insert(SwimPoolDto insertDto) {
        SwimPoolEntity saved = this.swimPoolRepository.save(SwimPoolEntity.fromDto(insertDto));
        return SwimPoolDto.fromEntity(saved);
    }

    // 실무에서는 findAll 사용 잘 안 함
    public List<SwimPoolDto> findAll() {
        return this.swimPoolRepository.findAll().stream()
                .map(SwimPoolDto::fromEntity)
                .toList();
    }

    public SwimPoolDto findById(Long id) {
        SwimPoolEntity entity = this.swimPoolRepository.findById(id).orElseThrow();
        return SwimPoolDto.fromEntity(entity);
    }

    public SwimPoolDto update(Long id, SwimPoolDto updateDto) {
        SwimPoolEntity entity = this.swimPoolRepository.findById(id).orElseThrow();
        entity.update(updateDto);
        SwimPoolEntity saved = this.swimPoolRepository.save(entity);
        return SwimPoolDto.fromEntity(saved);
    }

    public SwimPoolDto deleteById(Long id) {
        SwimPoolDto result = this.findById(id);
        this.swimPoolRepository.deleteById(id);
        return result;
    }
}
