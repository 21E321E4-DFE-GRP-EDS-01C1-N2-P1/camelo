package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.AdicionarFormaDePagamentoUseCase;
import com.camelo.camelobackend.interactors.ListarPagamentosDoUsuarioUseCase;
import com.camelo.camelobackend.transportlayers.dto.Cartao;
import com.camelo.camelobackend.transportlayers.mapper.CartaoMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/")
public class PagamentoApiImpl {

    private final AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase;
    private final ListarPagamentosDoUsuarioUseCase listarPagamentosDoUsuarioUseCase;
    private final CartaoMapper mapper;

    public PagamentoApiImpl(AdicionarFormaDePagamentoUseCase adicionarFormaDePagamentoUseCase, ListarPagamentosDoUsuarioUseCase listarPagamentosDoUsuarioUseCase) {
        this.adicionarFormaDePagamentoUseCase = adicionarFormaDePagamentoUseCase;
        this.listarPagamentosDoUsuarioUseCase = listarPagamentosDoUsuarioUseCase;
        mapper = Mappers.getMapper(CartaoMapper.class);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @ApiOperation(value = "", nickname = "pagamentoPost", notes = "", response = Cartao.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Cartao.class),
            @ApiResponse(code = 400, message = "", response = Error.class),
            @ApiResponse(code = 401, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @PostMapping(
            value = "/pagamento",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<Cartao> pagamentoPost(
            @RequestHeader(value="Authorization") String authorization,
            @RequestBody Cartao cartao) {

        var cartaoDomain = mapper.map(cartao);
        var cartaoSalvo = adicionarFormaDePagamentoUseCase.executar(cartaoDomain);
        var response = mapper.map(cartaoSalvo);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @ApiOperation(value = "", nickname = "pagamentoGet", notes = "", response = Cartao.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Cartao.class, responseContainer = "List") })
    @GetMapping(
            value = "/pagamento",
            produces = { "application/json" }
    )
    public ResponseEntity<List<Cartao>> pagamentoGet(@RequestHeader(value="Authorization") String authorization) {
        var cartoes = listarPagamentosDoUsuarioUseCase.executar();
        var response = cartoes.stream().map(mapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
