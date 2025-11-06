package com.kodewala.thread.complitablefuture;

class Task 
{
	public synchronized void printOdd()
	{
		for(int i=0;i<=10;i++)
		{
			if(i%2!=0)
			{
				System.out.println("Odd Number : "+ i+" "+Thread.currentThread().getName());
			}
		}
	}
	public synchronized void printEven()
	{
		for(int i=0;i<=10;i++)
		{
			if(i%2==0)
			{
				System.out.println("Even Number : "+i+" "+Thread.currentThread().getName());
			}
		}
	}
}

class EvenThread extends Thread
{
	Task task;
	
	public EvenThread(Task _task)
	{
		super();
		this.task = _task;
	}
	public void run()
	{
		task.printEven();
	}
}

class OddThread extends Thread
{
	Task task ;
	public OddThread(Task _task)
	{
		super();
	this.task = _task;
		
	}
}

public class SynchronizedExample {

}
