package com.example.demo.service;

import com.example.demo.domain.Interests;
import com.example.demo.repository.InterestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InterestsService {

    private final InterestsRepository interestsRepository;

    @Transactional
    public Long registerInterest(Interests interests) {
        interestsRepository.save(interests);
        return interests.getInterestId();
    }

    public Interests findInterest(String interestName) {
        return interestsRepository.findByInterestName(interestName);
    }

    public List<Interests> findAll(){
        return interestsRepository.findAll();
    }


}
