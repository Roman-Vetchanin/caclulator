package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorServiceImpl) {
        this.calculatorService = calculatorServiceImpl;
    }

    @GetMapping(path = "calculator")
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "calculator/sum")
    public String sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.sum(num1,num2);
    }

    @GetMapping(path = "calculator/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.minus(num1,num2);
    }

    @GetMapping(path = "calculator/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping(path = "calculator/divide")
    public String divide(@RequestParam(required = true, value = "num1") int num1, @RequestParam(required = true, value = "num2") int num2) {
        return calculatorService.divide(num1, num2);
    }
}
