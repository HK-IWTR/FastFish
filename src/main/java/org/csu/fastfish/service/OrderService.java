package org.csu.fastfish.service;

import org.csu.fastfish.domain.Order;
import org.csu.fastfish.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;


    public List<Order> getOrdersByUsername(String username) {
        return orderMapper.getOrdersByUsername(username);
    }

    public void cancelOrderById(int orderId){
        orderMapper.cancelOrderById(orderId);
    }

    @Transactional
    public void insertOrder(Order order){
        System.out.println(order.getOrder_time());
        orderMapper.insertOrder(order);
    }
}
