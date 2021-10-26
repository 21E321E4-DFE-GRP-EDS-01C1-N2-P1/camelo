package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.BuscarProdutoPorIdUseCase;
import com.camelo.camelobackend.interactors.CadastrarProdutoUseCase;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoResponseMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.ProdutoApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/")
public class ProdutosApiImpl implements ProdutoApi {

    private final ProdutoResponseMapper mapper;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    public ProdutosApiImpl(CadastrarProdutoUseCase cadastrarProdutoUseCase, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
        this.mapper = ProdutoResponseMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<Produto> produtoGet(@RequestParam(value = "idProduto") BigDecimal idProduto) {
        var produtoLocalizado = buscarProdutoPorIdUseCase.executar(idProduto.longValue());
        var response = mapper.map(produtoLocalizado);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Produto> produtoPost(@RequestBody Produto produto) {
        var request = mapper.map(produto);
        var produtoCadastrado = cadastrarProdutoUseCase.executar(request);
        var response = mapper.map(produtoCadastrado);

        URI uri = fromCurrentRequest().queryParam("idProduto", produtoCadastrado.getId())
                .buildAndExpand(produtoCadastrado.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
