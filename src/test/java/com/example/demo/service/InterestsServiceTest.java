package com.example.demo.service;

import com.example.demo.domain.Interests;
import com.example.demo.repository.InterestsRepository;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InterestsServiceTest {

    @Autowired
    InterestsService interestsService;
    @Autowired
    InterestsRepository interestsRepository;


    @Test
    public void registerInterest() {
        Interests interests = new Interests();
        interests.setInterestName("economy");

        Long interestId = interestsService.registerInterest(interests);

        Assertions.assertEquals(interests, interestsRepository.findByInterestId(interestId));
    }

    @Test
    public void findInterests() {
        Interests interests1 = new Interests();
        interests1.setInterestName("economy");
        interestsService.registerInterest(interests1);

        Interests interests2 = new Interests();
        interests2.setInterestName("battery");
        interestsService.registerInterest(interests2);

        List<Interests> findList = interestsService.findAll();

        //이름으로 검색
        Assertions.assertEquals(interests1, interestsRepository.findByInterestName("economy"));
        Assertions.assertEquals(interests2, interestsRepository.findByInterestName("battery"));

        //전체 리스트에서 검색
        assertThat(findList).first().isEqualTo(interests1);
        assertThat(findList).element(1).isEqualTo(interests2);
    }
}