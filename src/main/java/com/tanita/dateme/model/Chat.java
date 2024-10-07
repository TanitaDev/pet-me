package com.tanita.dateme.model;

import com.tanita.dateme.common.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

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
