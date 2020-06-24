package com.limonnana.backend02.controller;


import com.google.gson.Gson;
import com.limonnana.backend02.entity.*;
import com.limonnana.backend02.repository.OrderRepository;
import com.limonnana.backend02.repository.ProductRepository;
import com.limonnana.backend02.repository.UserRepository;
import com.limonnana.backend02.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/secure/order")
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    private Double counter = 0.0;


    @PostMapping(value="/calculateOrder")
    public OrderDTOResponse calculateOrder(@RequestBody OrderDTO orderDTO){

        Order order = new Order();
        counter = 0.0;
        Long userId = orderDTO.getUserId();
        User user =  userRepository.findById(userId).get();
        order.setUser(user);
        Map<String, Integer> productQuantitiesMap = orderDTO.getProductsQuantities();
        logger.info(" Map: " + productQuantitiesMap.isEmpty());
        OrderDTOResponse orderDTOResponse = new OrderDTOResponse();
        orderDTOResponse.setUser(user);

        for (Map.Entry<String, Integer> entry : productQuantitiesMap.entrySet()) {
            logger.info(entry.getKey() + " | " + entry.getValue());
            Long id = Long.valueOf(entry.getKey());
            Product product = productRepository.findById(id).get();
            OrderProductQuantityTotal opq = new OrderProductQuantityTotal();
            opq.setProductId(product.getProductId();
            opq.setName(product.getName());
            opq.setPrice(product.getPrice());
            opq.setQuantity(entry.getValue());
            opq.setTotal(calculateTotal(product.getPrice(), entry.getValue()));
            orderDTOResponse.getOrderProductQuantityTotal().add(opq);
          //  OrderProductQuantityTotal =
            order.getProductList().add(opq);
           // orderDTOResponse.setTotalTotal(calculateTotalTotal());
        }
        orderDTOResponse.setTotalTotal(String.valueOf(counter));
        order.setTotalTotal(orderDTOResponse.getTotalTotal());
        Gson gson = new Gson();
        String result = gson.toJson(orderDTOResponse);
        logger.info(" RESULT: " + result);
        order = orderService.save(order);
        String orderJson = gson.toJson(order);
        logger.info(" ORDER: " + orderJson);
        return orderDTOResponse;
    }



    private String calculateTotal(String price, Integer quantity){

        Double priceD = Double.parseDouble(price);
        Double resultD = priceD * quantity;
        counter = counter + resultD;
        String result = String.valueOf(resultD);
        return result;
    }

   // private String calculateTotalTotal(){

   //     return "";
   // }
}
