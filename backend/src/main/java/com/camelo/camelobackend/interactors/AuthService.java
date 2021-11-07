package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.ports.UserPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserPort userPort;
    private final BCryptPasswordEncoder encoder;

    public AuthService(UserPort userPort, BCryptPasswordEncoder encoder) {
        this.userPort = userPort;
        this.encoder = encoder;
    }
}
