package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileData extends JpaRepository<ProfileModel, Long>{

    ProfileModel findByEmail(String email);
}
