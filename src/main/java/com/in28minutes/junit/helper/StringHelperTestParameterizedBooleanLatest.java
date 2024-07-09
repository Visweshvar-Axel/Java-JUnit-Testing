package com.in28minutes.junit.helper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelperTestParameterizedBooleanLatest {

    StringHelper helper = new StringHelper();

    @ParameterizedTest
    @ValueSource(strings = {"ABCD,false", "ABAB,true", "AB,true", "A,false"})
    public void testAreFirstAndLastTwoCharactersTheSame(String inputExpected) {
        String[] parts = inputExpected.split(",");
        String input = parts[0];
        boolean expected = Boolean.parseBoolean(parts[1]);

        assertEquals(expected, helper.areFirstAndLastTwoCharactersTheSame(input));
    }
}
