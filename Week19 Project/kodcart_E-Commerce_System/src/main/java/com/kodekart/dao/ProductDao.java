package com.kodekart.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kodekart.model.Product;

public class ProductDao {

    private Connection connection = DBConnection.getConnection();

    public boolean addProduct(Product product) {
        String query = "INSERT INTO products(name, category, price, quantity, description) VALUES(?,?,?,?,?)";
        if (connection == null) {
            System.out.println("Database connection is null!");
            return false;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getDescription());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding product:");
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        String query = "UPDATE products SET name=?, category=?, price=?, quantity=?, description=? WHERE id=?";
        if (connection == null) {
            System.out.println("Database connection is null!");
            return false;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getDescription());
            pstmt.setInt(6, product.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating product:");
            e.printStackTrace();
        }
        return false;
    }

   
    public boolean deleteProduct(int id) {
        String query = "DELETE FROM products WHERE id=?";
        if (connection == null) {
            System.out.println("Database connection is null!");
            return false;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting product:");
            e.printStackTrace();
        }
        return false;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";

        if (connection == null) {
            System.out.println("Database connection is null!");
            return list;
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching all products:");
            e.printStackTrace();
        }

        if (list.isEmpty()) {
            System.out.println("No products found in the database.");
        }

        return list;
    }

    public Product getProductById(int id) {
        Product product = null;
        String query = "SELECT * FROM products WHERE id=?";

        if (connection == null) {
            System.out.println("Database connection is null!");
            return null;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching product by ID:");
            e.printStackTrace();
        }

        return product;
    }

    public List<Product> searchProduct(String keyword) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products WHERE name LIKE ?";

        if (connection == null) {
            System.out.println("Database connection is null!");
            return list;
        }

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error searching products:");
            e.printStackTrace();
        }

        if (list.isEmpty()) {
            System.out.println("No products found matching: " + keyword);
        }

        return list;
    }
}
