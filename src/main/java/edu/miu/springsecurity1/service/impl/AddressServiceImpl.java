package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.repository.AddressRepo;
import edu.miu.springsecurity1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper mapper;

    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public List<Address> findAll() {
        return getDtoList((List<Address>) addressRepo.findAll());
    }

    @Override
    public Address findById(int id) {
        var x = addressRepo.findById(id).get();
        return
                getDto(x);
    }

    @Override
    public void deleteById(int id) {
        addressRepo.deleteById(id);
    }


    private List<Address> getDtoList(List<Address> addresses) {
        return addresses.stream().map(p -> {
            return getDto(p);
        }).toList();
    }

    private Address getDto(Address address) {
        return mapper.map(address, Address.class);
    }
}
