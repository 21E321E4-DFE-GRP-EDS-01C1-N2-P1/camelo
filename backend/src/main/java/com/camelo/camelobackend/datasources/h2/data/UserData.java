package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserData extends JpaRepository<UserModel, Long>{

    UserModel findByEmail(String email);
}
