package com.tanita.petme.datingplace.service;

import com.tanita.petme.datingplace.model.DatingPlace;
import com.tanita.petme.dto.datingplace.request.DatingPlaceRequest;

import java.util.List;

public interface DatingPlaceService {

    List<DatingPlace> getAll();

    DatingPlace create(DatingPlaceRequest request);

}
