package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TernaryServiceTest {
	
	TernaryService ternaryService;
	
	@Before
	public void setUp() {
		ternaryService = new TernaryService();
	}

	@Test
	public void testConvertToTernaryValues() {
		assertTrue(convertToTernary(0, 0));
		
		assertTrue(convertToTernary(1, 1));
		
		assertTrue(convertToTernary(2, 2));
		
		assertTrue(convertToTernary(3, 10));
		
		assertTrue(convertToTernary(4, 11));
		
		assertTrue(convertToTernary(5, 12));
		
		assertTrue(convertToTernary(6, 20));
		
		assertTrue(convertToTernary(7, 21));
		
		assertTrue(convertToTernary(8, 22));
		
		assertTrue(convertToTernary(9, 100));
		
		assertTrue(convertToTernary(10, 101));
		
		assertTrue(convertToTernary(26, 222));
		
		assertTrue(convertToTernary(27, 1000));
		
		assertTrue(convertToTernary(81, 10000));
		
		assertTrue(convertToTernary(99, 10200));
		
		assertTrue(convertToTernary(1000, 1101001));
		
		assertTrue(convertToTernary(1000000, 1212210202001L));
	}
	
	@Test
	public void testConvertToDecimalValues() {
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
	public void testConvertToTernaryLessThanZero() {
		Ternary t = ternaryService.convertToTernary(-1);
				
		assertNull(t);
	}
	
	@Test
	public void testCovertToTernaryGreaterThanOneMillion() {
		Ternary t = ternaryService.convertToTernary(1000001);
		
		assertNull(t);
	}
	
	private boolean convertToTernary(long decimalValue, long expectedTernaryValue) {
		Ternary t = ternaryService.convertToTernary(decimalValue);
		
		if(t == null) return false;
		
		return expectedTernaryValue == t.getTernaryValue();
	}
	
	private boolean convertToDecimal(Ternary t, long expectedDecimcalValue) {
		return ternaryService.convertToDecimal(t) == expectedDecimcalValue;
	}
}
