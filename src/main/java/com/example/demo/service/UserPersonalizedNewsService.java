package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.UserInterestsRepository;
import com.example.demo.repository.UserPersonalizedNewsRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserPersonalizedNewsService {

    private final UserPersonalizedNewsRepository userPersonalizedNewsRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;


    @Transactional
    public Long savePersonalNews(Long newsId, Long userId) {
        News news = newsRepository.findByNewsId(newsId);
        Users user = userRepository.findOne(userId);

        UserPersonalizedNews result = UserPersonalizedNews.createUserPersonalizedNews(user, news);

        userPersonalizedNewsRepository.save(result);
        return result.getPersonalizedNewsId();
    }

    public List<UserPersonalizedNews> findAll() {
        return userPersonalizedNewsRepository.findAll();
    }
}
