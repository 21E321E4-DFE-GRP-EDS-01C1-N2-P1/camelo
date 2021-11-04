package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.ports.PefilPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsUseCase implements UserDetailsService {

    private final PefilPort port;

    public UserDetailsUseCase(PefilPort port) {
        this.port = port;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var user = port.buscarPor(s);

        if (Objects.nonNull(user)) {
            throw new UsernameNotFoundException(String.format("Usuário %s não existe!", s));
        }

        return null;
    }
}
