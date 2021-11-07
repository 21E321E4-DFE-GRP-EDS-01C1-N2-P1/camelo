package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.BuscarUsuarioUseCase;
import com.camelo.camelobackend.interactors.CadastrarUsuarioUseCase;
import com.camelo.camelobackend.transportlayers.dto.UserNewDTO;
import com.camelo.camelobackend.transportlayers.dto.UserResponseDTO;
import com.camelo.camelobackend.transportlayers.mapper.UserNewDTOMapper;
import com.camelo.camelobackend.transportlayers.mapper.UserResponseDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    private final UserNewDTOMapper userNewMapper;
    private final UserResponseDTOMapper userResponseDTOMapper;
    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public UserApi(CadastrarUsuarioUseCase useCase, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.userNewMapper = UserNewDTOMapper.INSTANCE;
        this.userResponseDTOMapper = UserResponseDTOMapper.INSTANCE;
        this.cadastrarUsuarioUseCase = useCase;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        var user = buscarUsuarioUseCase.porId(id);
        var response = userResponseDTOMapper.map(user);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@Valid @RequestBody UserNewDTO userNewDTO) {
        var user = userNewMapper.map(userNewDTO);
        var usuarioCriado = cadastrarUsuarioUseCase.executar(user);
        var response = userResponseDTOMapper.map(usuarioCriado);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
