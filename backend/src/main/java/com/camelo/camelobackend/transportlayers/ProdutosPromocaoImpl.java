package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.BuscarProdutosEmPromocaoUseCase;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoResponseMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.ProdutosApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class ProdutosPromocaoImpl implements ProdutosApi {

    private final BuscarProdutosEmPromocaoUseCase produtosEmPromocaoUseCase;

    public ProdutosPromocaoImpl(BuscarProdutosEmPromocaoUseCase useCase) {
        this.produtosEmPromocaoUseCase = useCase;
    }

    @Override
    public ResponseEntity<List<Produto>> produtosPromocaoGet() {
        ProdutoResponseMapper mapper = ProdutoResponseMapper.INSTANCE;

        var resposta = produtosEmPromocaoUseCase.executar();
        var response = resposta.stream().map(mapper::map).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
