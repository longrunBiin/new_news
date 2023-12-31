package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserPersonalizedNews {

    @Id
    @GeneratedValue
    private Long personalizedNewsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private Users userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="newsId")
    private News newsId;

    public static UserPersonalizedNews createUserPersonalizedNews(Users user, News news) {
        UserPersonalizedNews userNews = new UserPersonalizedNews();
        userNews.setNewsId(news);
        userNews.setUserId(user);

        return userNews;
    }

}
