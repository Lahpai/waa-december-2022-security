package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {

        this.uaaService = uaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody User user) {

        uaaService.signup(user);
        return  ResponseEntity.ok().body("User Registered");
    }

}
