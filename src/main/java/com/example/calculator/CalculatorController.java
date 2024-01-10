package com.example.calculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping(path = "/sum")
    public Object sum(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
            return num1 + " + " + num2 + " = " + calculatorService.sum(num1,num2);
    }

    @GetMapping(path = "/minus")
    public Object minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
           return num1 + " - " + num2 + " = " + calculatorService.minus(num1,num2);
    }

    @GetMapping(path = "/multiply")
    public Object multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public Object divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        try {
            return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
        } catch (IllegalArgumentException e) {
            return "Делить на 0 нельзя";
        }
    }
}
