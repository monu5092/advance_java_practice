package com.kodewala.practice;

public class Employee {
	 public double applyBonus(double salary,double bonusPercent)
	    {
	    	if(salary<0 || bonusPercent<0)
	    	{
	    		throw new IllegalArgumentException("Salary or bonus cannot be negative");
	    	}
	    	return salary;
	    }
}
