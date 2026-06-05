package org.example.fleetflow.services.security;

import org.example.fleetflow.dto.userdto.RegisterUser;

public interface AuthService {
    String addUser(RegisterUser registerUser);
    String login(String email,String password);
}
