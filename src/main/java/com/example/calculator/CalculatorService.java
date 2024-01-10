package com.example.calculator;


public interface CalculatorService {
    String welcome();
    Object sum(Integer num1, Integer num2);

    Object minus(Integer num1, Integer num2);

    Object multiply(Integer num1, Integer num2);

    Object divide(Integer num1, Integer num2);

}
