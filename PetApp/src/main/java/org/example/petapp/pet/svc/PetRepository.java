package org.example.petapp.pet.svc;

import org.example.petapp.pet.dto.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
