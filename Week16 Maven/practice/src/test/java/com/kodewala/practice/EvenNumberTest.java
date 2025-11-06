package com.kodewala.practice;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvenNumberTest {
	
   @Test
   public void checkEvenNumber()
   {
	   EvenNumber even = new EvenNumber();
	   
	   boolean expected = true;
	   boolean actual = even.checkEven(6);
	   assertEquals(expected, actual);   
   }
	
	@Test
	public void checkEvenNumberNot()
	{
		EvenNumber even = new  EvenNumber();
		
		boolean expected = false;
		boolean actual = even.checkEven(5);
		
		assertEquals(expected,actual);
	}
	 
	@Test
	public void checkEvenNumberWithNegativeNumber()
	{
		EvenNumber even = new EvenNumber();
		
		boolean expected = true;
		boolean actual = even.checkEven(-10);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkEvenNumberWithNegativeOdd()
	{
		EvenNumber even  = new EvenNumber();
		
		boolean expected = false;
		boolean actual = even.checkEven(-21);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkEvenNumberWithZero()
	{
		EvenNumber even = new EvenNumber();
		
		boolean expected  = true;
		boolean actual = even.checkEven(0);
		
		assertEquals(expected,actual);
	}
}
