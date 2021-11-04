package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.RoleData;
import com.camelo.camelobackend.datasources.h2.mapper.RoleMapper;
import com.camelo.camelobackend.domain.Funcao;
import com.camelo.camelobackend.ports.FuncaoPort;
import org.springframework.stereotype.Component;

@Component
public class FuncaoRepository implements FuncaoPort {

    private final RoleData data;

    private final RoleMapper mapper;

    public FuncaoRepository(RoleData data) {
        this.data = data;
        this.mapper = RoleMapper.INSTANCE;
    }

    @Override
    public Funcao buscarPor(String name) {
        var roleModel = data.findByName(name);
        return mapper.map(roleModel);
    }
}
