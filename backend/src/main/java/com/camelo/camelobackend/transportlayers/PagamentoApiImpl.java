package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.AdicionarFormaDePagamentoUseCase;
import com.camelo.camelobackend.transportlayers.mapper.CartaoMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.PagamentoApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Cartao;
import com.camelo.camelobackend.transportlayers.openapi.model.Categoria;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PagamentoApiImpl implements PagamentoApi {

    private final AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase;

    public PagamentoApiImpl(AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase) {
        this.adicionarFormaDePagamentoUseCase = adicionarFormaDePagamentoUseCase;
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    public ResponseEntity<List<Categoria>> pagamentoPost(
            @RequestHeader(value="Authorization") String authorization,
            @RequestBody Cartao cartao) {

        var mapper = Mappers.getMapper(CartaoMapper.class);

        var cartaoDomain = mapper.map(cartao);

        adicionarFormaDePagamentoUseCase.executar(cartaoDomain);

        return null;
    }

}
