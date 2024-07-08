package com.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {

    // Arrays.sort

    @Test
    public void testArraySort_RandomArray(){
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
//        int[] expected = {1,4,3,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
        // array contents differ at index [1], expected: <4> but was: <3>
    }
//    old version
//    @Test(expected=NullPointerException.class)
//    public void testArraySort_NullArray(){
//        int[] numbers = null;
//        Arrays.sort(numbers);
//    }
    @Test
    public void testArraySort_NullArray(){
        int[] numbers = null;
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            Arrays.sort(numbers);
        });
//        Arrays.sort(numbers);
        assertNotNull(exception);
    }
}
