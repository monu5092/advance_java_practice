package com.kodekart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
      private static Connection connection;
      
      public static Connection getConnection()
      {
    	  try {
    		  if(connection == null)
    		  {
    			  Class.forName("com.mysql.cj.jdbc.Driver");
    			  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kodekart", "root", "Monu@20345092");
    		  }
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    	  }
    	  
    	  return connection;
      }
}
