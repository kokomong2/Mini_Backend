package com.kokomong.mini_backend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userid;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
