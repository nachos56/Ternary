package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TernaryServiceTest {
	
	TernaryService ternaryService;
	
	@Before
	public void setUp() {
		ternaryService = new TernaryService();
		ternaryService.setBaseValue(3);
	}

	@Test
	public void testConvertFromDecimalToTernary() {
		assertTrue(convertFromDecimal(0, 0));
		
		assertTrue(convertFromDecimal(1, 1));
		
		assertTrue(convertFromDecimal(2, 2));
		
		assertTrue(convertFromDecimal(3, 10));
		
		assertTrue(convertFromDecimal(4, 11));
		
		assertTrue(convertFromDecimal(5, 12));
		
		assertTrue(convertFromDecimal(6, 20));
		
		assertTrue(convertFromDecimal(7, 21));
		
		assertTrue(convertFromDecimal(8, 22));
		
		assertTrue(convertFromDecimal(9, 100));
		
		assertTrue(convertFromDecimal(10, 101));
		
		assertTrue(convertFromDecimal(26, 222));
		
		assertTrue(convertFromDecimal(27, 1000));
		
		assertTrue(convertFromDecimal(81, 10000));
		
		assertTrue(convertFromDecimal(99, 10200));
		
		assertTrue(convertFromDecimal(1000, 1101001));
		
		assertTrue(convertFromDecimal(1000000, 1212210202001L));
	}
	
	@Test
	public void testConvertFromTernaryToDecimal() {
		Ternary t =  new Ternary();
		
		t.setTernaryValue(0);
		assertTrue(convertToDecimal(t, 0));
		
		t.setTernaryValue(1);
		assertTrue(convertToDecimal(t, 1));
		
		t.setTernaryValue(2);
		assertTrue(convertToDecimal(t, 2));
		
		t.setTernaryValue(10);
		assertTrue(convertToDecimal(t, 3));
		
		t.setTernaryValue(11);
		assertTrue(convertToDecimal(t, 4));
		
		t.setTernaryValue(101);
		assertTrue(convertToDecimal(t, 10));
		
		t.setTernaryValue(12);
		assertTrue(convertToDecimal(t, 5));
		
		t.setTernaryValue(20);
		assertTrue(convertToDecimal(t, 6));
		
		t.setTernaryValue(21);
		assertTrue(convertToDecimal(t, 7));
		
		t.setTernaryValue(22);
		assertTrue(convertToDecimal(t, 8));
		
		t.setTernaryValue(100);
		assertTrue(convertToDecimal(t, 9));
		
		t.setTernaryValue(101);
		assertTrue(convertToDecimal(t, 10));
		
		t.setTernaryValue(222);
		assertTrue(convertToDecimal(t, 26));
		
		t.setTernaryValue(1000);
		assertTrue(convertToDecimal(t, 27));
		
		t.setTernaryValue(10000);
		assertTrue(convertToDecimal(t, 81));
		
		t.setTernaryValue(10200);
		assertTrue(convertToDecimal(t, 99));
		
		t.setTernaryValue(1101001);
		assertTrue(convertToDecimal(t, 1000));
		
		t.setTernaryValue(1212210202001L);
		assertTrue(convertToDecimal(t, 1000000));
	}

	@Test
	public void testConvertFromDecimalToQuaternary() {
		//	testing base 4:	quaternary
		ternaryService.setBaseValue(4);
		
		assertTrue(convertFromDecimal(0, 0));
		
		assertTrue(convertFromDecimal(1, 1));
		
		assertTrue(convertFromDecimal(2, 2));
		
		assertTrue(convertFromDecimal(3, 3));
		
		assertTrue(convertFromDecimal(4, 10));
		
		assertTrue(convertFromDecimal(5, 11));
		
		assertTrue(convertFromDecimal(6, 12));
		
		assertTrue(convertFromDecimal(7, 13));
		
		assertTrue(convertFromDecimal(8, 20));
		
		assertTrue(convertFromDecimal(9, 21));
		
		assertTrue(convertFromDecimal(10, 22));
		
		assertTrue(convertFromDecimal(11, 23));
		
		assertTrue(convertFromDecimal(12, 30));
		
		assertTrue(convertFromDecimal(13, 31));
		
		assertTrue(convertFromDecimal(14, 32));
		
		assertTrue(convertFromDecimal(15, 33));
		
		assertTrue(convertFromDecimal(16, 100));
	}
	
	@Test
	public void testConvertFromQuaternaryToDecimal() {
		
	}
	
	@Test
	public void testConvertToTernaryLessThanZero() {
		Ternary t = ternaryService.convertFromDecimal(-1);
				
		assertNull(t);
	}
	
	@Test
	public void testCovertToTernaryGreaterThanOneMillion() {
		Ternary t = ternaryService.convertFromDecimal(1000001);
		
		assertNull(t);
	}
	
	private boolean convertFromDecimal(long decimalValue, long expectedValue) {
		Ternary t = ternaryService.convertFromDecimal(decimalValue);
		
		if(t == null) return false;
		
		return expectedValue == t.getTernaryValue();
	}
	
	private boolean convertToDecimal(Ternary t, long expectedDecimcalValue) {
		return ternaryService.convertToDecimal(t) == expectedDecimcalValue;
	}
}
