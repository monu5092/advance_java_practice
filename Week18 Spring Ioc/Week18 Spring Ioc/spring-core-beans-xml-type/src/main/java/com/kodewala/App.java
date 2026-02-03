package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
   public static void main(String args[])
   {
	   String config = "\\com\\kodewala\\monu\\applicationContext.xml";
	   
	   ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
	   
	    Account account = (Account) applicationContext.getBean("acc");
	    
	    System.out.println(account);
	    
	   
   }
}
