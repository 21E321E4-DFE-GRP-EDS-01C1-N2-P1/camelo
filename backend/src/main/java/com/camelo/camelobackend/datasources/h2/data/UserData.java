package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserData extends JpaRepository<UserModel, Long>{

    @Transactional(readOnly=true)
    @Query(
            "SELECT obj FROM USER obj " +
                    "inner join fetch obj.roles roles " +
                    "where obj.email = :email "
    )
    UserModel buscarPorEmail(String email);
}
