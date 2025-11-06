package com.kodewala.calculator;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddTwoNumbersTest 
{ 
	@Test
	public void AddTwoNumbers()
	{
		AddTwoNumber addtwoNumber = new AddTwoNumber();
		int expected = 13;
				
	    int result = addtwoNumber.AddTwoNumbers(6,7);
	    assertEquals(expected, result);
	}
	
	@Test
	public void AddTwoNumbersPositive()
	{
		AddTwoNumber addtwoNumber = new AddTwoNumber();
		int expected = 100;
				
	    int result = addtwoNumber.AddTwoNumbers(70,30);
	    assertEquals(expected, result);
	}
	
	@Test
	public void AddTwoNumbersNegative()
	{
		AddTwoNumber addtwoNumber = new AddTwoNumber();
		int expected = -10;
				
	    int result = addtwoNumber.AddTwoNumbers(-50,40);
	    assertEquals(expected, result);
	}

}
