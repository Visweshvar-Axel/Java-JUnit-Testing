package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	@Test
	void test() {
		StringHelper helper = new StringHelper();
//		besore inline refactor
//		String actual = helper.truncateAInFirst2Positions("AACD");
//		String expected = "CD";
//		assertEquals(expected,actual);
		String actual = helper.truncateAInFirst2Positions("AACD");
		String expected = "CD";
		assertEquals(expected,actual);
	}
   //	expected: <ABC> but was: <Abc>

}