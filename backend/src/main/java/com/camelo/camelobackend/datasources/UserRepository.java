package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.CartaoData;
import com.camelo.camelobackend.datasources.h2.data.RoleData;
import com.camelo.camelobackend.datasources.h2.data.UserData;
import com.camelo.camelobackend.datasources.h2.mapper.CartaoModelMapper;
import com.camelo.camelobackend.datasources.h2.mapper.RoleMapper;
import com.camelo.camelobackend.datasources.h2.mapper.UserMapper;
import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import com.camelo.camelobackend.datasources.h2.model.UserModel;
import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.domain.Role;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserRepository implements UserPort {

    private final UserData userData;
    private final RoleData roleData;
    private final CartaoData cartaoData;
    private final UserMapper mapper;
    private final CartaoModelMapper cartaoModelMapper;
    private final RoleMapper roleMapper;

    public UserRepository(UserData profileData, RoleData roleData, CartaoData cartaoData) {
        this.userData = profileData;
        this.roleData = roleData;
        this.cartaoData = cartaoData;
        this.mapper = UserMapper.INSTANCE;
        this.cartaoModelMapper = Mappers.getMapper(CartaoModelMapper.class);
        this.roleMapper = Mappers.getMapper(RoleMapper.class);
    }

    @Override
    public User buscarPor(String email) {
        var profileModel = userData.buscarPorEmail(email);

        if (Objects.nonNull(profileModel)) {
            var userResponse = new User(
                    profileModel.getId(),
                    profileModel.getName(),
                    profileModel.getEmail(),
                    profileModel.getPassword(),
                    profileModel.getEndereco(),
                    profileModel.getCep(),
                    profileModel.getBairro(),
                    profileModel.getCidade()
            );

            var cartoes = profileModel.getCartoes().stream().map(it -> getCartao(it, userResponse)).collect(Collectors.toList());
            var roles = profileModel.getRoles().stream().map(this::getRole).collect(Collectors.toSet());

            userResponse.setCartoes(cartoes);
            userResponse.setRoles(roles);

            return userResponse;
        }

        throw new RuntimeException("USUARIO NÃO LOCALIZADO");
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
        var userModel = converter(user);
        var usuarioCriado = userData.save(userModel);
        return mapper.map(usuarioCriado);
    }

    private UserModel converter(User user) {
        var model = new UserModel();

        model.setId(user.getId());
        model.setName(user.getName());
        model.setEmail(user.getEmail());
        model.setPassword(user.getPassword());
        model.setEndereco(user.getEndereco());
        model.setCep(user.getCep());
        model.setBairro(user.getBairro());
        model.setCidade(user.getCidade());
        model.setRoles(user.getRoles().stream().map(it -> roleData.findById(it.getId()).get()).collect(Collectors.toList()));
        model.setCartoes(user.getCartoes().stream().map(it -> cartaoData.findById(it.getId()).get()).collect(Collectors.toList()));
        return model;
    }
}
