package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.dto.UserDto;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable int id, @RequestBody User user) {
        if (id > 0)
            user.setId(id);
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}
