package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleData extends JpaRepository<RoleModel, Long> {

    RoleModel findByName(String name);
}
