package edu.miu.springsecurity1.service;

import org.apache.tomcat.jni.Address;

import java.util.List;

public interface AddressService {
    void save(Address address);
    List<Address> findAll();
    Address findById(int id);
    void deleteById(int id);
}
