package com.camelo.camelobackend.interactors;

import org.springframework.stereotype.Service;

@Service
public class NewPasswordUseCase {

    private final RandomCharUseCase randomCharUseCase;

    public NewPasswordUseCase(RandomCharUseCase randomCharUseCase) {
        this.randomCharUseCase = randomCharUseCase;
    }

    public String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomCharUseCase.execute();
        }

        return new String(vet);
    }
}
