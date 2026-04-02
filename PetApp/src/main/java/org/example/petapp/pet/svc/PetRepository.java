package org.example.petapp.pet.svc;

import org.example.petapp.pet.dto.PetEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    Slice<PetEntity> findByNameContains(String searchName, Pageable pageable);
}
