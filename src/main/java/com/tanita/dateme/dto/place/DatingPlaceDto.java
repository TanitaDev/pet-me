package com.tanita.dateme.dto.place;

import com.tanita.dateme.model.Invitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatingPlaceDto {

    private Long id;

    private String name;

    private String description;

    private Set<Invitation> invitations;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
