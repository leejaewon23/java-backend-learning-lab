package org.example.petapp.pet.cntr;

import org.example.petapp.pet.PetRequestDto;
import org.example.petapp.pet.PetResponseDto;
import org.example.petapp.pet.dto.PetDto;
import org.example.petapp.pet.dto.PetEntity;
import org.example.petapp.pet.svc.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/pet")
public class PetRestController {
    @Autowired
    public PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDto> insertPet(@RequestBody PetDto petDto) {
        try {
            PetDto result = this.petService.insert(petDto);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @PatchMapping
    public ResponseEntity<PetResponseDto> updatePet(@RequestBody PetDto petDto) {
        try {
            PetDto result = this.petService.update(petDto);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not found error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @DeleteMapping
    public ResponseEntity<PetResponseDto> deletePet(@RequestParam Integer id) {
        try {
            PetDto result = this.petService.deleteById(id);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not found error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @GetMapping("/{id}")    // => /api/pet?id=번호  => /api/pet/번호
    public ResponseEntity<PetResponseDto> findById(@PathVariable Object id) {
        try {
            Integer nId = Integer.parseInt(id.toString());
            PetDto result = this.petService.findById(nId);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new PetResponseDto(-997, "Not found error", null));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PetResponseDto(-994, "Number error", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<PetResponseDto> findByNameContains(
            @RequestParam String searchName
            , @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable)
    // 웹클라이언트에서 GET주소 요청시에 Pageable 정보를 이런식으로 전달할 수 있다. &sort=id,desc&size=4&page=0
    {
        try {
            PetRequestDto prd = new PetRequestDto();
            prd.setSearchName(searchName);
            Slice<PetEntity> result = this.petService.findByNameContains(prd, pageable);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }


}
