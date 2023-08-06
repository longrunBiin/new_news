package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Interests {

    @Id
    @GeneratedValue
    @Column(name = "interest_id")
    private Long interestId;

    private String interestName;

    @OneToMany(mappedBy = "interestId")
    private List<UserInterests> userInterests = new ArrayList<>();
}
