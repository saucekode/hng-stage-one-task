package com.hng.hng_stage_one.NumberClassificationAPI;

import com.hng.hng_stage_one.NumberClassificationAPI.exceptions.NumClassException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NumClassService {

    @Value("${math.trivia.url:http://numbersapi.com}")
    private String mathTriviaURL;


    private final RestTemplate restTemplate;

    public NumClassService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Map<String, Object>> classifyNumber(String number) {
        validateInput(number);

        Map<String, Object> numberClassification = new HashMap<>();
        numberClassification.put("number", number);
        numberClassification.put("is_prime", isPrimeNumber(Long.parseLong(number)));
        numberClassification.put("is_perfect", isPerfectNumber(Long.parseLong(number)));
        numberClassification.put("properties", generateProperties(Long.parseLong(number)));
        numberClassification.put("digit_sum", sumNumberDigit(Long.parseLong(number)));
        numberClassification.put("fun_fact", generateNumberFunFact(Long.parseLong(number)));
        return ResponseEntity.ok(numberClassification);
    }

    private void validateInput(String number) {
        if(number.matches("^[a-zA-Z]+$")){
            throw new NumClassException("alphabet", true);
        }

        else if(number.matches("[0-9]+[/][0-9]+")){
            throw new NumClassException("fraction", true);
        }

        else if(number.matches("[0-9]+[.][0-9]+")){
            throw new NumClassException("decimal", true);
        }
    }

    private boolean isPrimeNumber(long number){
        return BigInteger.valueOf(number).isProbablePrime(100);
    }

    private boolean isPerfectNumber(long number){
        int sum = 1;
        for (int i = 2; (long) i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) sum += (int) (number / i);
            }
        }
        return sum == number;
    }

    private List<String> generateProperties(long number){
        List<String> properties = new ArrayList<>();

        if(isNumberArmstrong(number)){
            properties.add("armstrong");
        }
        properties.add(isNumberOddOrEven(number));
        return properties;
    }

    private String isNumberOddOrEven(long number){
        if(number % 2 == 0){
            return "even";
        }

        return "odd";
    }

    public static boolean isNumberArmstrong(long number) {
        long originalNumber = number;
        long sum = 0;
        long digits = String.valueOf(number).length();

        while (number > 0) {
            long digit = number % 10;
            sum += (long) Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    private long sumNumberDigit(long number){
        long sum = 0;
        if(String.valueOf(number).length() == 1){
            return number;
        }
        char[] chars = String.valueOf(number).toCharArray();
        for(char c : chars){
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    private String generateNumberFunFact(long number) {
        String response = restTemplate.getForObject(mathTriviaURL + "/" + number + "/math", String.class);
        if(response != null){
            return response;
        }
        throw new NumClassException(String.format("Unable to process fun-fact for %d", number), true);
    }
}
