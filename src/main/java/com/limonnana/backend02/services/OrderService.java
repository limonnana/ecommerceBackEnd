package com.limonnana.backend02.services;


import com.limonnana.backend02.entity.Order;
import com.limonnana.backend02.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order save(Order order){
      return  orderRepository.save(order);
    }
}
