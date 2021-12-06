package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.PedidoData;
import com.camelo.camelobackend.datasources.h2.mapper.PedidoModelMapper;
import com.camelo.camelobackend.domain.Pedido;
import com.camelo.camelobackend.ports.PedidoPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoRepository implements PedidoPort {

    private final PedidoData data;
    private final PedidoModelMapper mapper;

    public PedidoRepository(PedidoData data) {
        this.data = data;
        this.mapper = Mappers.getMapper(PedidoModelMapper.class);
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        var pedidoModel = mapper.map(pedido);
        pedidoModel.getItens().forEach(it -> it.setPedidoModel(pedidoModel));

        var persisted = data.save(pedidoModel);
        return mapper.map(persisted);
    }

    @Override
    public List<Pedido> pesquisarPedidos(String situacao) {
        var pedidos = new ArrayList<Pedido>();
        var pedidosModel = data.findAllBySituacao(situacao);
        pedidosModel.forEach(it -> {
            pedidos.add(mapper.map(it));
        });
        return pedidos;
    }
}
