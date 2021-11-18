package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.AdicionarFormaDePagamentoUseCase;
import com.camelo.camelobackend.interactors.ListarPagamentosDoUsuarioUseCase;
import com.camelo.camelobackend.transportlayers.mapper.CartaoMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.PagamentoApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Cartao;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/")
public class PagamentoApiImpl implements PagamentoApi {

    private final AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase;
    private final ListarPagamentosDoUsuarioUseCase listarPagamentosDoUsuarioUseCase;
    private final CartaoMapper mapper;

    public PagamentoApiImpl(AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase, ListarPagamentosDoUsuarioUseCase listarPagamentosDoUsuarioUseCase) {
        this.adicionarFormaDePagamentoUseCase = adicionarFormaDePagamentoUseCase;
        this.listarPagamentosDoUsuarioUseCase = listarPagamentosDoUsuarioUseCase;
        mapper = Mappers.getMapper(CartaoMapper.class);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @Override
    public ResponseEntity<Cartao> pagamentoPost(
            @RequestHeader(value="Authorization") String authorization,
            @RequestBody Cartao cartao) {

        var cartaoDomain = mapper.map(cartao);
        var cartaoSalvo = adicionarFormaDePagamentoUseCase.executar(cartaoDomain);
        var response = mapper.map(cartaoSalvo);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @Override
    public ResponseEntity<List<Cartao>> pagamentoGet(@RequestHeader(value="Authorization") String authorization) {
        var cartoes = listarPagamentosDoUsuarioUseCase.executar();
        var response = cartoes.stream().map(mapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
