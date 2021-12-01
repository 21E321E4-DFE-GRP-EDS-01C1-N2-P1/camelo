package com.camelo.camelobackend.transportlayers.impl;

import com.camelo.camelobackend.interactors.BuscarCategoriasUseCase;
import com.camelo.camelobackend.transportlayers.mapper.CategoriaReponseMapper;
import com.camelo.camelobackend.transportlayers.openapi.api.CategoriasApi;
import com.camelo.camelobackend.transportlayers.openapi.model.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class CategoriasApiImpl implements CategoriasApi {

    private final BuscarCategoriasUseCase buscarCategoriasUseCase;
    private final CategoriaReponseMapper mapper;

    public CategoriasApiImpl(BuscarCategoriasUseCase buscarCategoriasUseCase) {
        this.buscarCategoriasUseCase = buscarCategoriasUseCase;
        this.mapper = CategoriaReponseMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<List<Categoria>> categoriasGet() {
        var categorias = buscarCategoriasUseCase.executar();
        var response = categorias.stream().map(mapper::map).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
