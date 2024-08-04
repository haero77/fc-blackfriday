package org.example.meberservice.entity;

import jakarta.persistence.*;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    public String loginId;

    public String userName;

    protected UserEntity() {
    }

    public UserEntity(final String loginId, final String userName) {
        this.loginId = loginId;
        this.userName = userName;
    }
}
