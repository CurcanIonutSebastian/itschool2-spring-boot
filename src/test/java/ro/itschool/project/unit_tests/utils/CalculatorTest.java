package ro.itschool.project.unit_tests.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ro.itschool.project.utils.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAdditionWithValidInputShouldPass() {
        //given
        int a = 5;
        int b = 24;
        int expectedResult = a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertEquals(expectedResult, actualResult, "The addition result should be equal to the excepted result!");
    }

    @Test
    void testAdditionWithResultExceedsMaximumIntegerValueShouldFail() {
        //given
        int a = Integer.MAX_VALUE;
        int b = 1;
        long expectedResult = (long) a + b;

        //when
        int actualResult = calculator.add(a, b);

        //then
        assertNotEquals(expectedResult, actualResult);
    }
}
