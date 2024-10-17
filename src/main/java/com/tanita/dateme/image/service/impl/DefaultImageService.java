package com.tanita.dateme.image.service.impl;

import com.tanita.dateme.dto.image.request.ImageRequest;
import com.tanita.dateme.image.repository.ImageRepository;
import com.tanita.dateme.image.service.ImageService;
import com.tanita.dateme.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultImageService implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image create(ImageRequest request) {

        Image image = new Image();
        image.setFileName(request.getFileName());

        return imageRepository.save(image);
    }
}
