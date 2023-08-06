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

    private String title;//뉴스 제목

    private String content;//뉴스 내용

    private String category;//뉴스 카테고리

    private String source;//뉴스 출처

    private Date publishedAt;

    @OneToMany(mappedBy = "newsId")
    private List<UserPersonalizedNews> userPersonalizedNews = new ArrayList<>();
}
