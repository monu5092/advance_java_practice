package com.kodewala;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        String config ="\\com\\kodewala\\resources\\applicationContext.xml";
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        
        Employee emp1 = (Employee) context.getBean("emp1");
        Employee emp2 = (Employee) context.getBean("emp2");
        Employee emp3 = (Employee) context.getBean("emp3");
        
        System.out.println(emp1);
        System.out.println();
        System.out.println(emp2);
        System.out.println();
        System.out.println(emp3);
    }
}
