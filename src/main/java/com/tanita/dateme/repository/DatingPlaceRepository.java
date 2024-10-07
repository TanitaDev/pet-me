package com.tanita.dateme.repository;

import com.tanita.dateme.model.DatingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatingPlaceRepository extends JpaRepository<DatingPlace, Long> {
}
