package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.OffensiveUser;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.repository.OffensiveUserRepo;
import edu.miu.springsecurity1.security.AwesomeUserDetails;
import edu.miu.springsecurity1.service.OffensiveUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class OffensiveUserServiceImpl implements OffensiveUserService {
    private OffensiveUserRepo offensiveUserRepo;
    private List<String> offensiveWords = new ArrayList<>();

    @Override
    public OffensiveUser findByUserId(int userId) {
        return offensiveUserRepo.findOffensiveUserBy_Id(userId);
    }

    @Override
    public void saveOffensiveUser(OffensiveUser offensiveUser) {
        offensiveUserRepo.save(offensiveUser);
    }

    @Override
    public boolean scanOffensiveWord(Object[] args) {
        boolean isContainOffensiveWords = false;
        for (Object obj: args){
            System.out.println(obj.toString());
            for (String words: offensiveWords) {
                if (obj.toString().contains(words)) {
                    isContainOffensiveWords = true;
                    break;
                }
                if (isContainOffensiveWords) {
                    updateOffensiveUser();
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkIfBanned() {
        return false;
    }

    private void updateOffensiveUser() {
        int userId = getCurrentUserId();
        var offensiveUser = findByUserId(userId);
        if (offensiveUser != null) {
            offensiveUser.setOffensiveCount(offensiveUser.getOffensiveCount() + 1);
            if(offensiveUser.getOffensiveCount() >= 5) {
                LocalDateTime after15mins = LocalDateTime.now().plus(Duration.of(10, ChronoUnit.MINUTES));
                offensiveUser.setBannedUntil(after15mins);
            }
            saveOffensiveUser(offensiveUser);
        } else {
            var user = new User();
            user.setId(userId);
            var newOffensive = new OffensiveUser();
            newOffensive.setOffensiveCount(1);
            newOffensive.setUser(user);
            saveOffensiveUser(newOffensive);
        }
    }
    private int getCurrentUserId() {
        try{
            return ((AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        }catch (Exception ex){
            return 0;
        }

    }
}
