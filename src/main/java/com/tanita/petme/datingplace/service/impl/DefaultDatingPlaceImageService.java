package com.tanita.petme.datingplace.service.impl;

import com.tanita.petme.datingplace.model.DatingPlaceImage;
import com.tanita.petme.datingplace.repository.DatingPlaceImageRepository;
import com.tanita.petme.datingplace.service.DatingPlaceImageService;
import com.tanita.petme.dto.datingplace.request.DatingPlaceImageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDatingPlaceImageService implements DatingPlaceImageService {

    private final DatingPlaceImageRepository imageRepository;

    @Override
    public DatingPlaceImage create(DatingPlaceImageRequest request) {

        DatingPlaceImage datingPlaceImage = new DatingPlaceImage();
        datingPlaceImage.setFileKey(request.getFileKey());

        return imageRepository.save(datingPlaceImage);
    }
}
