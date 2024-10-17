package com.tanita.dateme.datingplace.service.impl;

import com.tanita.dateme.dto.datingplace.request.DatingPlaceImageRequest;
import com.tanita.dateme.datingplace.repository.DatingPlaceImageRepository;
import com.tanita.dateme.datingplace.service.DatingPlaceImageService;
import com.tanita.dateme.datingplace.model.DatingPlaceImage;
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
