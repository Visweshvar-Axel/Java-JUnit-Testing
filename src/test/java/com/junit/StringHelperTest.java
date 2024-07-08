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
		//AACD -> CD ACD -> CD CDAA -> CDAA
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	   //expected: <ABC> but was: <Abc>
	}

}