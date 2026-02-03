package com.kodewala.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultipleTwoNumberTest {
	
	@Test
    public void MultipleTwoNumbers() {
    	MultipleTwoNumber multipleTwoNumber = new MultipleTwoNumber();
    	int expected = 10;
    	
    	int result = multipleTwoNumber.MultipleTwoNumbers(5,2);
    	assertEquals(expected,result);
    }
	
	
	@Test
    public void MultipleTwoNumbersNegative() {
    	MultipleTwoNumber multipleTwoNumber = new MultipleTwoNumber();
    	int expected = -60;
    	
    	int result = multipleTwoNumber.MultipleTwoNumbers(5,-12);
    	assertEquals(expected,result);
    }
	
	
    @Test
    public void MultipleTwoNumbersZero() {
    	MultipleTwoNumber multipleTwoNumber = new MultipleTwoNumber();
    	int expected = 0;
    	
    	int result = multipleTwoNumber.MultipleTwoNumbers(5,0);
    	assertEquals(expected,result);
    }
    
    
    
    @Test
    public void MultipleTwoNumbersCompleteZero() {
    	MultipleTwoNumber multipleTwoNumber = new MultipleTwoNumber();
    	int expected = 0;
    	
    	int result = multipleTwoNumber.MultipleTwoNumbers(0,0);
    	assertEquals(expected,result);
    }
    
    
    
    @Test
    public void MultipleTwoNumbersCompleteNegative() {
    	MultipleTwoNumber multipleTwoNumber = new MultipleTwoNumber();
    	int expected = 60;
    	
    	int result = multipleTwoNumber.MultipleTwoNumbers(-12,-5);
    	assertEquals(expected,result);
    }
}
