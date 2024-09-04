package com.tanita.dateme.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "dating_place")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "datingPlace")
    private Set<Invitation> invitations;
}
