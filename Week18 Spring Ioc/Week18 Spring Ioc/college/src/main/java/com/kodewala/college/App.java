package com.kodewala.college;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        String config = "\\com\\kodewala\\college\\resources\\applicationContext.xml";
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        
        Student student = (Student) context.getBean("student");
        
        System.out.println(student);
    }
}