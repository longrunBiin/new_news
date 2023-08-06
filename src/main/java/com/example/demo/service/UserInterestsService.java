package com.example.demo.service;

import com.example.demo.domain.UserInterests;
import com.example.demo.repository.UserInterestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserInterestsService {

    private final UserInterestsRepository userInterestsRepository;

    public void subscribeInterest(UserInterests userInterests) {

    }
}
