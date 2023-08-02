package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Users {

    @Id
    @GeneratedValue
    private Long userId;

    private String userName;

    private String email;

    private String password;

    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy = "userId")
    private List<UserInterests> userInterests = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<UserPersonalizedNews> userPersonalizedNews = new ArrayList<>();

}
