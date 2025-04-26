package com.tanita.petme.user.model;

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
@Table(name = "user_gallery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGallery extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String bucketName;

    private String fileKey;

}
