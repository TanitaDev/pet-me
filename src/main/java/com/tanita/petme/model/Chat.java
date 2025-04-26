package com.tanita.petme.model;

import com.tanita.petme.common.model.AbstractEntity;
import com.tanita.petme.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "chat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String chatType;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "chat")
    private Set<Message> messages;

}
