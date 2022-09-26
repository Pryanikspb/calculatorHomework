package com.example.calculatorhomework.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public int multiplication(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public double division(Integer a, Integer b) {
        return (double) a / b;
    }

    @Override
    public int divisionWithoutRemainder(Integer a, Integer b) {
        return a / b;
    }
}
