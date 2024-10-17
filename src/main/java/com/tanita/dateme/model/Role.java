package com.tanita.dateme.model;

import com.tanita.dateme.common.model.AbstractEntity;
import com.tanita.dateme.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    private String code;

}
