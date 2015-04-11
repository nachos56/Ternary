package main;

import java.lang.Math;

public class TernaryService {
	
	private final static long BASE = 3;
	
	public Ternary convertToTernary(long decimal) {
		
		//	if decimal is null or not between 1 and 1000000, return null
		if(decimal < 0 || decimal > 1000000) {
			return null;
		}
		
		Ternary ternary = new Ternary();
		
		if(decimal < BASE) {
			ternary.setTernaryValue(decimal);
			return ternary;
		}
		
		long factor = 1;
		
		//	Is there a faster way to find this?
		while(Math.pow(BASE, factor + 1) <= decimal) {
			factor += 1;
		}
		
		long ternaryValue = 0L;
		long decimalCounter = decimal;
		
		//	iterate until i is 0
		for(long i = factor; i >= 0; i--) {
			
			for(long j = BASE - 1; j > 0; j--) {
				if(decimalCounter - Math.pow(BASE, i) >= 0) {
					decimalCounter -= Math.pow(BASE, i);
					ternaryValue++;			
					
					//	FIX THIS
					if(decimalCounter == 0) {
						ternaryValue *= Math.pow(10, i);
						break;
					}
				}
			}
			
			//	FIX THIS
			if(decimalCounter == 0) 
				break;
			else
				ternaryValue *= 10;
		}
			
		ternary.setTernaryValue(ternaryValue);
		
		return ternary;
	}
	
	//	convert ternary values to decimal
	public long convertToDecimal(Ternary t) {
		
		if(t == null) {
			return -1;
		}
		
		long ternaryValue = t.getTernaryValue();
		//	stores the converted decimal value
		long decimalValue = 0L;
		
		int powerCounter = 0;

		//	if ternary value is 0, 1 or 2 return that value 
		if(ternaryValue < BASE) {
			return ternaryValue;
		}
		
		while(ternaryValue > 0) {
			//	get the last digit of the ternary value
			long ternaryLastDigit = ternaryValue % 10;
			
			//	multiply the last digit by the BASE to the current power
			decimalValue += (ternaryLastDigit * Math.pow(BASE, powerCounter));
			
			//	divide ternaryValue by 10
			ternaryValue /= 10;
			
			//	move onto the next power
			powerCounter++;
		}
		
		return decimalValue;
	}
}