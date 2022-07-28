package com.example.order.entity;

public class Product {
    private int id;
    private int price;
    private int quantity;

    public int getProductId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
