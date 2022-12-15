package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.OffensiveUser;

public interface OffensiveUserService {
    OffensiveUser findByUserId(int userId);

    void saveOffensiveUser(OffensiveUser offensiveUser);

    boolean scanOffensiveWord(Object[] args);

    boolean checkIfBanned();
}
