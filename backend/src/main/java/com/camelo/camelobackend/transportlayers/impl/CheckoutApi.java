package com.camelo.camelobackend.transportlayers.impl;

import com.camelo.camelobackend.domain.Pedido;
import com.camelo.camelobackend.interactors.MontarCarrinhoPedidoUseCase;
import com.camelo.camelobackend.transportlayers.dto.Carrinho;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutApi {

    private final MontarCarrinhoPedidoUseCase montarCarrinhoPedidoUseCase;

    public CheckoutApi(MontarCarrinhoPedidoUseCase montarCarrinhoPedidoUseCase) {
        this.montarCarrinhoPedidoUseCase = montarCarrinhoPedidoUseCase;
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @PostMapping(value = "/")
    public ResponseEntity<Pedido> checkout(@RequestBody Carrinho carrinho) {
        var response = montarCarrinhoPedidoUseCase.executar(carrinho);
        return ResponseEntity.ok(response);
    }
}
