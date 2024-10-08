package com.tanita.dateme.api;


import com.tanita.dateme.datingplace.mapper.DatingPlaceMapper;
import com.tanita.dateme.dto.common.RestResponse;
import com.tanita.dateme.dto.place.DatingPlaceDto;
import com.tanita.dateme.service.DatingPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dating-place")
@RequiredArgsConstructor
public class DatingPlaceController {

    private final DatingPlaceService datingPlaceService;
    private final DatingPlaceMapper datingPlaceMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<List<DatingPlaceDto>> getAll() {
        List<DatingPlaceDto> response = datingPlaceService.getAll().stream()
                .map(datingPlaceMapper::toDto)
                .toList();
        return RestResponse.ok(response);
    }

}
