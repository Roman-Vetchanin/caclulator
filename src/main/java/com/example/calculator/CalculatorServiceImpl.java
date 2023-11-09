package com.example.calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public String welcome() {
        return "Добро пожаловать в калькулятор\n Для сложения /calculator/sum?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО\n" +
                "Для вычитания /calculator/minus?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО\n" +
                "Для умножения /calculator/multiply?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО\n" +
                "Для деления /calculator/divide?num1=ВАШЕ_ЧИСЛО&num2=ВАШЕ_ЧИСЛО";
    }

    public String sum(int num1, int num2) {
        int sum = num1 + num2;
        return num1+" + " + num2 +" = "+ sum;
    }

    public String minus(int num1, int num2) {
        int min = num1 - num2;
        return num1+" - " + num2 +" = "+ min;
    }

    public String multiply(int num1, int num2) {
        int multi = num1 * num2;
        return num1+" * " + num2 +" = "+ multi;
    }

    public String divide(int num1, int num2) {
        if ((num1 & num2) == 0) {
            return "На ноль делить нельзя";
        }  else {
            int div = num1 / num2;
            return num1 + " / " + num2 + " = " + div;
        }
    }

}
