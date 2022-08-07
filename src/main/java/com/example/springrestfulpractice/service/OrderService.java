package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orderList;
    private List<Meal> mealList1;
    private List<Meal> mealList2;

    public OrderService(){
        this.mealList1 = new ArrayList<>();
        mealList1.add(new Meal("Pancake", 100, "Recommend!"));
        mealList1.add(new Meal("Apple", 34, "This 'apple' not 'Apple'! "));

        this.mealList2 = new ArrayList<>();
        mealList2.add(new Meal("Apple Pie", 150, "Yummy!"));
        mealList2.add(new Meal("Grape", 300, "Expensive!"));

        this.orderList = new ArrayList<>();
        this.orderList.add(new Order(1, 255, "Love", mealList1));
        this.orderList.add(new Order(2, 200, "Mike", mealList2));
    }

    public List<Order> getAllOrders(){
        return this.orderList;
    }

    public Order getOrderById(int seq){
        for(Order order: this.orderList){
            if(seq == order.getSeq()){
                return order;
            }
        }
        return null;
    }

    public Order createOrder(Order order){
        this.orderList.add(order);
        return order;
    }
    public Order updateOrder(int seq, Order order){
        for(Order updatedOrder:this.orderList){
            if(seq == updatedOrder.getSeq()){
                updatedOrder.setTotalPrice(order.getTotalPrice());
                updatedOrder.setWaiter(order.getWaiter());
                updatedOrder.setMealList(order.getMealList());
                return updatedOrder;
            }
        }
        return null;
    }

    public Order deleteOrder(int seq){
        for(Order order:this.orderList){
            if(seq == order.getSeq()){
                this.orderList.remove(order);
                return order;
            }
        }
        return null;
    }
}
