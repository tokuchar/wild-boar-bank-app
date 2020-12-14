package com.boar.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public final class GeneratorNumbers {

    public static String pinGenerator() {
        Random random = new Random();
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            pin.append(random.nextInt(9));
        }
        return String.valueOf(pin);
    }
}