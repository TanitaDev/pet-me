package com.tanita.dateme.datingplace.mapper;

import com.tanita.dateme.dto.place.DatingPlaceDto;
import com.tanita.dateme.model.DatingPlace;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface DatingPlaceMapper {

    DatingPlaceDto toDto(DatingPlace entity);

}
