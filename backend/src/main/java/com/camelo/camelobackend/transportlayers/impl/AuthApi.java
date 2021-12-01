package com.camelo.camelobackend.transportlayers.impl;

import com.camelo.camelobackend.domain.UserSS;
import com.camelo.camelobackend.interactors.AuthService;
import com.camelo.camelobackend.interactors.UserService;
import com.camelo.camelobackend.interactors.security.JWTUtil;
import com.camelo.camelobackend.transportlayers.dto.EmailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthApi {

    private final JWTUtil jwtUtil;
    private final AuthService authService;

    public AuthApi(JWTUtil jwtUtil, AuthService authService) {
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    @PostMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserSS user = UserService.authenticated();

        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/forgot")
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO dto) {

        authService.sendNewPassword(dto.getEmail());
        return ResponseEntity.noContent().build();
    }
}
