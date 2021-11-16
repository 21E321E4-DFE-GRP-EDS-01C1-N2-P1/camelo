package com.camelo.camelobackend.transportlayers;

import com.camelo.camelobackend.interactors.BuscarCategoriasUseCase;
import com.camelo.camelobackend.transportlayers.dto.Categoria;
import com.camelo.camelobackend.transportlayers.mapper.CategoriaReponseMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class CategoriasApiImpl {

    private final BuscarCategoriasUseCase buscarCategoriasUseCase;
    private final CategoriaReponseMapper mapper;

    public CategoriasApiImpl(BuscarCategoriasUseCase buscarCategoriasUseCase) {
        this.buscarCategoriasUseCase = buscarCategoriasUseCase;
        this.mapper = CategoriaReponseMapper.INSTANCE;
    }

    @ApiOperation(value = "", nickname = "categoriasGet", notes = "", response = Categoria.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = Categoria.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "", response = Error.class),
            @ApiResponse(code = 404, message = "", response = Error.class),
            @ApiResponse(code = 500, message = "", response = Error.class) })
    @GetMapping(
            value = "/categorias",
            produces = { "application/json" }
    )
    public ResponseEntity<List<Categoria>> categoriasGet() {
        var categorias = buscarCategoriasUseCase.executar();
        var response = categorias.stream().map(mapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
