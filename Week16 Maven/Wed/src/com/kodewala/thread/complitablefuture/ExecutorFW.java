package com.kodewala.thread.complitablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread
{
	public void run()
	{
		System.out.println("My Thread is running : "+Thread.currentThread().getName());
	}
}

public class ExecutorFW {
	public static void main(String args[])
	{
		ExecutorService service = Executors.newCachedThreadPool();
		
		MyThread t1 = new MyThread();
		
		for(int i=0;i<10;i++)
		{
			service.submit(t1);
		}
		service.shutdown();
	}

}
