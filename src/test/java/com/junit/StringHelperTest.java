package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringHelperTest {

	@Test
	void testtruncateAInFirst2Positions_Ainfirst2position() {
		StringHelper helper = new StringHelper();
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
//		before inline refactor
//		String actual = helper.truncateAInFirst2Positions("AACD");
//		String expected = "CD";
//		assertEquals(expected,actual);
		//AACD -> CD ACD -> CD CDAA -> CDAA
	   //expected: <ABC> but was: <Abc>
	}

	@Test
	public void testtruncateAInFirst2Positions_Ainfirstposition() {
		StringHelper helper = new StringHelper();
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
}