package edu.miu.springsecurity1.dto;

import edu.miu.springsecurity1.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private List<Role> roles;
}
