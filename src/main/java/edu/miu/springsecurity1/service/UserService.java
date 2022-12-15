package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.dto.UserDto;
import edu.miu.springsecurity1.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<UserDto> findAll();
    UserDto findById(int id);
    void deleteById(int id);

    public UserDto findByEmail(String email);
}
