package com.camelo.camelobackend.transportlayers.cron;

import com.camelo.camelobackend.domain.objectvalues.Situacao;
import com.camelo.camelobackend.interactors.NotificarSituacaoPedidoUseCase;
import com.camelo.camelobackend.ports.PedidoPort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificarEmProcessamento {

    private static final long SEGUNDO = 1000;
    private static final long MINUTO = SEGUNDO * 60;
    private static final String TIME_ZONE = "America/Sao_Paulo";
    private static final String EM_PROCESSAMENTO = Situacao.EM_PROCESSAMENTO.getDescricao();
    private final PedidoPort pedidoPort;
    private final NotificarSituacaoPedidoUseCase notificarSituacaoPedidoUseCase;

    public NotificarEmProcessamento(PedidoPort pedidoPort, NotificarSituacaoPedidoUseCase notificarSituacaoPedidoUseCase) {
        this.pedidoPort = pedidoPort;
        this.notificarSituacaoPedidoUseCase = notificarSituacaoPedidoUseCase;
    }

    @Scheduled(fixedDelay = MINUTO * 2, zone = TIME_ZONE)
    public void executar() {
        var pedidos = pedidoPort.pesquisarPedidos(EM_PROCESSAMENTO);

        pedidos.forEach(pedido -> {
            notificarSituacaoPedidoUseCase.executar(pedido);

            pedido.setSituacao(Situacao.EM_PROCESSAMENTO.getDescricao());
            pedidoPort.salvar(pedido);
        });
    }
}
