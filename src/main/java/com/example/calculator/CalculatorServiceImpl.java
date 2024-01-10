package com.example.calculator;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {

    public String welcome() {
        return "Добро пожаловать в калькулятор";

    }

    public Object sum(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из параметров пуст";
        } else {
            return num1 + num2;
        }
    }

    public Object minus(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из параметров пуст";
        } else {
            return num1 - num2;
        }
    }

    public Object multiply(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из параметров пуст";
        } else{
            return num1 * num2;
        }
    }

    public Object divide(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            return "Один из параметров пуст";
        } else if (num2==0) {
            throw new IllegalArgumentException();
        } else {
            return num1 / num2;
        }
    }

}
