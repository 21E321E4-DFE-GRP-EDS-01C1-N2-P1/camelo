package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.ItemPedido;
import com.camelo.camelobackend.domain.Pedido;
import com.camelo.camelobackend.ports.PedidoPort;
import com.camelo.camelobackend.ports.ProdutoPort;
import com.camelo.camelobackend.transportlayers.dto.Carrinho;
import com.camelo.camelobackend.transportlayers.dto.Selecao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static java.util.Objects.nonNull;

@Service
public class MontarCarrinhoPedidoUseCase {

    private final ProdutoPort produtoPort;
    private final PedidoPort pedidoPort;

    public MontarCarrinhoPedidoUseCase(ProdutoPort produtoPort, PedidoPort pedidoPort) {
        this.produtoPort = produtoPort;
        this.pedidoPort = pedidoPort;
    }

    public Pedido executar(Carrinho carrinho) {

        var userSS = UserService.authenticated();
        var itensPedidos = new ArrayList<ItemPedido>();

        if (nonNull(userSS)) {
            for (Selecao produto : carrinho.getProdutos()) {
                itensPedidos.add( new ItemPedido(produtoPort.obterPor(produto.getId()).getId(), produto.getQtd()));
            }
            if (itensPedidos.isEmpty()) {
                throw new RuntimeException("O carrinho não pode estar vazio.");
            } else {
                var pedido = new Pedido(itensPedidos, userSS.getId(), carrinho.getPagamento().getNrCartao());
                return pedidoPort.salvar(pedido);
            }
        }

        throw new RuntimeException("Usuário não ");
    }
}
