package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.UserData;
import com.camelo.camelobackend.datasources.h2.mapper.UserMapper;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.stereotype.Component;

@Component
public class UserRepository implements UserPort {

    private final UserData userData;
    private final UserMapper mapper;

    public UserRepository(UserData profileData) {
        this.userData = profileData;
        this.mapper = UserMapper.INSTANCE;
    }

    @Override
    public User buscarPor(String email) {
        var profileModel = userData.buscarPorEmail(email);
        return mapper.map(profileModel);
    }

    @Override
    public User buscarPor(Long id) {
        var userModel = userData.findById(id).orElseThrow();
        return mapper.map(userModel);
    }

    @Override
    public User salvar(User user) {
        var userModel = mapper.map(user);
        var usuarioCriado = userData.save(userModel);
        return mapper.map(usuarioCriado);
    }
}
