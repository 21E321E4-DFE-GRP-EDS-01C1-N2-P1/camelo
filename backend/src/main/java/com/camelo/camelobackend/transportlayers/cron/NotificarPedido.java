package com.camelo.camelobackend.transportlayers.cron;

import com.camelo.camelobackend.domain.objectvalues.Situacao;
import com.camelo.camelobackend.interactors.NotificarSituacaoPedidoUseCase;
import com.camelo.camelobackend.ports.PedidoPort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificarPedido {

    private static final long SEGUNDO = 1000;
    private static final long MINUTO = SEGUNDO * 60;
    private static final String TIME_ZONE = "America/Sao_Paulo";
    private static final String EM_PROCESSAMENTO = Situacao.EM_PROCESSAMENTO.getDescricao();
    private static final String PROCESSADO = Situacao.PROCESSADO.getDescricao();
    private static final String EM_TRANSPORTE = Situacao.EM_TRANSPORTE.getDescricao();
    private static final String CANCELADO = Situacao.CANCELADO.getDescricao();
    private final PedidoPort pedidoPort;
    private final NotificarSituacaoPedidoUseCase notificarSituacaoPedidoUseCase;

    public NotificarPedido(PedidoPort pedidoPort, NotificarSituacaoPedidoUseCase notificarSituacaoPedidoUseCase) {
        this.pedidoPort = pedidoPort;
        this.notificarSituacaoPedidoUseCase = notificarSituacaoPedidoUseCase;
    }

    @Scheduled(fixedDelay = MINUTO, zone = TIME_ZONE)
    public void emProcessamento() {
        var pedidos = pedidoPort.pesquisarPedidos(EM_PROCESSAMENTO);

        pedidos.forEach(pedido -> {
            notificarSituacaoPedidoUseCase.executar(pedido);

            pedido.setSituacao(Situacao.PROCESSADO.getDescricao());
            pedidoPort.salvar(pedido);
        });
    }

    @Scheduled(fixedDelay = MINUTO, zone = TIME_ZONE)
    public void processado() {
        var pedidos = pedidoPort.pesquisarPedidos(PROCESSADO);

        pedidos.forEach(pedido -> {
            notificarSituacaoPedidoUseCase.executar(pedido);

            pedido.setSituacao(Situacao.EM_TRANSPORTE.getDescricao());
            pedidoPort.salvar(pedido);
        });
    }

    @Scheduled(fixedDelay = MINUTO, zone = TIME_ZONE)
    public void cancelarEmTransporte() {
        var pedidos = pedidoPort.pesquisarPedidos(EM_TRANSPORTE);

        pedidos.forEach(pedido -> {
            notificarSituacaoPedidoUseCase.executar(pedido);

            if (pedido.getId() % 2 == 1) {
                pedido.setSituacao(Situacao.CANCELADO.getDescricao());
                pedidoPort.salvar(pedido);
            }
        });
    }

    @Scheduled(fixedDelay = MINUTO, zone = TIME_ZONE)
    public void cancelado() {
        var pedidos = pedidoPort.pesquisarPedidos(CANCELADO);
        pedidos.forEach(notificarSituacaoPedidoUseCase::executar);
    }

    @Scheduled(fixedDelay = MINUTO, zone = TIME_ZONE)
    public void finalizar() {
        var pedidos = pedidoPort.pesquisarPedidos(CANCELADO);
        pedidos.forEach(it -> {
            it.setSituacao(Situacao.FINALIZADO.getDescricao());
            pedidoPort.salvar(it);
        });
    }
}
