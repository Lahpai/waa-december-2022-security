package edu.miu.springsecurity1.repository;

import org.apache.tomcat.jni.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
