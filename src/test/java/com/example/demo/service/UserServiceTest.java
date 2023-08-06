package com.example.demo.service;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void joinUsers() throws Exception {
        Users users = new Users();
        users.setUserName("Hello");

        Long saveId = userService.join(users);

        Assertions.assertEquals(users, userRepository.findOne(saveId));
    }
    @Test
    public void validateUsers() throws Exception {
        assertThrows(IllegalStateException.class, () -> {

            Users user1 = new Users();
            user1.setUserName("kim");

            Users user2 = new Users();
            user2.setUserName("kim");

            userService.join(user1);
            userService.join(user2);

            fail("예외발생해야함");
                });

    }
}