package com.tanita.dateme.image.repository;

import com.tanita.dateme.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
