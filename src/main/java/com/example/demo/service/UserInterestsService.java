package com.example.demo.service;

import com.example.demo.domain.Interests;
import com.example.demo.domain.UserInterests;
import com.example.demo.domain.Users;
import com.example.demo.repository.InterestsRepository;
import com.example.demo.repository.UserInterestsRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserInterestsService {

    private final UserInterestsRepository userInterestsRepository;
    private final InterestsRepository interestsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long subscribeInterest(Long interestId, Long userId) {
        Interests interest = interestsRepository.findByInterestId(interestId);
        Users user = userRepository.findOne(userId);

        UserInterests result = UserInterests.createUserInterest(user, interest);

        userInterestsRepository.save(result);
        return result.getUserInterestId();
    }

    public UserInterests findByName(String name) {
        return userInterestsRepository.findByInterest(name);
    }

    public List<UserInterests> findAll() {
        return userInterestsRepository.findAll();
    }
}
