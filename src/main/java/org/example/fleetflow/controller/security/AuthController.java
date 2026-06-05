package org.example.fleetflow.controller.security;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.fleetflow.dto.userdto.LoginUser;
import org.example.fleetflow.dto.userdto.RegisterUser;
import org.example.fleetflow.services.imp.securityImp.AuthServiceImp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthServiceImp authServiceImp;


    @PostMapping("/register")
    public ResponseEntity<String>register(@Valid @RequestBody RegisterUser user){
        return ResponseEntity.ok(authServiceImp.addUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@Valid @RequestBody LoginUser user){
        return ResponseEntity.ok(authServiceImp.login(user.getEmail(),user.getPassword()));
    }
 





}
