package com.kodewala.calculator;

public class AddTwoNumber {
    public int Addition(int a,int b )
    {
 	
    	int sum;
    	if (a > 0 || b > 0)
    	{
    	    sum = a + b;
    	} else
    	{
    	    return 0;
    	}
    	return sum;
    }
}
