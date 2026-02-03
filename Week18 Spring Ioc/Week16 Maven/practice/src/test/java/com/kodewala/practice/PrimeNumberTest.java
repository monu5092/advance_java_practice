package com.kodewala.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PrimeNumberTest {
     
	@Test
	public void checkPrime()
	{
		PrimeNumber prime = new PrimeNumber();
		
		boolean expected = true;
		boolean actual =  prime.checkPrime(19);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkPrimeWithZero()
	{ 
		PrimeNumber prime = new PrimeNumber();
		boolean expected = false;
		boolean actual = prime.checkPrime(0);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkPrimeWithNegative()
	{ 
		PrimeNumber prime = new PrimeNumber();
		boolean expected = false;
		boolean actual = prime.checkPrime(-19);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void checkPrimeWithNegativeNonPrime()
	{ 
		PrimeNumber prime = new PrimeNumber();
		boolean expected = false;
		boolean actual = prime.checkPrime(-10);
		
		assertEquals(expected,actual);
	}
	
	
	
}
