package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepo extends CrudRepository {
   List<Role> findByRole(String role);
}
