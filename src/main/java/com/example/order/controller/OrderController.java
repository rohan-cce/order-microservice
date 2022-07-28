package com.example.order.controller;


import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
@CrossOrigin(value = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order CheckOut(@RequestBody Order order){

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                +"lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        String orderString = sb.toString();

        int id = lastOrder()+1;
        order.setId(id);
        order.setOrderId(orderString);

        return orderService.save(order);

    }

    public int lastOrder(){
        int ans;
        try{
            int count = orderService.findAll().get(orderService.findAll().size()-1).getId();
            return count;
        }catch (Exception e){
            return 0;
        }
    }

    @PostMapping("/{id}")
    public List<Order> getOrder(@PathVariable("id") int id){
        System.out.println(id);
        return orderService.findById(id);
    }


}
