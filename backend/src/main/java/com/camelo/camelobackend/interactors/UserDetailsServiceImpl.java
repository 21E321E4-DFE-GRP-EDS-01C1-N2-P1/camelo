package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.domain.UserLocalStorage;
import com.camelo.camelobackend.domain.UserSS;
import com.camelo.camelobackend.ports.UserPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserPort userPort;
    private final ObjectMapper mapper;

    public UserDetailsServiceImpl(UserPort userPort, ObjectMapper mapper) {
        this.userPort = userPort;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User usuario = null;

        try {
            var userLocalStorage = new Gson().fromJson(email, UserLocalStorage.class);
            usuario = userPort.buscarPor(userLocalStorage.getEmail());

        } catch (Exception e ) {
            usuario = userPort.buscarPor(email);

        }

        if (Objects.isNull(usuario))
            throw new UsernameNotFoundException(email);

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getRoles());    }
}
