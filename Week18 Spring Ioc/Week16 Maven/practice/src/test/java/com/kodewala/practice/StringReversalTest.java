package com.kodewala.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringReversalTest {
	
	@Test
	public void reverseString()
	{
		StringReversal stringreversal = new StringReversal();
		 String expected = "olleh";
		 String actual = stringreversal.reverseString("hello");
		 assertEquals(expected,actual);
	}
	
	@Test
	public void reverseStringBlank()
	{
		StringReversal stringreversal = new StringReversal();
		String expected = " ";
		String actual =  stringreversal.reverseString(" ");
		assertEquals(expected,actual);
	}
	
	@Test
	public void reverseStringCharacter()
	{
		StringReversal stringreversal = new StringReversal();
		String expected = "a";
		
		String actual = stringreversal.reverseString("a");
		assertEquals(expected,actual);
	}

}
