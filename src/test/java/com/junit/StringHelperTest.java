package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	@Test
	void test() {
		StringHelper helper = new StringHelper();
//		before inline refactor
//		String actual = helper.truncateAInFirst2Positions("AACD");
//		String expected = "CD";
//		assertEquals(expected,actual);
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
   //	expected: <ABC> but was: <Abc>

}