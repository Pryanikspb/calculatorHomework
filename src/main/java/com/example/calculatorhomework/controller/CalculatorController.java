package com.example.calculatorhomework.controller;

import com.example.calculatorhomework.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private  final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String welcomePage(){
        return "<b>Добро пожаловать в калькулятор!</b>";
    }

    @GetMapping("/plus")
    public String plus (@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Один из параметров не введён";
        }
        return buildResult(a, b, calculatorService.plus(a, b), "+");
    }

    @GetMapping("/minus")
    public String minus (@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Один из параметров не введён";
        }
        return buildResult(a, b, calculatorService.minus(a, b), "-");
    }

    @GetMapping("/multiply")
    public String multiplication (@RequestParam(name = "num1", required = false) Integer a,
                                  @RequestParam(name = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Один из параметров не введён";
        }
        return buildResult(a, b, calculatorService.multiplication(a, b), "*");
    }

    @GetMapping("/divide")
    public String division (@RequestParam(name = "num1", required = false) Integer a,
                            @RequestParam(name = "num2", required = false) Integer b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return "Один из параметров не введён";
        }
        return buildResult(a,b, calculatorService.division(a,b), "/");
    }

    private String buildResult(Number a, Number b, Number result, String operation) {
        return String.format("%s %s %s = %s", a, operation, b, result);
    }

}
