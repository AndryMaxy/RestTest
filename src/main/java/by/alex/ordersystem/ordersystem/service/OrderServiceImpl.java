package by.alex.ordersystem.ordersystem.service;

import by.alex.ordersystem.ordersystem.domain.Order;
import by.alex.ordersystem.ordersystem.repositorty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Optional<Order> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> getOrdersByStatus(String statusStr) {
        Order.Status status = Order.Status.valueOf(statusStr.toUpperCase());
        return repository.getOrdersByStatus(status);
    }

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
