package com.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

//@RunsWith(Parameterized.class)
class StringHelperParameterizedTest {
	StringHelper helper = new StringHelper();
	private String input;
	private String expected;

	public StringHelperParameterizedTest(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}

//	@Parameters
	public static Collection<String[]> testConditions(){
		String expectedOutput[][] = {{"AACD","CD"},
		{"ACD","CD"}};
		return Arrays.asList(expectedOutput);
	}
	@Test
	void test_truncateAInFirst2Positions_AinFirst2position() {
		assertEquals(expected, input);
	}
}