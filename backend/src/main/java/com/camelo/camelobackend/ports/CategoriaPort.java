package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Categoria;

import java.util.List;

public interface CategoriaPort {
    List<Categoria> categorias();
}
