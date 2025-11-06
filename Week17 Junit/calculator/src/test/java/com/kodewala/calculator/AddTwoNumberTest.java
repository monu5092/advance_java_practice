package com.kodewala.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddTwoNumberTest {
    
	AddTwoNumber addtwonumber;
	 
	@Before
	public void setupt()
	{
		System.out.println("creating object....");
	     addtwonumber  = new AddTwoNumber();
	}
	
	@After
	public  void cleanup()
	{
		System.out.println("Cleaning up object....");
		addtwonumber=null;
	}
	
	@Test
	public void checkSumwithPositive()
	{
		int expected = 7;
		int actual = addtwonumber.Addition(5, 2);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkSumWithfirstzero()
	{
		int expected = 9;
		int actual = addtwonumber.Addition(0, 9);
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkSumWithSecondzero()
	{
		int expected = 9;
		int actual = addtwonumber.Addition(9, 0);
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkSumWithBothzero()
	{
		int expected = 0;
		int actual = addtwonumber.Addition(0, 0);
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkSumWithfirstNegative()
	{
		int expected = 0;
		int actual = addtwonumber.Addition(-10,8);
		assertNotEquals(expected,actual);
	}
	
	@Test
	public void checkSumWithSecondNegative()
	{
		int expected = 0;
		int actual = addtwonumber.Addition(9, -10);
		assertEquals(expected,actual);
	}
}
