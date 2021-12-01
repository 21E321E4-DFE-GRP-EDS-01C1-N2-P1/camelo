package com.camelo.camelobackend.transportlayers.impl;

import com.camelo.camelobackend.interactors.AtualizarDadosDoUsuarioUseCase;
import com.camelo.camelobackend.interactors.BuscarUsuarioUseCase;
import com.camelo.camelobackend.interactors.CadastrarUsuarioUseCase;
import com.camelo.camelobackend.transportlayers.dto.EditUserDTO;
import com.camelo.camelobackend.transportlayers.dto.UserNewDTO;
import com.camelo.camelobackend.transportlayers.dto.UserResponseDTO;
import com.camelo.camelobackend.transportlayers.mapper.UpdateUserDTOMapper;
import com.camelo.camelobackend.transportlayers.mapper.UserNewDTOMapper;
import com.camelo.camelobackend.transportlayers.mapper.UserResponseDTOMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    private final UserNewDTOMapper userNewMapper;
    private final UserResponseDTOMapper userResponseDTOMapper;
    private final UpdateUserDTOMapper updateUserDTOMapper;

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final AtualizarDadosDoUsuarioUseCase atualizarDadosDoUsuarioUseCase;

    public UserApi(CadastrarUsuarioUseCase useCase, BuscarUsuarioUseCase buscarUsuarioUseCase, AtualizarDadosDoUsuarioUseCase atualizarDadosDoUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.atualizarDadosDoUsuarioUseCase = atualizarDadosDoUsuarioUseCase;
        this.userNewMapper = UserNewDTOMapper.INSTANCE;
        this.userResponseDTOMapper = UserResponseDTOMapper.INSTANCE;
        this.updateUserDTOMapper = Mappers.getMapper(UpdateUserDTOMapper.class);
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

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @PutMapping
    public ResponseEntity<?> update(
            @RequestHeader(value="Authorization") String authorization,
            @Valid @RequestBody EditUserDTO editUserDTO) {
        var user = updateUserDTOMapper.map(editUserDTO);

        atualizarDadosDoUsuarioUseCase.executar(user);
        return ResponseEntity.noContent().build();
    }
}
