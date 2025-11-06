package com.kodewala.thread.complitablefuture;

class EvenNumber extends Thread
{
	public void run()
	{
		System.out.println("My EvenThread is running "+Thread.currentThread().getName());
		evenNumber();
	}
	
	public void evenNumber()
	{
		for(int i=0;i<=10;i++)
		{
			if(i%2==0)
			{
				System.out.print(i+"  ");
			}
		}
	}
}

public class ThreadExample {
  public static void main(String args[])
  {
	  EvenNumber t1 = new EvenNumber();
	  EvenNumber t2 = new EvenNumber();
	  EvenNumber t3 = new EvenNumber();
	  
	  t1.start();
	  t2.start();
	  t3.start();
  }
}
