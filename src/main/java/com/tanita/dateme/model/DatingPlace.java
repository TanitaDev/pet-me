package com.tanita.dateme.model;

import com.tanita.dateme.common.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

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

}
