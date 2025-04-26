package com.tanita.petme.datingplace.repository;

import com.tanita.petme.datingplace.model.DatingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatingPlaceRepository extends JpaRepository<DatingPlace, Long> {
}
