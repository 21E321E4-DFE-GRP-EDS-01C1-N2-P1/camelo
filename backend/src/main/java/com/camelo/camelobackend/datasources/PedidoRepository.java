package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.PedidoData;
import com.camelo.camelobackend.datasources.h2.mapper.PedidoModelMapper;
import com.camelo.camelobackend.domain.Pedido;
import com.camelo.camelobackend.ports.PedidoPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

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
}
