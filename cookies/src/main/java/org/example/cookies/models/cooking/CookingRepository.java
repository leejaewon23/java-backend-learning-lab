package org.example.cookies.models.cooking;

import org.example.cookies.models.cookie.CookieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookingRepository extends JpaRepository<CookingEntity, Long> {
	@EntityGraph(value = "CookingEntity.fetchCookie")
	Slice<CookingEntity> findAllByDescriptionContaining(String description, Pageable pageable);

	@EntityGraph(value = "CookingEntity.fetchCookie")
	Slice<CookingEntity> findAllByCookieEquals(CookieEntity cookie, Pageable pageable);
}
