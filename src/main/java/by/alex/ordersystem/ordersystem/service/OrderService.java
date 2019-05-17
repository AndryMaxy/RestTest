package by.alex.ordersystem.ordersystem.service;

import by.alex.ordersystem.ordersystem.domain.Order;

import java.util.List;

public interface OrderService extends Service<Order, Long> {

    List<Order> getOrdersByStatus(String status);
}
