package com.example.order.service;

import com.example.order.entity.Order;

import java.util.List;

public interface OrderService {
    Order findByUserId(int id);
    Order save(Order order);
    List<Order> findAll();
    List<Order> findById(int id);
}
