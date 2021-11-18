package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.*;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoResponseMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.ProdutosApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Produto;
import com.camelo.camelobackend.transportlayers.openapi.model.ProdutoCategorizado;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/")
public class ProdutosApiImpl implements ProdutosApi {

    private final ProdutoResponseMapper mapper;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;
    private final BuscarProdutosEmPromocaoUseCase produtosEmPromocaoUseCase;
    private final BuscarProdutosCategorizadoUseCase produtosCategorizadoUseCase;
    private final BuscarProdutoCategorizadoPorIdUseCase buscarProdutoCategorizadoPorIdUseCase;

    public ProdutosApiImpl(CadastrarProdutoUseCase cadastrarProdutoUseCase, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase, BuscarProdutosEmPromocaoUseCase produtosEmPromocaoUseCase, BuscarProdutosCategorizadoUseCase produtosCategorizadoUseCase, BuscarProdutoCategorizadoPorIdUseCase buscarProdutoCategorizadoPorIdUseCase) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
        this.produtosEmPromocaoUseCase = produtosEmPromocaoUseCase;
        this.produtosCategorizadoUseCase = produtosCategorizadoUseCase;
        this.buscarProdutoCategorizadoPorIdUseCase = buscarProdutoCategorizadoPorIdUseCase;
        this.mapper = ProdutoResponseMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<List<Produto>> produtosPromocaoGet() {
        ProdutoResponseMapper mapper = ProdutoResponseMapper.INSTANCE;
        var resposta = produtosEmPromocaoUseCase.executar();
        var response = resposta.stream().map(mapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Produto> produtosGet(@RequestParam(value = "idProduto") BigDecimal idProduto) {
        var produto = buscarProdutoPorIdUseCase.executar(idProduto.longValue());
        var response = mapper.map(produto);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ProdutoCategorizado>> produtosCategorizadoGet() {
        var response = produtosCategorizadoUseCase.executar();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ProdutoCategorizado> produtosCategorizadoIdGet(@PathVariable("id") BigDecimal id) {
        var response = buscarProdutoCategorizadoPorIdUseCase.executar(id);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @Override
    public ResponseEntity<Produto> produtosPost(@RequestBody Produto produto) {
        var request = mapper.map(produto);
        var produtoCadastrado = cadastrarProdutoUseCase.executar(request);
        var response = mapper.map(produtoCadastrado);
        URI uri = fromCurrentRequest().queryParam("idProduto", produtoCadastrado.getId())
                .buildAndExpand(produtoCadastrado.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
