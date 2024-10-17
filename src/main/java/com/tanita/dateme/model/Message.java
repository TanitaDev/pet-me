package com.tanita.dateme.model;

import com.tanita.dateme.common.model.AbstractEntity;
import com.tanita.dateme.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private String content;

    private LocalDateTime dateWritten;

    private LocalDateTime red;

}
