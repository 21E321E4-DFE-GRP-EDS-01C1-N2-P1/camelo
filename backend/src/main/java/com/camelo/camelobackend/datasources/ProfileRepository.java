package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.ProfileData;
import com.camelo.camelobackend.datasources.h2.mapper.ProfileMapper;
import com.camelo.camelobackend.domain.Profile;
import com.camelo.camelobackend.ports.ProfilePort;
import org.springframework.stereotype.Component;

@Component
public class ProfileRepository implements ProfilePort {

    private final ProfileData profileData;
    private final ProfileMapper mapper;

    public ProfileRepository(ProfileData profileData) {
        this.profileData = profileData;
        this.mapper = ProfileMapper.INSTANCE;
    }

    @Override
    public Profile buscarPor(String email) {
        var profileModel = profileData.findByEmail(email);
        return mapper.map(profileModel);
    }
}
