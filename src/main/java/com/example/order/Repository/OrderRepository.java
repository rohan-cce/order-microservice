package com.example.order.Repository;

import com.example.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
    List<Order> findAll();

    Order save(Order order);

    //@Query("userId:?0")
    Order findByUserId(int id);
//

}
