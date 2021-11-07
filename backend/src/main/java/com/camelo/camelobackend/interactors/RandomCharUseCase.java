package com.camelo.camelobackend.interactors;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomCharUseCase {

    private final Random random;

    public RandomCharUseCase() {
        this.random = new Random();
    }

    public char execute() {
        var opt = random.nextInt(3);

        if (opt == 0) {
            return (char) (random.nextInt(10) + 48);
        } else if (opt == 1) {
            return (char) (random.nextInt(26) + 65);
        } else {
            return (char) (random.nextInt(26) + 97);
        }
    }
}
