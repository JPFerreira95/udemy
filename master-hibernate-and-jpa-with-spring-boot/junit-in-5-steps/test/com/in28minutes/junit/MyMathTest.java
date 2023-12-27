package com.in28minutes.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyMathTest {

    private final MyMath math = new MyMath();

    // {1,2,3} => 6
    @Test
    public void calculateSum_ThreeMemberArray() {
        // Absence of failure is success
        // Test conditions or Asserts

        int[] numbers = {1,2,3};
        int result = math.calculateSum(numbers);
        int expectedResult = 6;

        assertEquals(expectedResult, result);
    }

    // {} => 0
    @Test
    public void calculateSum_EmptyArray() {
        // Simplified version
        assertEquals(0, math.calculateSum(new int[]{}));
    }

}
