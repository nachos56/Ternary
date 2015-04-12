package main;

import java.lang.Math;

public class TernaryService {
	
	private int baseValue = 10;
	
	public void setBaseValue(int setBase) {
		baseValue = setBase;
	}
	
	public int getBaseValue() {
		return baseValue;
	}
	
	public Ternary convertFromDecimal(int base, long decimal) {
		return calculateTernary(base, decimal);
	}
	
	public Ternary convertFromDecimal(long decimal) {
		return calculateTernary(-1, decimal);		
	}
	
	public Ternary calculateTernary(int base, long decimal) {
		int calculateBase = (base > 1 ? base : baseValue);
		
		//	if decimal is null or not between 1 and 1000000, return null
		if(decimal < 0 || decimal > 1000000) {
			return null;
		}
			
		Ternary ternary = new Ternary();
			
		if(decimal < calculateBase) {
			ternary.setTernaryValue(decimal);
			return ternary;
		}
			
		int factor = 1;
			
		//	Is there a faster way to find this?
		while(Math.pow(calculateBase, factor + 1) <= decimal) {
			factor += 1;
		}
			
		long ternaryValue = 0L;
		long decimalCounter = decimal;
			
		//	iterate until i is 0
		for(int i = factor; i >= 0; i--) {
				
			for(int j = calculateBase - 1; j > 0; j--) {
				if(decimalCounter - Math.pow(calculateBase, i) >= 0) {
					decimalCounter -= Math.pow(calculateBase, i);
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
		if(ternaryValue < baseValue) {
			return ternaryValue;
		}
		
		while(ternaryValue > 0) {
			//	get the last digit of the ternary value
			long ternaryLastDigit = ternaryValue % 10;
			
			//	multiply the last digit by the BASE to the current power
			decimalValue += (ternaryLastDigit * Math.pow(baseValue, powerCounter));
			
			//	divide ternaryValue by 10
			ternaryValue /= 10;
			
			//	move onto the next power
			powerCounter++;
		}
		
		return decimalValue;
	}
}