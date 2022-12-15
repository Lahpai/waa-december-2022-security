package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public void save(@RequestBody Address address) {
        addressService.save(address);
    }

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable int id) {
        return addressService.findById(id);
    }

//    @PutMapping("/{id}")
//    public void save(@PathVariable int id, @RequestBody Address address) {
//        if (id > 0)
//            address.setId(id);
//        addressService.save(address);
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }
}