package com.tanita.dateme.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
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

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

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
