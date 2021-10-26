package com.camelo.camelobackend.datasources.h2;

import com.camelo.camelobackend.datasources.h2.data.CategoriaData;
import com.camelo.camelobackend.datasources.h2.mapper.CategoriaModelMapper;
import com.camelo.camelobackend.datasources.h2.model.CategoriaModel;
import com.camelo.camelobackend.domain.Categoria;
import com.camelo.camelobackend.ports.CategoriaPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaRepository implements CategoriaPort {

    private final CategoriaData data;
    private final CategoriaModelMapper mapper;

    public CategoriaRepository(CategoriaData data) {
        this.data = data;
        this.mapper = CategoriaModelMapper.INSTANCE;
    }

    @Override
    public List<Categoria> categorias() {
        var categoriasModel = (List<CategoriaModel>) data.findAll();
        return categoriasModel.stream().map(mapper::map).collect(Collectors.toList());
    }
}
