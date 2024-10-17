package com.tanita.dateme.image.service;

import com.tanita.dateme.dto.image.request.ImageRequest;
import com.tanita.dateme.model.Image;

public interface ImageService {

    Image create(ImageRequest request);

}
