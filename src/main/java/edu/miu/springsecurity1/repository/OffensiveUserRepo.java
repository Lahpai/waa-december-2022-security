package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.OffensiveUser;
import org.springframework.data.repository.CrudRepository;

public interface OffensiveUserRepo extends CrudRepository<OffensiveUser, Integer> {
    OffensiveUser findOffensiveUserBy_Id(int userId);
}
