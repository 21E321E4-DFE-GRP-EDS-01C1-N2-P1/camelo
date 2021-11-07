package com.camelo.camelobackend.transportlayers.dto;

import com.camelo.camelobackend.domain.Role;

import java.util.List;

public class UserResponseDTO {

    private final Long id;
    private final String name;
    private final String email;
    private final List<Role> roles;

    public UserResponseDTO(Long id, String name, String email, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
