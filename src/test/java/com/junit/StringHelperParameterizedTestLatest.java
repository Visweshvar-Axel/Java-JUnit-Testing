package com.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.management.ConstructorParameters;

import static org.junit.Assert.*;

public class StringHelperParameterizedTestLatest {
    StringHelper helper = new StringHelper();

    @ParameterizedTest
    @CsvSource({ "AACD, CD", "ACD, CD" })
    void testTruncateAInFirst2Positions(String input, String expected) {
        assertEquals(expected, helper.truncateAInFirst2Positions(input));
    }
}
