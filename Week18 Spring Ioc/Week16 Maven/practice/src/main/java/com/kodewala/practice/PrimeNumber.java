package com.kodewala.practice;

public class PrimeNumber {
   public boolean checkPrime(int n)
   {
	   if(n<2)
	   {
		   return false;
	   }
	   for(int i=2;i*i<=n;i++)
	   {
		   if(n%i==0)
		   {
			   return false;
		   }
	   }
	   return true;
   }
}
