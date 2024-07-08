package com.junit;

import com.junit.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

	StringHelper helper = new StringHelper();
	private String input;
	private String expected;

	public StringHelperParameterizedTest(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<String[]> testConditions() {
		String expectedOutputs[][] = {
				{"AACD", "CD"},
				{"ACD", "CD"}
		};
		return Arrays.asList(expectedOutputs);
	}

	@Test
	public void test_truncateAInFirst2Positions() {
		assertEquals(expected, helper.truncateAInFirst2Positions(input));
	}
}