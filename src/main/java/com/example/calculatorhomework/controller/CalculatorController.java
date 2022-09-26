package com.example.calculatorhomework.controller;

import com.example.calculatorhomework.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    private  final CalculatorService calculatorService;

    @GetMapping()
    public String welcomePage(){
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    @GetMapping("/plus")
    public String plus (@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "Один из парметров не введён";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + " = " + plus;
    }

    @GetMapping("/minus")
    public String minus (@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "Один из парметров не введён";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + " = " + minus;
    }

    @GetMapping("/multiply")
    public String multiplication (@RequestParam(name = "num1", required = false) Integer a,
                                  @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "Один из парметров не введён";
        int multiplication = calculatorService.multiplication(a, b);
        return a + " * " + b + " = " + multiplication;
    }

    @GetMapping("/divide")
    public String division (@RequestParam(name = "num1", required = false) Integer a,
                            @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "Один из парметров не введён";
        if (b == 0) return "На ноль делить нельзя";
        int divisionWithoutRemainder = calculatorService.divisionWithoutRemainder(a, b);
        if (a % b == 0) return a + " / " + b + " = " + divisionWithoutRemainder;
        double division = calculatorService.division(a, b);
        return a + " / " + b + " = " + division;
    }
}
