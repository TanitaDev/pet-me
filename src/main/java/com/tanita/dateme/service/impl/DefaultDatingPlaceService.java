package com.tanita.dateme.service.impl;

import com.tanita.dateme.model.DatingPlace;
import com.tanita.dateme.repository.DatingPlaceRepository;
import com.tanita.dateme.service.DatingPlaceService;
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



}
