package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserInterests {

    @Id
    @GeneratedValue
    private Long userInterestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interest_id")
    private Interests interestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users userId;

    private String interest;

    public static UserInterests createUserInterest(Users user, Interests interest) {
        UserInterests userInterest = new UserInterests();
        userInterest.setInterestId(interest);
        userInterest.setUserId(user);
        userInterest.setInterest(interest.getInterestName());

        return userInterest;
    }
}
