package com.kodekart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kodekart.model.Order;

public class OrderDao {
    
	private Connection connection = DBConnection.getConnection();
	
	public boolean saveOrder(Order order) {
	    boolean status = false;

	    try {
	        // Make sure totalAmount is calculated before saving
	        order.calculateTotal();

	        PreparedStatement ps = connection.prepareStatement(
	            "INSERT INTO orders(userId, orderDate, totalAmount) VALUES (?, ?, ?)"
	        );

	        ps.setInt(1, order.getUserId());
	        ps.setDate(2, order.getOrderDate());
	        ps.setDouble(3, order.getTotalAmount());   // Now correct total is saved

	        int row = ps.executeUpdate();

	        if (row > 0) {
	            status = true;
	        }

	        ps.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}

	
	public List<Order> getOrdersByUser(int userId) {
		List<Order> orders = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM orders WHERE userId = ? ORDER BY orderDate DESC");

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setTotalAmount(rs.getDouble("totalAmount"));

				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders ORDER BY orderDate DESC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setUserId(rs.getInt("userId"));
				order.setOrderDate(rs.getDate("orderDate"));
				order.setTotalAmount(rs.getDouble("totalAmount"));

				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}
}
