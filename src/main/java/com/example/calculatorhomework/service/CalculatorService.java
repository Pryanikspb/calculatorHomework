package com.example.calculatorhomework.service;

import com.example.calculatorhomework.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public Number plus (Integer a, Integer b) {
        return a + b;
    }

    public Number minus (Integer a, Integer b) {
        return a - b;
    }

    public Number multiplication (Integer a, Integer b) {
        return a * b;
    }

    public Number division (Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException("На ноль делить нельзя!");
        }
        return a.doubleValue()/b;
    }

}
