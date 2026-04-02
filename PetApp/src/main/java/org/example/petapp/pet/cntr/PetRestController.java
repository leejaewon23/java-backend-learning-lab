package org.example.petapp.pet.cntr;

import org.example.petapp.pet.PetResponseDto;
import org.example.petapp.pet.dto.PetDto;
import org.example.petapp.pet.svc.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }

    @DeleteMapping
    public ResponseEntity<PetResponseDto> deletePet(@RequestParam Integer id) {
        try {
            PetDto result = this.petService.deleteById(id);
            return ResponseEntity.ok().body(new PetResponseDto(0, "SUCCESS", result));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new PetResponseDto(-999, "ERROR", null));
        }
    }
}
