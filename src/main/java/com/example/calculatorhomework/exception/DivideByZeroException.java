package com.example.calculatorhomework.exception;

public class DivideByZeroException extends IllegalArgumentException {
    public DivideByZeroException(String message) {
        super(message);
    }
}
