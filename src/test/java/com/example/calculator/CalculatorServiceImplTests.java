package com.example.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTests {

    private static final Integer NUM_1 = 5;
    private static final Integer NUM_2 = 5;
    private static final Integer NUM_IS_ZERO = 0;
    private static final Integer NUM_IS_NULL = null;
    private static final String DEFAULT_MESSAGE = "Добро пожаловать в калькулятор";
    private static final String DEFAULT_MESSAGE_IS_EMPTY = "Один из параметров пуст";
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    public static Stream<Arguments> greetingMessage() {
        return Stream.of(Arguments.of(DEFAULT_MESSAGE));
    }

    @ParameterizedTest
    @MethodSource("greetingMessage")
    public void greeting(String message) {
        assertEquals(message,out.welcome());
    }



    public static Stream<Arguments> ifParamIsEmpty() {
        return Stream.of(Arguments.of(NUM_1, NUM_IS_NULL, DEFAULT_MESSAGE_IS_EMPTY),
        Arguments.of(NUM_IS_NULL,NUM_1, DEFAULT_MESSAGE_IS_EMPTY));
    }

    @ParameterizedTest
    @MethodSource("ifParamIsEmpty")
    public void shouldReturnTheCorrectMessageIfTheParameterIsEmpty(Integer num1, Integer num2, String messageIsEmpty) {
        assertEquals(messageIsEmpty, out.sum(num1, num2));
        assertEquals(messageIsEmpty, out.minus(num1, num2));
        assertEquals(messageIsEmpty, out.multiply(num1, num2));
        assertEquals(messageIsEmpty, out.divide(num1, num2));
    }

    public static Stream<Arguments> parametersOfMathematicalOperations() {
        return Stream.of(Arguments.of(NUM_1, NUM_2),
                Arguments.of(NUM_2,NUM_1));
    }

    @ParameterizedTest
    @MethodSource("parametersOfMathematicalOperations")
    public void shouldReturnTheResultOfMathematicalOperations(Integer num1, Integer num2) {
        assertEquals(num1 + num2, out.sum(num1, num2));
        assertEquals(num1 - num2, out.minus(num1, num2));
        assertEquals(num1 * num2, out.multiply(num1, num2));
        assertEquals(num1 / num2, out.divide(num1, num2));
    }

    public static Stream<Arguments> operandsWithZero() {
        return Stream.of(Arguments.of(NUM_1, NUM_IS_ZERO));
    }

    @MethodSource("operandsWithZero")
    @ParameterizedTest
    public void mathematicalOperationsWithZero(Integer num1, Integer num2) {
        assertEquals(num1 + num2, out.sum(num1, num2));
        assertEquals(num1 - num2, out.minus(num1, num2));
        assertEquals(num1 * num2, out.multiply(num1, num2));
        assertThrows(IllegalArgumentException.class,()-> out.divide(num1, num2));
    }

    public static Stream<Arguments> firstOperandIsZero() {
        return Stream.of(Arguments.of(NUM_IS_ZERO, NUM_1));
    }
@ParameterizedTest
@MethodSource("firstOperandIsZero")
    public void mathematicalOperationsWithZeroFirst(Integer num1,Integer num2) {
        assertEquals(num1 + num2, out.sum(num1, num2));
        assertEquals(num1 - num2, out.minus(num1, num2));
        assertEquals(num1 * num2, out.multiply(num1, num2));
        assertEquals(num1/num2, out.divide(num1, num2));
    }

}