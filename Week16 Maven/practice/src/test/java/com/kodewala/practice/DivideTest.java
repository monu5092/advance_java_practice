package com.kodewala.practice;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivideTest {
   
	@Test
	public void divide()
	{
		Divide divide = new Divide();
		int expected = 5;
		int actual = divide.division(10, 2);
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void dividewithNegative()
	{
		Divide divide = new Divide();
		int expected = -10;
		int actual = divide.division(20,-2);
		
		assertEquals(expected, actual, 0.001);
	}
	
	@Test(expected  = ArithmeticException.class)
    public void divideWithZero() {
        Divide divide = new Divide();
        divide.division(20, 0); 
    }    
}
