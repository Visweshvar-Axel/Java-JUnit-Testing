package com.in28minutes.junit.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(Parameterized.class)
public class StringHelperTestParameterizedBoolean {
	StringHelper helper = new StringHelper();

	private String input;
	private String expected;

	public StringHelperTestParameterizedBoolean(String input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection<String[]> cases(){
		String[][] cases = {
				{"ABCD","false"},
				{"ABAB","true"},
				{"AB","true"},
				{"A","false"},
		};
		return Arrays.asList(cases);
	}

	// ABCD => false, ABAB => true, Ab => true, a => false
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_BAsicNegativeScenario(){
		assertEquals(Boolean.parseBoolean(expected),helper.areFirstAndLastTwoCharactersTheSame(input));
	}
}