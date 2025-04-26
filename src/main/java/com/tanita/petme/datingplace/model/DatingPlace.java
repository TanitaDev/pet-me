package com.tanita.petme.datingplace.model;

import com.tanita.petme.common.model.AbstractEntity;
import com.tanita.petme.model.Invitation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
