package com.tanita.dateme.user.model;

import com.tanita.dateme.common.model.AbstractEntity;
import com.tanita.dateme.model.Chat;
import com.tanita.dateme.model.Invitation;
import com.tanita.dateme.model.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    private String username;

    private String firstName;

    private String lastName;

    private int age;

    private String avatar;

    private String phoneNumber;

    private LocalDateTime lastOnlineTimestamp;

    @ManyToMany
    @JoinTable(
            name = "user_to_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "sender")
    private Set<Invitation> sentInvitations;

    @OneToMany(mappedBy = "receiver")
    private Set<Invitation> receivedInvitations;

    @OneToMany(mappedBy = "user")
    private Set<Chat> chats;

}
