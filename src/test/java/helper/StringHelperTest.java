package helper;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

class StringHelperTest {
	StringHelper helper = new StringHelper();

//		before 
//		String actual = helper.truncateAInFirst2Positions("AACD");
//		String expected = "CD";
//		assertEquals(expected,actual);
		//AACD -> CD ACD -> CD CDAA -> CDAA
	   //expected: <ABC> but was: <Abc>
	@Test
	public void test_truncateAInFirst2Positions_AinFirst2position() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void test_truncateAInFirst2Positions_AinFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	@Test
	public void test_truncateAInFirst2Positions_withoutA() {
		assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	}
	@Test
	public void test_truncateAInFirst2Positions_withANotInFirst2Positions() {
		assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
	}

	// ABCD => false, ABAB => true, Ab => true, a => false
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_BAsicNegativeScenario(){
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"),"Expected false");
	}
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_BAsicPositiveScenario(){
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_BAsicPositiveScenarioAB(){
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	@Test
	public void test_areFirstAndLastTwoCharactersTheSame_BAsicNegativeScenarioA(){
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
}