package com.tanita.dateme.datingplace.service;

import com.tanita.dateme.dto.datingplace.request.DatingPlaceImageRequest;
import com.tanita.dateme.datingplace.model.DatingPlaceImage;

public interface DatingPlaceImageService {

    DatingPlaceImage create(DatingPlaceImageRequest request);

}
