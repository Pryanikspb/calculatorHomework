package com.example.calculatorhomework.service;

import com.example.calculatorhomework.exception.DivideByZeroException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ParameterizedCalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest (Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorService.plus(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest (Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorService.minus(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplication")
    public void multiplicationTest (Integer a,
                           Integer b,
                           Integer expected) {
        assertThat(calculatorService.multiplication(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivision")
    public void divisionTest (Integer a,
                              Integer b,
                              Double expected) {
        if (b == 0) {
            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(() -> calculatorService.division(a, b))
                    .withMessage("На ноль делить нельзя!");
        } else {
        assertThat(calculatorService.division(a,b)).isEqualTo(expected);
        }
    }

    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                Arguments.of(1,2,3),
                Arguments.of(2,4,6),
                Arguments.of(0,5,5),
                Arguments.of(-6,3,-3),
                Arguments.of(-2,-5,-7)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1,2,-1),
                Arguments.of(2,4,-2),
                Arguments.of(0,5,-5),
                Arguments.of(-6,3,-9),
                Arguments.of(-2,-5,3)
        );
    }

    public static Stream<Arguments> paramsForMultiplication() {
        return Stream.of(
                Arguments.of(1,2,2),
                Arguments.of(2,4,8),
                Arguments.of(0,5,0),
                Arguments.of(-6,3,-18),
                Arguments.of(-2,-5,10)
        );
    }

    public static Stream<Arguments> paramsForDivision() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(2,4,0.5),
                Arguments.of(0,5,0D),
                Arguments.of(-6,3,-2D),
                Arguments.of(-2,-5,0.4),
                Arguments.of(1,0, null));
    }

}
