package com.kodekart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kodekart.model.Cart;

public class CartDao {

    private Connection connection = DBConnection.getConnection();

    public boolean addToCart(Cart cart) {
        String query = "INSERT INTO cart(userId, productId, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getProductId());
            ps.setInt(3, cart.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Cart getCartItem(int userId, int productId) {
        Cart cart = null;
        String query = "SELECT * FROM cart WHERE userId=? AND productId=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cart = new Cart();
                cart.setId(rs.getInt("cartId"));
                cart.setUserId(rs.getInt("userId"));
                cart.setProductId(rs.getInt("productId"));
                cart.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

    
    public boolean updateQuantity(int cartId, int newQuantity) {
        String query = "UPDATE cart SET quantity=? WHERE cartId=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, newQuantity);
            ps.setInt(2, cartId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

 
    public List<Cart> getCart(int userId) {
        List<Cart> list = new ArrayList<>();
        String query = "SELECT * FROM cart WHERE userId=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getInt("cartId"));
                cart.setUserId(rs.getInt("userId"));
                cart.setProductId(rs.getInt("productId"));
                cart.setQuantity(rs.getInt("quantity"));
                list.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
    public boolean removeCartItem(int cartId) {
        String query = "DELETE FROM cart WHERE cartId=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, cartId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   
    public boolean clearCart(int userId) {
        String query = "DELETE FROM cart WHERE userId=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
