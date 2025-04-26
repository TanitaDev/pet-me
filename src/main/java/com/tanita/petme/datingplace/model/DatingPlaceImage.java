package com.tanita.petme.datingplace.model;

import com.tanita.petme.common.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dating_place_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatingPlaceImage extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "dating_place_id")
    private DatingPlace datingPlace;

    private String bucketName;

    private String fileKey;

}
