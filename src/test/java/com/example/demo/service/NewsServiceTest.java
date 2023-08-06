package com.example.demo.service;

import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class NewsServiceTest {

    @Autowired
    NewsService newsService;
    @Autowired
    NewsRepository newsRepository;

    @Test
    public void registerNews() {
        News news = new News();
        news.setTitle("titleA");

        Long newsId = newsService.registerNews(news);

        Assertions.assertEquals(news, newsRepository.findByNewsId(newsId));
    }

    @Test
    public void findNews() {
        News news = new News();
        news.setTitle("titleA");
        news.setCategory("categoryA");
        news.setSource("sourceA");

        newsService.registerNews(news);
        List<News> result = newsService.findAll();

        assertThat(result).extracting("title").contains("titleA");
        assertThat(result).extracting("category").contains("categoryA");
        assertThat(result).extracting("source").contains("sourceA");

    }

}