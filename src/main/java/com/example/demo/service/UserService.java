package com.example.demo.service;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(Users users) {
        validateDuplicateUsers(users);
        userRepository.save(users);
        return users.getUserId();
    }

    private void validateDuplicateUsers(Users users) {
        List<Users> findUsers = userRepository.findByName(users.getUserName());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Users> findMembers() {
        return userRepository.findAll();
    }
    public Users findOne(Long memberId) {
        return userRepository.findOne(memberId);
    }
}
