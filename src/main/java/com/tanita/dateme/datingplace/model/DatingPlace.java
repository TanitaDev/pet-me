package com.tanita.dateme.datingplace.model;

import com.tanita.dateme.common.model.AbstractEntity;
import com.tanita.dateme.model.Invitation;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dating_place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatingPlace extends AbstractEntity {

    private String name;

    private String description;

    @OneToMany(mappedBy = "datingPlace")
    private Set<Invitation> invitations;

    @OneToMany(mappedBy = "datingPlace", cascade = CascadeType.ALL)
    private List<DatingPlaceImage> datingPlaceImageList;

}
