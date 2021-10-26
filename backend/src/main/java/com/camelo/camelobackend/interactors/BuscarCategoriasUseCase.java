package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Categoria;
import com.camelo.camelobackend.ports.CategoriaPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarCategoriasUseCase {

    private final CategoriaPort port;

    public BuscarCategoriasUseCase(CategoriaPort port) {
        this.port = port;
    }

    public List<Categoria> executar() {
        return port.categorias();
    }
}
