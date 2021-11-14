package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import com.camelo.camelobackend.transportlayers.dto.UserResponseDTO;
import com.camelo.camelobackend.transportlayers.mapper.UserResponseDTOMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AtualizarDadosDoUsuarioUseCase {

    private final UserPort userPort;
    private final UserResponseDTOMapper userResponseDTOMapper;

    public AtualizarDadosDoUsuarioUseCase(UserPort userPort) {
        this.userPort = userPort;
        userResponseDTOMapper = Mappers.getMapper(UserResponseDTOMapper.class);
    }

    public UserResponseDTO executar(User user) {
        var userSS = UserService.authenticated();

        if (Objects.nonNull(userSS)) {
            var oldUser = userPort.buscarPor(userSS.getUsername());

            oldUser.setCidade(user.getCidade());
            oldUser.setBairro(user.getBairro());
            oldUser.setCep(user.getCep());
            oldUser.setEndereco(user.getEndereco());
            oldUser.setName(user.getName());

            var response = userPort.salvar(oldUser);
            return userResponseDTOMapper.map(response);
        }

        throw new RuntimeException("USUARIO NÃO LOCALIZAZDO");
    }
}
