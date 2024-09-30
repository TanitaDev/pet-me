package com.tanita.dateme.model;

import com.tanita.dateme.common.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "invitation")
@Data
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
