package com.example.demo.service;

import com.example.demo.domain.Interests;
import com.example.demo.domain.Users;
import com.example.demo.repository.InterestsRepository;
import com.example.demo.repository.UserInterestsRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserInterestsServiceTest {

    @Autowired
    UserInterestsService userInterestsService;
    @Autowired
    UserInterestsRepository userInterestsRepository;
    @Autowired
    InterestsRepository interestsRepository;
    @Autowired
    InterestsService interestsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Test
    public void subscribeInterest() {
        Interests interests = new Interests();
        interests.setInterestName("nameA");
        interestsService.registerInterest(interests);

        Users user = new Users();
        user.setUserName("kim");
        userService.join(user);

        Long result = userInterestsService.subscribeInterest(interests.getInterestId(), user.getUserId());

        Assertions.assertEquals(interests.getInterestName(), userInterestsRepository.findOne(result).getInterest());
        Assertions.assertEquals(user, userInterestsRepository.findOne(result).getUserId());
    }

}