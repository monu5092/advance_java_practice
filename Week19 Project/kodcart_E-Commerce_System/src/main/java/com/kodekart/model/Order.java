package com.kodekart.model;

import java.sql.Date;
import java.util.List;

public class Order {

    private int id;
    private int userId;
    private Date orderDate;
    private double totalAmount;

    private List<Product> productItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Only sets the value (used by DAO)
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProductItems() {
        return productItems;
    }

    // When product items are set → total auto recalculates
    public void setProductItems(List<Product> productItems) {
        this.productItems = productItems;
        calculateTotal();
    }


    public void calculateTotal() {
        if (productItems == null || productItems.isEmpty()) {
            this.totalAmount = 0.0;
            return;
        }

        double total = 0.0;

        // price × quantity for each product
        for (Product p : productItems) {
            total += p.getPrice() * p.getQuantity();
        }

        this.totalAmount = total;
    }
}
