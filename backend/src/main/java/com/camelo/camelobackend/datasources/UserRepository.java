package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.UserData;
import com.camelo.camelobackend.datasources.h2.mapper.CartaoModelMapper;
import com.camelo.camelobackend.datasources.h2.mapper.RoleMapper;
import com.camelo.camelobackend.datasources.h2.mapper.UserMapper;
import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.domain.Role;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepository implements UserPort {

    private final UserData userData;
    private final UserMapper mapper;
    private final CartaoModelMapper cartaoModelMapper;
    private final RoleMapper roleMapper;

    public UserRepository(UserData profileData) {
        this.userData = profileData;
        this.mapper = UserMapper.INSTANCE;
        this.cartaoModelMapper = Mappers.getMapper(CartaoModelMapper.class);
        this.roleMapper = Mappers.getMapper(RoleMapper.class);
    }

    @Override
    public User buscarPor(String email) {
        var profileModel = userData.buscarPorEmail(email);

        var userResponse = new User(profileModel.getId(), profileModel.getName(), profileModel.getEmail(), profileModel.getPassword());
        var cartoes = profileModel.getCartoes().stream().map(it -> getCartao(it, userResponse)).collect(Collectors.toList());
        var roles = profileModel.getRoles().stream().map(this::getRole).collect(Collectors.toSet());

        userResponse.setCartoes(cartoes);
        userResponse.setRoles(roles);

        return userResponse;
    }

    private Role getRole(RoleModel roleModel) {
        return new Role(roleModel.getId(), roleModel.getName());
    }

    private Cartao getCartao(CartaoModel cartaoModel, User user) {
        return new Cartao(cartaoModel.getId(), cartaoModel.getNumero(), cartaoModel.getNome(), cartaoModel.getVencimento(), cartaoModel.getCvv(), user);
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
