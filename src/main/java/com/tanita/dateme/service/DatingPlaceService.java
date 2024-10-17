package com.tanita.dateme.service;

import com.tanita.dateme.datingplace.model.DatingPlace;
import com.tanita.dateme.dto.datingplace.request.DatingPlaceRequest;

import java.util.List;

public interface DatingPlaceService {

    List<DatingPlace> getAll();

    DatingPlace create(DatingPlaceRequest request);

}
