package com.tanita.petme.datingplace.service.impl;

import com.tanita.petme.datingplace.model.DatingPlace;
import com.tanita.petme.datingplace.repository.DatingPlaceRepository;
import com.tanita.petme.datingplace.service.DatingPlaceService;
import com.tanita.petme.dto.datingplace.request.DatingPlaceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultDatingPlaceService implements DatingPlaceService {

    private final DatingPlaceRepository datingPlaceRepository;

    @Override
    public List<DatingPlace> getAll() {
        return datingPlaceRepository.findAll();
    }

    @Override
    public DatingPlace create(DatingPlaceRequest request) {
        return null;
    }


}
