package com.kodewala.zepto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {

	// 1st step - Register JDBC driver
	Class.forName("com.mysql.cj.jdbc.Driver");

	// 2nd step - Create connection

	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_39th_june", "root",
		"Test@12345");

	String sql = " select * from orders where price > ? and status= ? ";

	// 3rd Create Statement
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setInt(1, 1000);
	stmt.setString(2, "Delivered");
	
	ResultSet rs = stmt.executeQuery();

	// +----------+------------------+--------+--------+
	// | itemname(1) | description(2) | price(3) | status(4) |
	// +----------+------------------+--------+--------+
	// | iphone17 | iphone17 pro max | 120000 | paid |
	// +----------+------------------+--------+--------+

	while (rs.next())
	{
	    String item = rs.getString(1);
	    String desc = rs.getString(2);
	    int price = rs.getInt(3);
	    String status = rs.getString(4);

	    System.out.println(
		    "  | item " + item + " | " + " desc " + desc + " |  price " + price + "  | status " + status);
	}

	String updateStatusSql = "update orders set status='Delivered'";

	int recordsUpdated = stmt.executeUpdate(updateStatusSql);
	System.out.println(" Total records updated... " + recordsUpdated);
    }
}
