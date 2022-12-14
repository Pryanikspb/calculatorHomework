package com.example.calculatorhomework.service;

import com.example.calculatorhomework.exception.DivideByZeroException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest() {
        Number actual = calculatorService.plus(1,2);
        assertThat(actual).isEqualTo(3);

        actual = calculatorService.plus(-2,1);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(3, 1);
        assertThat(actual).isEqualTo(2);

        actual = calculatorService.minus(3, 4);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void multiplicationTest() {
        Number actual = calculatorService.multiplication(2, 3);
        assertThat(actual).isEqualTo(6);

        actual = calculatorService.multiplication(-3, -4);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void divisionPositiveTest() {
        Number actual = calculatorService.division(6, 2);
        assertThat(actual).isEqualTo(3D);

        actual = calculatorService.division(-8, 4);
        assertThat(actual).isEqualTo(-2D);
    }

    @Test
    public void divisionNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.division(1,0))
                .withMessage("На ноль делить нельзя!");
    }


}
