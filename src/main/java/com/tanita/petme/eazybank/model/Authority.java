package com.tanita.petme.eazybank.model;

import com.tanita.petme.common.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authority extends AbstractEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
