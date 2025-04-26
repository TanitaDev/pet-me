package com.tanita.petme.model;

import com.tanita.petme.common.model.AbstractEntity;
import com.tanita.petme.datingplace.model.DatingPlace;
import com.tanita.petme.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invitation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invitation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "dating_place_id")
    private DatingPlace datingPlace;

}
