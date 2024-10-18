package com.tanita.dateme.datingplace.service.impl;

import com.tanita.dateme.datingplace.model.DatingPlace;
import com.tanita.dateme.datingplace.repository.DatingPlaceRepository;
import com.tanita.dateme.dto.datingplace.request.DatingPlaceRequest;
import com.tanita.dateme.datingplace.service.DatingPlaceService;
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
