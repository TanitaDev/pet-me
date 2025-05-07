package com.tanita.petme.eazybank.model;

import com.tanita.petme.common.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends AbstractEntity {

    private String email;
    private String password;
    private String role;

}
