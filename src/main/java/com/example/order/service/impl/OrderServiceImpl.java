package com.example.order.service.impl;


import com.example.order.Repository.OrderRepository;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Order findByUserId(int id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findById(int id){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(id));
        return mongoTemplate.find(query,Order.class);
//        return orderRepository.findByUserId(id);
//
//        return mongoTemplate.findById(id,Order.class,"order");
    }
}
