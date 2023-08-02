package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class News {

    @Id
    @GeneratedValue
    private Long newsId;

    private String title;

    private String content;

    private String category;

    private String source;

    private Date publishedAt;

    @OneToMany(mappedBy = "newsId")
    private List<UserPersonalizedNews> userPersonalizedNews = new ArrayList<>();
}
