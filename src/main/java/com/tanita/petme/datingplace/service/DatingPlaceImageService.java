package com.tanita.petme.datingplace.service;

import com.tanita.petme.datingplace.model.DatingPlaceImage;
import com.tanita.petme.dto.datingplace.request.DatingPlaceImageRequest;

public interface DatingPlaceImageService {

    DatingPlaceImage create(DatingPlaceImageRequest request);

}
