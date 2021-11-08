package com.camelo.camelobackend.configurations;

import com.camelo.camelobackend.interactors.EmailService;
import com.camelo.camelobackend.interactors.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class TestConfig {


}
