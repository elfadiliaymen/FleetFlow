package org.example.fleetflow.services.imp.securityImp;

import lombok.RequiredArgsConstructor;
import org.example.fleetflow.dto.userdto.RegisterUser;
import org.example.fleetflow.enums.Role;
import org.example.fleetflow.mapper.security.AuthMapper;

import org.example.fleetflow.model.User;
import org.example.fleetflow.repository.security.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImp jwtServiceImp;
    private final AuthMapper authMapper;


    public String addUser(RegisterUser registerUser){

        User user = authMapper.toEntity(registerUser);
        user.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        if (registerUser.getUsername() == null || registerUser.getUsername().isBlank()) {
            user.setUsername(registerUser.getEmail());
        } else {
            user.setUsername(registerUser.getUsername());
        }
        String role = registerUser.getRole();
        if (role != null) {
            if (role.equalsIgnoreCase("manager")){
                user.setRole(Role.ROLE_ADMIN);
            }
            if (role.equalsIgnoreCase("admin")){
                user.setRole(Role.ROLE_ADMIN);
            }
            if (role.equalsIgnoreCase("chauffeur")){
                user.setRole(Role.ROLE_CHAUFFEUR);
            }
        } else if (role == null) {
            throw  new RuntimeException("remplir le role");
        }

        userRepository.save(user);
        return login(registerUser.getEmail(), registerUser.getPassword());
    }


    public String login(String email,String password) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );
        UserDetails user = (UserDetails) auth.getPrincipal();
        return jwtServiceImp.generateToken(user);
    }


}
