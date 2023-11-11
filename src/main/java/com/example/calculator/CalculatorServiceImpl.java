package com.example.calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public String welcome() {
        return """
                Добро пожаловать в калькулятор\s
                 Для сложения /calculator/sum?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО
                Для вычитания /calculator/minus?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО
                Для умножения /calculator/multiply?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО
                Для деления /calculator/divide?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО""";
    }

    public int sum(Integer num1, Integer num2) {
        return num1+num2;
    }

    public int minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public int multiply(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public int divide(Integer num1, Integer num2) {
            return num1 / num2;
    }

}
