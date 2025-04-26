package com.tanita.petme.datingplace.mapper;

import com.tanita.petme.datingplace.model.DatingPlace;
import com.tanita.petme.dto.datingplace.DatingPlaceDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface DatingPlaceMapper {

    DatingPlaceDto toDto(DatingPlace entity);

}
