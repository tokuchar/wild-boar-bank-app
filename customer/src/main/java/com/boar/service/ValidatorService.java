package com.boar.service;

import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashMap;

@Service
public class ValidatorService {
    final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    final Validator validator = validatorFactory.getValidator();

    public boolean checkIfIdentityIsCorrect(String identity) {
        if (!identity.matches("[A-Z]{3}\\d{6}")) return false;

        HashMap<String, Integer> alphabetWithAssignedValues = new HashMap<>(26);
        HashMap<Integer, Integer> weightOfNumber = new HashMap<>(3);

        String controlNumberIdentity = identity.substring(3, 4);
        String numbersIdentityForCalculations = identity.substring(0, 3) + identity.substring(4);
        String[] tableNumbersIdentityForCalculations = numbersIdentityForCalculations.split("");

        int numberOfCharacter = 10;
        int count = 0;
        int sum = 0;

        weightOfNumber.put(1, 7);
        weightOfNumber.put(2, 3);
        weightOfNumber.put(3, 1);

        for (char a = 'A'; a <= 'Z'; a++) {
            alphabetWithAssignedValues.put(String.valueOf(a), numberOfCharacter);
            numberOfCharacter++;
        }
        for (String key : tableNumbersIdentityForCalculations) {
            count++;

            if (count == 4) count = 1;

            try {
                sum = sum + Integer.parseInt(key) * weightOfNumber.get(count);
            } catch (Exception e) {
                sum = sum + alphabetWithAssignedValues.get(key) * weightOfNumber.get(count);
            }
        }
        return controlNumberIdentity.equals(String.valueOf(sum % 10));
    }
}