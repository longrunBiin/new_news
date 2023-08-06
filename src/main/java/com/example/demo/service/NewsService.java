package com.example.demo.service;

import com.example.demo.domain.Interests;
import com.example.demo.domain.News;
import com.example.demo.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    @Transactional
    public Long registerNews(News news) {
        newsRepository.save(news);
        return news.getNewsId();
    }

    public List<News> findNewsByName(String name) {
        return newsRepository.findByTitle(name);
    }

    public List<News> findNewsByCategory(String category) {
        return newsRepository.findByTitle(category);
    }

    public List<News> findNewsBySource(String source) {
        return newsRepository.findByTitle(source);
    }
    public List<News> findAll(){
        return newsRepository.findAll();
    }

}
