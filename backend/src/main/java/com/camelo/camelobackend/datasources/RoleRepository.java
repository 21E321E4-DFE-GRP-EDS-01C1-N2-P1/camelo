package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.RoleData;
import com.camelo.camelobackend.datasources.h2.mapper.RoleMapper;
import com.camelo.camelobackend.domain.Role;
import com.camelo.camelobackend.ports.RolePort;
import org.springframework.stereotype.Component;

@Component
public class RoleRepository implements RolePort {

    private final RoleData data;

    private final RoleMapper mapper;

    public RoleRepository(RoleData data) {
        this.data = data;
        this.mapper = RoleMapper.INSTANCE;
    }

    @Override
    public Role buscarPor(String name) {
        var roleModel = data.findByName(name);
        return mapper.map(roleModel);
    }
}
