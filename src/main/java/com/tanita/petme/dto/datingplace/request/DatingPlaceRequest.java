package com.tanita.petme.dto.datingplace.request;

import com.tanita.petme.datingplace.model.DatingPlaceImage;
import com.tanita.petme.model.Invitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatingPlaceRequest {

    private String name;

    private String description;

    private Set<Invitation> invitations;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<DatingPlaceImage> datingPlaceImageList;

}
