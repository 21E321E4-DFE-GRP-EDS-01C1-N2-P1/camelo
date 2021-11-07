package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.UserSS;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserPort userPort;

    public UserDetailsServiceImpl(UserPort userPort) {
        this.userPort = userPort;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var usuario = userPort.buscarPor(email);

        if (Objects.isNull(usuario))
            throw new UsernameNotFoundException(email);

        return new UserSS(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getRoles());    }
}
