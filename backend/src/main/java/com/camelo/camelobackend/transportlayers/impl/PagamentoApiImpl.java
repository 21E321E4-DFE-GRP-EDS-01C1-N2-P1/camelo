package com.camelo.camelobackend.transportlayers.impl;

import com.camelo.camelobackend.interactors.AdicionarFormaDePagamentoUseCase;
import com.camelo.camelobackend.interactors.ListarPagamentosDoUsuarioUseCase;
import com.camelo.camelobackend.transportlayers.mapper.CartaoMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.PagamentoApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Cartao;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/pagamento")
    public ResponseEntity<Page<com.camelo.camelobackend.domain.Cartao>> pagamentoGet(
            @RequestHeader(value="Authorization") String authorization,
            @RequestParam(value="page", defaultValue="0", required = false) Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24", required = false) Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="nome", required = false) String orderBy,
            @RequestParam(value="direction", defaultValue="ASC", required = false) String direction) {

        var response = listarPagamentosDoUsuarioUseCase.executar(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(response);
    }

}
