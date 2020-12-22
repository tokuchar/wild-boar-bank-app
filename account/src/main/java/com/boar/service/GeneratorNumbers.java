package com.boar.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.Stream;

@Service
public final class GeneratorNumbers {
    private static final Random random = new Random();
    private static final String BANK_IDENTIFICATION_NUMBER = "400000";

    public static String pinGenerator() {
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            pin.append(random.nextInt(9));
        }
        return String.valueOf(pin);
    }

    public static String cvcGenerator() {
        StringBuilder cvc = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            cvc.append(random.nextInt(9));
        }
        return String.valueOf(cvc);
    }

    public static String accountNumberGenerator() {
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(9));
        }
        return String.valueOf(accountNumber);
    }

    private static String createControlNumberUseAlgorithmLuhn(String digitsToCheck) {
        int sum = 0;
        int checkDigit = 0;

        int[] digits = StringArrayToIntArray(digitsToCheck.split(""));
        for (int i = 0; i < 16; i = i + 2) {
            digits[i] = digits[i] * 2;
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 9;
            }
        }
        for (int digit : digits) {
            sum = sum + digit;
        }
        if (sum % 10 != 0) {
            checkDigit = 10 - (sum % 10);
        }
        return String.valueOf(checkDigit);
    }

    public static String cardNumberGenerator() {
        StringBuilder cardNumber = new StringBuilder();
        cardNumber.append(BANK_IDENTIFICATION_NUMBER);
        for (int i = 0; i < 9; i++) {
            cardNumber.append(random.nextInt(9));
        }

//        int[] digits = StringArrayToIntArray(cardNumber.toString().split(""));
//        for (int i = 0; i < 16; i = i + 2) {
//            digits[i] = digits[i] * 2;
//            if (digits[i] >= 10) {
//                digits[i] = digits[i] - 9;
//            }
//        }
//        for (int digit : digits) {
//            sum = sum + digit;
//        }
//        if (sum % 10 != 0) {
//            checkDigit = 10 - (sum % 10);
//        }
        return String.valueOf(cardNumber.append(createControlNumberUseAlgorithmLuhn(cardNumber.toString())));
    }

    private static int[] StringArrayToIntArray(String[] stringArray) {
        return Stream.of(stringArray).mapToInt(Integer::parseInt).toArray();
    }
}
