package com.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private static final Integer NUM_1 = 5;
    private static final Integer NUM_2 = 5;
    private static final Integer NUM_IS_ZERO = 0;
    private static final Integer NUM_IS_NULL = null;
    private static final String DEFAULT_MESSAGE = "Добро пожаловать в калькулятор";
    private static final String DEFAULT_MESSAGE_IS_EMPTY = "Один из параметров пуст";
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void shouldReturnDefaultMessage() {
        assertEquals(DEFAULT_MESSAGE, out.welcome());
    }

    @Test
    public void positiveAdditions() {
        Integer expected = NUM_1 + NUM_2;
        assertEquals(expected,out.sum(NUM_1, NUM_2));
    }

    @Test
    public void shouldReturnMessageThatTheParameterIsEmpty() {
        assertEquals(DEFAULT_MESSAGE_IS_EMPTY,out.sum(NUM_1,NUM_IS_NULL));
        assertEquals(DEFAULT_MESSAGE_IS_EMPTY, out.minus(NUM_1, NUM_IS_NULL));
        assertEquals(DEFAULT_MESSAGE_IS_EMPTY, out.multiply(NUM_1, NUM_IS_NULL));
        assertEquals(DEFAULT_MESSAGE_IS_EMPTY, out.divide(NUM_1, NUM_IS_NULL));
    }

    @Test
    public void positiveSubtraction() {
        Integer expected = NUM_1 - NUM_2;
        assertEquals(expected,out.minus(NUM_1, NUM_2));
    }

    @Test
    public void positiveMultiplication() {
        Integer expected = NUM_1 * NUM_2;
        assertEquals(expected,out.multiply(NUM_1, NUM_2));
    }

    @Test
    public void positiveDivision() {
        Integer expected = NUM_1 / NUM_2;
        assertEquals(expected,out.divide(NUM_1, NUM_2));
    }

    @Test
    public void shouldReturnAnException() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(NUM_1, NUM_IS_ZERO));
    }

}