package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.ProfileData;
import com.camelo.camelobackend.datasources.h2.mapper.ProfileMapper;
import com.camelo.camelobackend.domain.Perfil;
import com.camelo.camelobackend.ports.PefilPort;
import org.springframework.stereotype.Component;

@Component
public class PefilRepository implements PefilPort {

    private final ProfileData profileData;
    private final ProfileMapper mapper;

    public PefilRepository(ProfileData profileData) {
        this.profileData = profileData;
        this.mapper = ProfileMapper.INSTANCE;
    }

    @Override
    public Perfil buscarPor(String email) {
        var profileModel = profileData.findByEmail(email);
        return mapper.map(profileModel);
    }
}
