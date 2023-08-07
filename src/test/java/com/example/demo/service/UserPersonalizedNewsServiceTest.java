package com.example.demo.service;

import com.example.demo.domain.News;
import com.example.demo.domain.Users;
import com.example.demo.repository.*;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserPersonalizedNewsServiceTest {

    @Autowired
    UserPersonalizedNewsService userPersonalizedNewsService;
    @Autowired
    UserPersonalizedNewsRepository userPersonalizedNewsRepository;
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    NewsService newsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    public void saveNews() {
        News news = new News();
        news.setTitle("nameA");
        newsService.registerNews(news);

        Users user = new Users();
        user.setUserName("kim");
        userService.join(user);

        Long result = userPersonalizedNewsService.savePersonalNews(news.getNewsId(), user.getUserId());

        Assertions.assertEquals(news, userPersonalizedNewsRepository.findOne(result).getNewsId());
        Assertions.assertEquals(user, userPersonalizedNewsRepository.findOne(result).getUserId());
    }

}