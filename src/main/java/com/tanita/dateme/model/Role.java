package com.tanita.dateme.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
