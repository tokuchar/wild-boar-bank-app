package com.boar.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public final class GeneratorNumbers {
    private static final Random random = new Random();
    private static final StringBuilder pin = new StringBuilder();
    private static final StringBuilder cvc = new StringBuilder();
    private static final StringBuilder cardNumber = new StringBuilder();

    public static String pinGenerator() {
        for (int i = 0; i < 4; i++) {
            pin.append(random.nextInt(9));
        }
        return String.valueOf(pin);
    }

    public static String cvcGenerator() {
        for (int i = 0; i < 3; i++) {
            cvc.append(random.nextInt(9));
        }
        return String.valueOf(cvc);
    }

    public static String cardNumberGenerator() { //TODO Luhn
        for (int i = 0; i < 10; i++) {
            cardNumber.append(random.nextInt(9));
        }
        return String.valueOf(cardNumber);
    }
}