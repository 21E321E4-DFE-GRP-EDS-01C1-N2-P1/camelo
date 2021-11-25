package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.MontarCarrinhoPedidoUseCase;
import com.camelo.camelobackend.transportlayers.dto.Carrinho;
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
    public void checkout(@RequestBody Carrinho carrinho) {
        montarCarrinhoPedidoUseCase.executar(carrinho);
    }
}
