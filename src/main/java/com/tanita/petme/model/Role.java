package com.tanita.petme.model;

import com.tanita.petme.common.model.AbstractEntity;
import com.tanita.petme.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
