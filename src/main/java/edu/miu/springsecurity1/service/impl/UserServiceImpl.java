package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.annotation.ExecutionTime;
import edu.miu.springsecurity1.dto.UserDto;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;


    @Override
    @ExecutionTime
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_GOLD')")
    public List<UserDto> findAll() {
        return getDtoList ((List<User>) userRepo.findAll());
    }

    @Override
    public UserDto findByEmail(String email) {
        return getDto(userRepo.findByEmail(email));
    }

    @Override
    public UserDto findById(int id) {
        return getDto(userRepo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }


    private List<UserDto> getDtoList(List<User> users){
        return users.stream().map(p->{
            return getDto(p);
        }).toList();
    }
    private UserDto getDto(User user){
        return mapper.map(user, UserDto.class);
    }
}