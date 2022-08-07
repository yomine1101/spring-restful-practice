package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders(){
        List<Order> orderList = this.orderService.getAllOrders();
        return orderList;
    }

    @GetMapping("/{seq}")
    public Order getOrderById(@PathVariable int seq){
        Order getOrder = this.orderService.getOrderById(seq);
        return getOrder;
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order){
        Order createdOrder = this.orderService.createOrder(order);
        return createdOrder;
    }

    @PutMapping("/{seq}")
    public Order updateOrder(@PathVariable int seq,@RequestBody Order order) {
        //url = localhost:8080/api/vi/user/1
        Order updatedOrder = this.orderService.updateOrder(seq, order);
        return updatedOrder;
    }

    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable int seq){
        Order deletedOrder = this.orderService.deleteOrder(seq);
        return deletedOrder;
    }

}
