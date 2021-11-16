package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.BuscarProdutoPorIdUseCase;
import com.camelo.camelobackend.interactors.BuscarProdutosCategorizadoUseCase;
import com.camelo.camelobackend.interactors.BuscarProdutosEmPromocaoUseCase;
import com.camelo.camelobackend.interactors.CadastrarProdutoUseCase;
import com.camelo.camelobackend.transportlayers.dto.Produto;
import com.camelo.camelobackend.transportlayers.dto.ProdutoCategorizado;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoResponseMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public class ProdutosApiImpl {

    private final ProdutoResponseMapper mapper;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;
    private final BuscarProdutosEmPromocaoUseCase produtosEmPromocaoUseCase;
    private final BuscarProdutosCategorizadoUseCase produtosCategorizadoUseCase;

    public ProdutosApiImpl(CadastrarProdutoUseCase cadastrarProdutoUseCase, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase, BuscarProdutosEmPromocaoUseCase produtosEmPromocaoUseCase, BuscarProdutosCategorizadoUseCase produtosCategorizadoUseCase) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
        this.produtosEmPromocaoUseCase = produtosEmPromocaoUseCase;
        this.produtosCategorizadoUseCase = produtosCategorizadoUseCase;
        this.mapper = ProdutoResponseMapper.INSTANCE;
    }

    @ApiOperation(value = "", nickname = "produtosGet", notes = "", response = Produto.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Produto.class),
            @ApiResponse(code = 204, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @GetMapping(
            value = "/produtos",
            produces = { "application/json" }
    )
    public ResponseEntity<Produto> produtosGet(@RequestParam(value = "idProduto") BigDecimal idProduto) {
        var produtoLocalizado = buscarProdutoPorIdUseCase.executar(idProduto.longValue());
        var response = mapper.map(produtoLocalizado);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @ApiOperation(value = "", nickname = "produtosPost", notes = "", response = Produto.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "", response = Produto.class),
            @ApiResponse(code = 400, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @PostMapping(
            value = "/produtos",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<Produto> produtosPost(@RequestBody Produto produto) {
        var request = mapper.map(produto);
        var produtoCadastrado = cadastrarProdutoUseCase.executar(request);
        var response = mapper.map(produtoCadastrado);

        URI uri = fromCurrentRequest().queryParam("idProduto", produtoCadastrado.getId())
                .buildAndExpand(produtoCadastrado.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @ApiOperation(value = "", nickname = "produtosPromocaoGet", notes = "", response = Produto.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos em promoção", response = Produto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @GetMapping(
            value = "/produtos/promocao",
            produces = { "application/json" }
    )
    public ResponseEntity<List<Produto>> produtosPromocaoGet() {
        ProdutoResponseMapper mapper = ProdutoResponseMapper.INSTANCE;

        var resposta = produtosEmPromocaoUseCase.executar();
        var response = resposta.stream().map(mapper::map).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "", nickname = "produtosCategorizadoGet", notes = "", response = ProdutoCategorizado.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ProdutoCategorizado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @GetMapping(
            value = "/produtos/categorizado",
            produces = { "application/json" }
    )
    public ResponseEntity<List<ProdutoCategorizado>> produtosCategorizadoGet() {
        var response = produtosCategorizadoUseCase.executar();
        return ResponseEntity.ok(response);
    }
}
